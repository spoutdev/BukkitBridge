/*
 * This file is part of BukkitBridge.
 *
 * Copyright (c) 2012 Spout LLC <http://www.spout.org/>
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
package org.spout.bridge.bukkit.inventory;

import org.bukkit.block.Furnace;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.ItemStack;

import org.spout.api.inventory.Inventory;

public class BridgeInventoryFurnace extends BridgeInventory implements FurnaceInventory {
	public BridgeInventoryFurnace(Inventory handle, Furnace holder) {
		super(handle, holder, "container.furnace", "Furnace", InventoryType.FURNACE);
	}

	@Override
	public ItemStack getResult() {
		return getItem(2);
	}

	@Override
	public ItemStack getFuel() {
		return getItem(0);
	}

	@Override
	public ItemStack getSmelting() {
		return getItem(1);
	}

	@Override
	public void setFuel(ItemStack itemStack) {
		setItem(0, itemStack);
	}

	@Override
	public void setResult(ItemStack itemStack) {
		setItem(2, itemStack);
	}

	@Override
	public void setSmelting(ItemStack itemStack) {
		setItem(1, itemStack);
	}

	@Override
	public Furnace getHolder() {
		return (Furnace) holder;
	}
}
