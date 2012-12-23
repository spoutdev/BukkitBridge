/*
 * This file is part of BukkitBridge.
 *
 * Copyright (c) 2012, VanillaDev <http://www.spout.org/>
 * BukkitBridge is licensed under the GNU General Public License.
 *
 * BukkitBridge is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BukkitBridge is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.spout.bridge.listener;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.inventory.ItemStack;

import org.spout.api.event.EventHandler;
import org.spout.api.event.Order;
import org.spout.api.event.player.PlayerInteractEvent;
import org.spout.api.event.player.PlayerInteractEvent.Action;
import org.spout.api.event.player.PlayerJoinEvent;
import org.spout.api.event.player.PlayerKickEvent;
import org.spout.api.event.player.PlayerLeaveEvent;
import org.spout.api.event.player.PlayerLoginEvent;
import org.spout.api.event.player.PlayerPreLoginEvent;

import org.spout.bridge.BukkitUtil;
import org.spout.bridge.VanillaBridgePlugin;
import org.spout.bridge.bukkit.entity.BridgePlayer;
import org.spout.bridge.bukkit.entity.EntityFactory;
import org.spout.bridge.player.PlayerMoveComponent;

import org.spout.vanilla.component.inventory.PlayerInventory;
import org.spout.vanilla.component.living.neutral.Human;
import org.spout.vanilla.event.player.PlayerRespawnEvent;

public class PlayerListener extends AbstractListener {
	/**
	 * Maintains a list of players from prelogin events to kick on login events, as Spout does not allow kicking in prelogin
	 */
	private Map<String, String> toKick = new ConcurrentHashMap<String, String>();

	public PlayerListener(VanillaBridgePlugin plugin) {
		super(plugin);
	}

	@EventHandler(order = Order.EARLIEST)
	public void onPlayerLogin(PlayerLoginEvent event) {
		//Handle the bukkit prelogin kicks
		String kickMessage = toKick.remove(event.getPlayer().getName());
		if (kickMessage != null) {
			event.setAllowed(false);
			event.setMessage(kickMessage);
			return;
		}

		BridgePlayer player = EntityFactory.createPlayer(event.getPlayer());
		String hostname = event.getPlayer().getAddress().getHostName();
		org.bukkit.event.player.PlayerLoginEvent login = new org.bukkit.event.player.PlayerLoginEvent(player, hostname, event.getPlayer().getAddress());
		if (!event.isAllowed()) {
			login.disallow(Result.KICK_OTHER, event.getMessage().asString());
		}
		Bukkit.getPluginManager().callEvent(login);
		if (login.getResult() != Result.ALLOWED) {
			event.disallow(login.getKickMessage());
		}
	}

	@EventHandler(order = Order.EARLIEST)
	public void onPlayerJoin(PlayerJoinEvent event) {
		//Refire event
		BridgePlayer player = EntityFactory.createPlayer(event.getPlayer());
		final String joinMessage = event.getMessage().asString();
		org.bukkit.event.player.PlayerJoinEvent join = new org.bukkit.event.player.PlayerJoinEvent(player, joinMessage);
		Bukkit.getPluginManager().callEvent(join);
		if (!joinMessage.equals(join.getJoinMessage())) {
			event.setMessage(join.getJoinMessage());
		}

		//Add components
		event.getPlayer().add(PlayerMoveComponent.class);
	}

	@EventHandler(order = Order.EARLIEST)
	public void onPlayerLeave(PlayerLeaveEvent event) {
		BridgePlayer player = EntityFactory.createPlayer(event.getPlayer());
		final String leaveMessage = event.getMessage().asString();
		if (event instanceof PlayerKickEvent) {
			PlayerKickEvent kickEvent = (PlayerKickEvent) event;
			final String kickMessage = kickEvent.getKickReason().asString();
			org.bukkit.event.player.PlayerKickEvent kick = new org.bukkit.event.player.PlayerKickEvent(player, kickMessage, leaveMessage);
			kick.setCancelled(event.isCancelled());
			Bukkit.getPluginManager().callEvent(kick);
			if (!kickMessage.equals(kick.getReason())) {
				kickEvent.setKickReason(kick.getReason());
			}
			if (!leaveMessage.equals(kick.getLeaveMessage())) {
				kickEvent.setMessage(kick.getLeaveMessage());
			}
			kickEvent.setCancelled(kick.isCancelled());
		} else {
			org.bukkit.event.player.PlayerQuitEvent quit = new org.bukkit.event.player.PlayerQuitEvent(player, leaveMessage);
			Bukkit.getPluginManager().callEvent(quit);
		}
	}

	@EventHandler(order = Order.EARLIEST)
	public void onPlayerInteract(PlayerInteractEvent event) {
		BridgePlayer player = EntityFactory.createPlayer(event.getPlayer());
		Human human = event.getPlayer().get(Human.class);
		if (human == null) {
			return;
		}
		org.bukkit.event.block.Action bukkitAction;
		if (event.getAction() == Action.LEFT_CLICK) {
			if (event.isAir()) {
				bukkitAction = org.bukkit.event.block.Action.LEFT_CLICK_AIR;
			} else {
				bukkitAction = org.bukkit.event.block.Action.LEFT_CLICK_BLOCK;
			}
		} else if (event.getAction() == Action.RIGHT_CLICK) {
			if (event.isAir()) {
				bukkitAction = org.bukkit.event.block.Action.RIGHT_CLICK_AIR;
			} else {
				bukkitAction = org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK;
			}
		} else {
			bukkitAction = org.bukkit.event.block.Action.PHYSICAL;
		}
		ItemStack item = BukkitUtil.fromItemStack(event.getPlayer().get(PlayerInventory.class).getQuickbar().getCurrentItem());
		Block clickedBlock = null;
		if (event.getInteractedPoint() != null) {
			clickedBlock = player.getWorld().getBlockAt(event.getInteractedPoint().getBlockX(), event.getInteractedPoint().getBlockY(), event.getInteractedPoint().getBlockZ());
		}
		BlockFace face = BukkitUtil.toBukkitBlockFace(event.getClickedFace());
		org.bukkit.event.player.PlayerInteractEvent interactEvent = new org.bukkit.event.player.PlayerInteractEvent(player, bukkitAction, item, clickedBlock, face);
		Bukkit.getPluginManager().callEvent(interactEvent);
		if (interactEvent.isCancelled()) {
			event.setCancelled(true);
		}
		if (interactEvent.useItemInHand() != org.bukkit.event.Event.Result.DEFAULT) {
			if (interactEvent.useItemInHand() == org.bukkit.event.Event.Result.ALLOW) {
				event.setUseItemInHand(org.spout.api.event.Result.ALLOW);
			} else {
				event.setUseItemInHand(org.spout.api.event.Result.DENY);
			}
		}
		if (interactEvent.useInteractedBlock() != org.bukkit.event.Event.Result.DEFAULT) {
			if (interactEvent.useInteractedBlock() == org.bukkit.event.Event.Result.ALLOW) {
				event.setInteractWithBlock(org.spout.api.event.Result.ALLOW);
			} else {
				event.setInteractWithBlock(org.spout.api.event.Result.DENY);
			}
		}
	}

	@EventHandler
	public void onAsyncPlayerChat() {
		//todo implement onAsyncPlayerChat
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerAnimation() {
		//todo implement onPlayerAnimation
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerAnimationType() {
		//todo implement onPlayerAnimationType
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerBedEnter() {
		//todo implement onPlayerBedEnter
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerBedLeave() {
		//todo implement onPlayerBedLeave
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerBucketEmpty() {
		//todo implement onPlayerBucketEmpty
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerBucket() {
		//todo implement onPlayerBucket
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerBucketFill() {
		//todo implement onPlayerBucketFill
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerChangedWorld() {
		//todo implement onPlayerChangedWorld
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerChannel() {
		//todo implement onPlayerChannel
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerChat() {
		//todo implement onPlayerChat
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerChatTabComplete() {
		//todo implement onPlayerChatTabComplete
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerCommandPreProcess() {
		//todo implement onPlayerCommandPreProcess
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerDropItem() {
		//todo implement onPlayerDropItem
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerEggThrow() {
		//todo implement onPlayerEggThrow
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayer() {
		//todo implement onPlayer
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerExpChange() {
		//todo implement onPlayerExpChange
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerFish() {
		//todo implement onPlayerFish
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerGameModeChange() {
		//todo implement onPlayerGameModeChange
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerInteractEntity() {
		//todo implement onPlayerInteractEntity
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerInventory() {
		//todo implement onPlayerInventory
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerItemBreak() {
		//todo implement onPlayerItemBreak
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerItemHeld() {
		//todo implement onPlayerItemHeld
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerKick() {
		//todo implement onPlayerKick
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerLevelChange() {
		//todo implement onPlayerLevelChange
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerMove() {
		//todo implement onPlayerMove
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerPickUpItem() {
		//todo implement onPlayerPickUpItem
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerPortal() {
		//todo implement onPlayerPortal
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("deprecation")
	@EventHandler(order = Order.EARLIEST)
	public void onPlayerPreLogin(PlayerPreLoginEvent event) {
		if (event.isCancelled()) {
			return;
		}
		//Do both events here because Spout login events are all async
		org.bukkit.event.player.AsyncPlayerPreLoginEvent asyncPreLogin = new org.bukkit.event.player.AsyncPlayerPreLoginEvent(event.getName(), event.getAddress());
		Bukkit.getPluginManager().callEvent(asyncPreLogin);
		if (asyncPreLogin.getLoginResult() != org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result.ALLOWED) {
			toKick.put(asyncPreLogin.getName(), asyncPreLogin.getKickMessage());
			return;
		}
		org.bukkit.event.player.PlayerPreLoginEvent preLogin = new org.bukkit.event.player.PlayerPreLoginEvent(event.getName(), event.getAddress());
		Bukkit.getPluginManager().callEvent(preLogin);
		if (preLogin.getResult() != org.bukkit.event.player.PlayerPreLoginEvent.Result.ALLOWED) {
			toKick.put(preLogin.getName(), preLogin.getKickMessage());
			return;
		}
	}

	@EventHandler
	public void onPlayerRegisterChannel() {
		//todo implement onPlayerRegisterChannel
		throw new UnsupportedOperationException();
	}

	@EventHandler(order = Order.EARLIEST)
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		if (event.isCancelled()) {
			return;
		}
		BridgePlayer player = EntityFactory.createPlayer(event.getPlayer());
		org.bukkit.event.player.PlayerRespawnEvent respawn = new org.bukkit.event.player.PlayerRespawnEvent(player, BukkitUtil.fromPoint(event.getPoint()), false);
		Bukkit.getPluginManager().callEvent(respawn);
		event.setPoint(BukkitUtil.toPoint(respawn.getRespawnLocation()));
	}

	@EventHandler
	public void onPlayerShearEntity() {
		//todo implement onPlayerShearEntity
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerToggleFlight() {
		//todo implement onPlayerToggleFlight
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerToggleSneak() {
		//todo implement onPlayerToggleSneak
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerToggleSprint() {
		//todo implement onPlayerToggleSprint
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerUnregisterChannel() {
		//todo implement onPlayerUnregisterChannel
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerVelocity() {
		//todo implement onPlayerVelocity
		throw new UnsupportedOperationException();
	}
}
