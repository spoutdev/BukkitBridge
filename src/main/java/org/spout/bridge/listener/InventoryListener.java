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

import org.spout.api.event.EventHandler;

import org.spout.bridge.BukkitUtil;
import org.spout.bridge.VanillaBridgePlugin;

import org.spout.vanilla.event.block.FurnaceBurnEvent;
import org.spout.vanilla.event.block.FurnaceSmeltEvent;

public class InventoryListener extends AbstractListener {
	public InventoryListener(VanillaBridgePlugin plugin) {
		super(plugin);
	}

	@EventHandler
	public void onBrew(){
		//todo implement onBrew
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onCraftItem(){
		//todo implement onCraftItem
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onFurnaceBurn(FurnaceBurnEvent event) {
		if (event.isCancelled()) {
			return;
		}
		// todo check if the burntime float is correctly moved over to the int value and back
		org.bukkit.event.inventory.FurnaceBurnEvent furnaceBurnEvent = new org.bukkit.event.inventory.FurnaceBurnEvent(BukkitUtil.fromBlock(event.getBlock()), BukkitUtil.fromItemStack(event.getFuel()),Math.round(event.getBurnTime()));
		Bukkit.getPluginManager().callEvent(furnaceBurnEvent);
		event.setCancelled(furnaceBurnEvent.isCancelled());
		if (furnaceBurnEvent.getBurnTime() != Math.round(event.getBurnTime())) {
			event.setBurnTime(furnaceBurnEvent.getBurnTime());
		}
		if (furnaceBurnEvent.isBurning() != event.isBurning()) {
			event.setBurning(furnaceBurnEvent.isBurning());
		}
	}

	@EventHandler
	public void onFurnaceExtract(){
		//todo implement onFurnaceExtract
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onFurnaceSmelt(FurnaceSmeltEvent event) {
		if (event.isCancelled()) {
			return;
		}
		org.bukkit.event.inventory.FurnaceSmeltEvent furnaceSmeltEvent = new org.bukkit.event.inventory.FurnaceSmeltEvent(BukkitUtil.fromBlock(event.getBlock()),BukkitUtil.fromItemStack(event.getSource()),BukkitUtil.fromItemStack(event.getResult()));
		Bukkit.getPluginManager().callEvent(furnaceSmeltEvent);
		event.setCancelled(furnaceSmeltEvent.isCancelled());
		if (furnaceSmeltEvent.getResult() != BukkitUtil.fromItemStack(event.getResult())) {
			event.setResult(BukkitUtil.toItemStack(furnaceSmeltEvent.getResult()));
		}
	}

	@EventHandler
	public void onInventoryClick(){
		//todo implement onInventoryClick
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onInventoryClose(){
		//todo implement onInventoryClose
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onInventory(){
		//todo implement onInventory
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onInventoryOpen(){
		//todo implement onInventoryOpen
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onInventoryType(){
		//todo implement onInventoryType
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPrepareItemCraft(){
		//todo implement onPreprareItemCraft
		throw new UnsupportedOperationException();
	}
}
