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
package org.spout.bridge.bukkit.block;

import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import org.spout.bridge.bukkit.inventory.BridgeInventory;

public class BridgeDispenser extends BridgeBlockState implements Dispenser {
	private final org.spout.vanilla.component.block.material.Dispenser dispenser;

	public BridgeDispenser(Block b) {
		super(b);
		this.dispenser = (org.spout.vanilla.component.block.material.Dispenser) getHandle();
	}

	@Override
	public Inventory getInventory() {
		return new BridgeInventory(dispenser.getInventory(), this, "container.dispenser", "Dispenser", InventoryType.DISPENSER);
	}

	@Override
	public boolean dispense() {
		throw new UnsupportedOperationException();
	}
}
