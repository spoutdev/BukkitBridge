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
import org.bukkit.block.Furnace;
import org.bukkit.inventory.FurnaceInventory;

import org.spout.bridge.bukkit.inventory.BridgeInventoryFurnace;

public class BridgeFurnace extends BridgeBlockState implements Furnace {
	private final org.spout.vanilla.component.block.material.Furnace furnace;

	public BridgeFurnace(Block b) {
		super(b);
		this.furnace = (org.spout.vanilla.component.block.material.Furnace) getHandle();
	}

	@Override
	public short getBurnTime() {
		return (short) furnace.getFuel();
	}

	@Override
	public void setBurnTime(short paramShort) {
		furnace.setFuel(paramShort);
	}

	@Override
	public short getCookTime() {
		return (short) furnace.getSmeltTime();
	}

	@Override
	public void setCookTime(short paramShort) {
		furnace.setSmeltTime(paramShort);
	}

	@Override
	public FurnaceInventory getInventory() {
		return new BridgeInventoryFurnace(furnace.getInventory(), this);
	}
}
