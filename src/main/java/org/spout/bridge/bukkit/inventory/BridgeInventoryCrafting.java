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

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import org.spout.api.inventory.Inventory;

import org.spout.bridge.bukkit.entity.BridgePlayer;

public class BridgeInventoryCrafting extends BridgeInventory implements CraftingInventory {
	public BridgeInventoryCrafting(Inventory handle, BridgePlayer player) {
		super(handle, player, "container.crafting", "Crafting table", InventoryType.CRAFTING);
	}

	@Override
	public ItemStack getResult() {
		return getItem(((org.spout.vanilla.inventory.player.CraftingInventory) getHandle()).getOutputSlot());
	}

	@Override
	public ItemStack[] getMatrix() {
		ItemStack[] itemStacks = new ItemStack[getSize() - 1];

		for (int i = 0; i < itemStacks.length; i++) {
			if (i == ((org.spout.vanilla.inventory.player.CraftingInventory) getHandle()).getOutputSlot()) {
				continue;
			}
			itemStacks[i] = getItem(i);
		}

		return itemStacks;
	}

	@Override
	public void setResult(ItemStack itemStack) {
		setItem(((org.spout.vanilla.inventory.player.CraftingInventory) getHandle()).getOutputSlot(), itemStack);
	}

	@Override
	public void setMatrix(ItemStack[] itemStacks) {
		if (itemStacks.length > getSize() - 1) {
			throw new IllegalArgumentException("Invalid matrix size. A size of " + (getSize() - 1) + " or less expected.");
		}

		for (int i = 0; i < itemStacks.length; i++) {
			if (i == ((org.spout.vanilla.inventory.player.CraftingInventory) getHandle()).getOutputSlot()) {
				continue;
			}
			setItem(i, itemStacks[i]);
		}
	}

	@Override
	public Recipe getRecipe() {
		// TODO: Convert the results from a crafting inventory to a Bukkit recipe.
		throw new UnsupportedOperationException();
	}
}
