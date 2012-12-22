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

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.block.SignChangeEvent;

import org.spout.api.entity.Player;
import org.spout.api.event.EventHandler;
import org.spout.api.event.block.BlockChangeEvent;
import org.spout.api.event.block.BlockEvent;
import org.spout.api.event.cause.BlockCause;
import org.spout.api.event.cause.PlayerCause;

import org.spout.bridge.BukkitUtil;
import org.spout.bridge.VanillaBridgePlugin;
import org.spout.bridge.bukkit.entity.BridgePlayer;

import org.spout.vanilla.event.block.BlockDisappearEvent;
import org.spout.vanilla.event.block.BlockFormEvent;
import org.spout.vanilla.event.block.BlockGrowEvent;
import org.spout.vanilla.event.block.BlockIgniteEvent;
import org.spout.vanilla.event.block.RedstoneChangeEvent;
import org.spout.vanilla.event.block.SignUpdateEvent;
import org.spout.vanilla.event.cause.PlayerBreakCause;
import org.spout.vanilla.event.cause.PlayerPlacementCause;

public class BlockListener extends AbstractListener {
	public BlockListener(VanillaBridgePlugin plugin) {
		super(plugin);
	}

	@EventHandler
	public void onRedstoneChange(RedstoneChangeEvent event) {
		if (event.isCancelled()) {
			return;
		}

		BlockRedstoneEvent redstoneEvent = new BlockRedstoneEvent(BukkitUtil.fromBlock(event.getBlock()), event.getPreviousPower(), event.getNewPower());
		Bukkit.getPluginManager().callEvent(redstoneEvent);
		if (redstoneEvent.getNewCurrent() != event.getNewPower()) {
			event.setNewPower(redstoneEvent.getNewCurrent());
		}
	}

	@EventHandler
	public void onBlockBreak(BlockChangeEvent event) {
		if (event.isCancelled()) {
			return;
		}
		if (!(event.getCause() instanceof PlayerBreakCause)) {
			return;
		}
		PlayerCause pcause = (PlayerCause) event.getCause();
		BlockBreakEvent breakEvent = new BlockBreakEvent(BukkitUtil.fromBlock(event.getBlock()), new BridgePlayer(pcause.getSource()));
		Bukkit.getPluginManager().callEvent(breakEvent);
		event.setCancelled(breakEvent.isCancelled());
		//TODO finish onBlockBreak, exp drops and such!
	}

	//public BlockPlaceEvent(final Block placedBlock, final BlockState replacedBlockState,
	//final Block placedAgainst,
	//final ItemStack itemInHand, final Player thePlayer, final boolean canBuild) 

	@EventHandler
	public void onBlockPlace(BlockChangeEvent event) {
		if (event.isCancelled()) {
			return;
		}
		if (!(event.getCause() instanceof PlayerPlacementCause)) {
			return;
		}
		PlayerPlacementCause pcause = (PlayerPlacementCause) event.getCause();
		//todo finish onBlockPlace
		//PlayerInventory pinv = pcause.getSource().get(PlayerInventory.class);
		//BlockPlaceEvent breakEvent = new BlockPlaceEvent(BukkitUtil.fromBlock(event.getBlock()), null,null,BukkitUtil.fromItemStack(pinv.getQuickbar().getCurrentItem()), new BridgePlayer(pcause.getSource()), event.isCancelled());
		//Bukkit.getPluginManager().callEvent(breakEvent);
		//event.setCancelled(breakEvent.isCancelled());
	}

	@EventHandler
	public void onBlockBurn(BlockChangeEvent event) {
		//todo implement onBlockBurn
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onBlockCanBuild(BlockCanBuildEvent event) {
		//todo implement onBlockCanBuild
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onBlockDamage(BlockChangeEvent event) {
		//todo implement onBlockDamage
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onBlockDispense() {
		//todo implement onBlockDispense
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onBlockEvent(BlockEvent event) {
		//todo implement onBlockEvent
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onBlockExp() {
		//todo implement onBlockExp
		throw new UnsupportedOperationException();
	}

	/**
	 * Handles block fading to melting, fading and disappearance
	 * @param event
	 */
	@EventHandler
	public void onBlockFade(BlockDisappearEvent event) {
		if (event.isCancelled()) {
			return;
		}
		if (event.getDisappearCause() == BlockDisappearEvent.DisappearCause.DECAY) {
			return;
		}
		BlockFadeEvent fadeEvent = new BlockFadeEvent(BukkitUtil.fromBlock(event.getBlock()), BukkitUtil.getBlockState(event.getSnapshot()));
		Bukkit.getPluginManager().callEvent(fadeEvent);
		event.setCancelled(fadeEvent.isCancelled());
	}

	@EventHandler
	public void onBlockForm(BlockFormEvent event) {
		if (event.isCancelled()) {
			return;
		}
		if (event.getFormCause() == BlockFormEvent.FormCause.SPREAD) {
			return;
		}
		org.bukkit.event.block.BlockFormEvent  formEvent = new org.bukkit.event.block.BlockFormEvent(BukkitUtil.fromBlock(event.getBlock()), BukkitUtil.getBlockState(event.getSnapshot()));
		Bukkit.getPluginManager().callEvent(formEvent);
		event.setCancelled(formEvent.isCancelled());
	}

	@EventHandler
	public void onBlockFormTo() {
		//todo implement onBlockFormTo
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onBlockGrow(BlockGrowEvent event) {
		if (event.isCancelled()) {
			return;
		}
		org.bukkit.event.block.BlockGrowEvent growEvent = new org.bukkit.event.block.BlockGrowEvent(BukkitUtil.fromBlock(event.getBlock()), BukkitUtil.getBlockState(event.getSnapshot()));
		Bukkit.getPluginManager().callEvent(growEvent);
		event.setCancelled(growEvent.isCancelled());
	}

	@EventHandler
	public void onBlockIgnite(BlockIgniteEvent event) {
		if (event.isCancelled()) {
			return;
		}
		org.bukkit.event.block.BlockIgniteEvent.IgniteCause igniteCause;
		switch (event.getIgniteCause()) {
			case LAVA:
				igniteCause = org.bukkit.event.block.BlockIgniteEvent.IgniteCause.LAVA;
				break;
			case FLINT_AND_STEEL:
				igniteCause = org.bukkit.event.block.BlockIgniteEvent.IgniteCause.FLINT_AND_STEEL;
				break;
			case SPREAD:
				igniteCause = org.bukkit.event.block.BlockIgniteEvent.IgniteCause.SPREAD;
				break;
			case LIGHTING:
				igniteCause = org.bukkit.event.block.BlockIgniteEvent.IgniteCause.LIGHTNING;
				break;
			case FIREBALL:
				igniteCause = org.bukkit.event.block.BlockIgniteEvent.IgniteCause.FIREBALL;
				break;
			default:
				igniteCause = org.bukkit.event.block.BlockIgniteEvent.IgniteCause.SPREAD;
		}
		Player player = null;
		if (event.getCause() instanceof PlayerCause) {
			player = ((PlayerCause) event.getCause()).getSource();
		}
		org.bukkit.event.block.BlockIgniteEvent igniteEvent = new org.bukkit.event.block.BlockIgniteEvent(BukkitUtil.fromBlock(event.getBlock()),igniteCause, new BridgePlayer(player));
		Bukkit.getPluginManager().callEvent(igniteEvent);
		event.setCancelled(igniteEvent.isCancelled());
	}

	@EventHandler
	public void onBlockPhysics() {
		//todo implement onBlockPhysics
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onBlockPiston() {
		//todo implement onBlockPiston
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onBlockPistonExtend() {
		//todo implement onBlockPistonExtend
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onBlockPistonRetract() {
		//todo implement onBlockPistonRetract
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onBlockSpread(BlockFormEvent event) {
		if (event.isCancelled()) {
			return;
		}
		if (!(event.getCause() instanceof BlockCause)) {
			return;
		}
		if (event.getFormCause() != BlockFormEvent.FormCause.SPREAD) {
			return;
		}
		Block fromBlock = BukkitUtil.fromBlock(((BlockCause)event.getCause()).getSource());
		BlockSpreadEvent spreadEvent = new BlockSpreadEvent(BukkitUtil.fromBlock(event.getBlock()), fromBlock, BukkitUtil.getBlockState(event.getSnapshot()));
		Bukkit.getPluginManager().callEvent(spreadEvent);
		event.setCancelled(spreadEvent.isCancelled());
	}

	@EventHandler
	public void onEntityBlockForm() {
		//todo implement onEntityBlockForm
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onLeavesDecay(BlockDisappearEvent event) {
		if (event.isCancelled()) {
			return;
		}
		if (!(event.getDisappearCause() != BlockDisappearEvent.DisappearCause.DECAY)) {
			return;
		}
		LeavesDecayEvent decayEvent = new LeavesDecayEvent(BukkitUtil.fromBlock(event.getBlock()));
		Bukkit.getPluginManager().callEvent(decayEvent);
		event.setCancelled(decayEvent.isCancelled());
	}

	@EventHandler
	public void onNotePlay() {
		//todo implement onNotePlay
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onSignChange(SignUpdateEvent event) {
		if (event.isCancelled()) {
			return;
		}
		if (!(event.getSource() instanceof Player)) {
			return;
		}
		SignChangeEvent signChangeEvent = new SignChangeEvent(BukkitUtil.fromBlock(event.getSign().getBlock()), new BridgePlayer((Player) event.getSource()), event.getLines());
		Bukkit.getPluginManager().callEvent(signChangeEvent);
		event.setLines(signChangeEvent.getLines());
		event.setCancelled(signChangeEvent.isCancelled());
	}
}
