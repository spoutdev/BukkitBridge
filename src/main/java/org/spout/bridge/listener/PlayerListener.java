package org.spout.bridge.listener;

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
import org.spout.api.event.player.PlayerLoginEvent;

import org.spout.bridge.BukkitUtil;
import org.spout.bridge.VanillaBridgePlugin;
import org.spout.bridge.bukkit.entity.BridgePlayer;
import org.spout.bridge.bukkit.entity.EntityFactory;
import org.spout.bridge.player.PlayerMoveComponent;
import org.spout.vanilla.component.living.Human;

public class PlayerListener extends AbstractListener {
	public PlayerListener(VanillaBridgePlugin plugin) {
		super(plugin);
	}

	@EventHandler(order = Order.EARLIEST)
	public void onPlayerLogin(PlayerLoginEvent event) {
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
	public void onPlayerKick(PlayerKickEvent event) {
		BridgePlayer player = EntityFactory.createPlayer(event.getPlayer());
		final String kickMessage = event.getKickReason().asString();
		final String leaveMessage = event.getMessage().asString();
		org.bukkit.event.player.PlayerKickEvent kick = new org.bukkit.event.player.PlayerKickEvent(player, kickMessage, leaveMessage);
		kick.setCancelled(event.isCancelled());
		Bukkit.getPluginManager().callEvent(kick);
		if (!kickMessage.equals(kick.getReason())) {
			event.setKickReason(kick.getReason());
		}
		if (!leaveMessage.equals(kick.getLeaveMessage())) {
			event.setMessage(kick.getLeaveMessage());
		}
		event.setCancelled(kick.isCancelled());
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
		ItemStack item = BukkitUtil.fromItemStack(human.getInventory().getQuickbar().getCurrentItem());
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
}
