/*
 * This file is part of BukkitBridge.
 *
 * Copyright (c) 2012, SpoutDev <http://www.spout.org/>
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
package org.spout.bukkit;

import org.bukkit.ChunkSnapshot;
import org.bukkit.block.Biome;

public class BridgeChunkSnapshot implements ChunkSnapshot {
	@Override
	public int getX() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public int getZ() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public String getWorldName() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public int getBlockTypeId(int i, int i1, int i2) {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public int getBlockData(int i, int i1, int i2) {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public int getBlockSkyLight(int i, int i1, int i2) {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public int getBlockEmittedLight(int i, int i1, int i2) {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public int getHighestBlockYAt(int i, int i1) {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Biome getBiome(int i, int i1) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public double getRawBiomeTemperature(int i, int i1) {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public double getRawBiomeRainfall(int i, int i1) {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public long getCaptureFullTime() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isSectionEmpty(int i) {
		return false;  //TODO: Adjust for usage with Spout!
	}
}
