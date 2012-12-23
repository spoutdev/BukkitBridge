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
package org.spout.bridge.bukkit.inventory;

import org.bukkit.block.BrewingStand;
import org.bukkit.inventory.BrewerInventory;
import org.bukkit.inventory.ItemStack;

import org.spout.api.inventory.Inventory;

public class BridgeInventoryBrewer extends BridgeInventory implements BrewerInventory {
	public BridgeInventoryBrewer(Inventory handle, String name) {
		super(handle, name);
	}

	@Override
	public ItemStack getIngredient() {
		return getItem(3);
	}

	@Override
	public void setIngredient(ItemStack itemStack) {
		setItem(3, itemStack);
	}

	@Override
	public BrewingStand getHolder() {
		// TODO: Currently no way to get the holder of any Vanilla inventory.
		throw new UnsupportedOperationException();
	}
}
