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
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.spout.api.event.EventHandler;
import org.spout.api.event.block.BlockChangeEvent;
import org.spout.api.event.cause.PlayerCause;
import org.spout.bridge.BukkitUtil;
import org.spout.bridge.VanillaBridgePlugin;
import org.spout.bridge.bukkit.entity.BridgePlayer;
import org.spout.vanilla.component.inventory.PlayerInventory;
import org.spout.vanilla.event.block.RedstoneChangeEvent;
import org.spout.vanilla.event.cause.PlayerBreakCause;
import org.spout.vanilla.event.cause.PlayerPlacementCause;

public class BlockListener extends AbstractListener{
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
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockChangeEvent event) {
		if(event.isCancelled()) {
			return;
		}
		if(!(event.getCause() instanceof PlayerBreakCause)) {
			return;
		}
		PlayerCause pcause = (PlayerCause) event.getCause();
		BlockBreakEvent breakEvent = new BlockBreakEvent(BukkitUtil.fromBlock(event.getBlock()), new BridgePlayer(pcause.getSource()));
		Bukkit.getPluginManager().callEvent(breakEvent);
		event.setCancelled(breakEvent.isCancelled());
		//TODO exp drops and such!
	}
	
	//public BlockPlaceEvent(final Block placedBlock, final BlockState replacedBlockState, 
	//final Block placedAgainst,
	//final ItemStack itemInHand, final Player thePlayer, final boolean canBuild) 
	
	@EventHandler
	public void onBlockPlace(BlockChangeEvent event) {
		if(event.isCancelled()) {
			return;
		}
		if(!(event.getCause() instanceof PlayerPlacementCause)) {
			return;
		}
		PlayerPlacementCause pcause = (PlayerPlacementCause) event.getCause();
		//PlayerInventory pinv = pcause.getSource().get(PlayerInventory.class);
		//BlockPlaceEvent breakEvent = new BlockPlaceEvent(BukkitUtil.fromBlock(event.getBlock()), null,null,BukkitUtil.fromItemStack(pinv.getQuickbar().getCurrentItem()), new BridgePlayer(pcause.getSource()), event.isCancelled());
		//Bukkit.getPluginManager().callEvent(breakEvent);
		//event.setCancelled(breakEvent.isCancelled());
	}
	
	
}