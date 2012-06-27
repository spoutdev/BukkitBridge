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
package org.spout.bukkit.block;

import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;

public class BridgeChest extends BridgeBlockState implements Chest {
	private final org.spout.vanilla.controller.block.Chest chest;

	public BridgeChest(Block block, org.spout.vanilla.controller.block.Chest chest) {
		super(block);
		this.chest = chest;
	}

	@Override
	public Inventory getInventory() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Inventory getBlockInventory() {
		return null;  //TODO: Adjust for usage with Spout!
	}
}
