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
package org.spout.bukkit;

import org.bukkit.ChunkSnapshot;
import org.bukkit.block.Biome;

import org.spout.api.material.BlockMaterial;

import org.spout.bukkit.util.BridgeUtil;

import org.spout.vanilla.material.VanillaBlockMaterial;

public class BridgeChunkSnapshot implements ChunkSnapshot {
	private org.spout.api.geo.cuboid.ChunkSnapshot[] handle;
	private int[] highesty = new int[256];

	public BridgeChunkSnapshot(org.spout.api.geo.cuboid.ChunkSnapshot[] handle, boolean includeMaxblocky, boolean includeBiome, boolean includeBiomeTempRain) {
		this.handle = handle;

		if (includeMaxblocky) {
			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 16; j++) {
					int y = 0;
					for (y = handle[handle.length].getY() * 16 + 15; y > 0; y--) {
						if (handle[y / 16].getBlockMaterial(i, y, j).equals(BlockMaterial.AIR)) {
							break;
						}
					}
					highesty[i * 16 + j] = y;
				}
			}
		}
	}

	@Override
	public int getX() {
		return handle[0].getX();
	}

	@Override
	public int getZ() {
		return handle[0].getZ();
	}

	@Override
	public String getWorldName() {
		return handle[0].getWorld().getName();
	}

	@Override
	public int getBlockTypeId(int x, int y, int z) {
		BlockMaterial mat = handle[y / 16].getBlockMaterial(x, y, z);
		if (mat instanceof VanillaBlockMaterial) {
			return ((VanillaBlockMaterial) mat).getMinecraftId();
		} else {
			return mat.isSolid() ? 1 : 0;
		}
	}

	@Override
	public int getBlockData(int x, int y, int z) {
		BlockMaterial mat = handle[y / 16].getBlockMaterial(x, y, z);
		if (mat instanceof VanillaBlockMaterial) {
			return ((VanillaBlockMaterial) mat).getData();
		} else {
			return 0;
		}
	}

	@Override
	public int getBlockSkyLight(int x, int y, int z) {
		return handle[y / 16].getBlockSkyLight(x, y, z);
	}

	@Override
	public int getBlockEmittedLight(int x, int y, int z) {
		return handle[y / 16].getBlockLight(x, y, z);
	}

	@Override
	public int getHighestBlockYAt(int x, int z) {
		return highesty[x * 16 + z];
	}

	@Override
	public Biome getBiome(int x, int z) {
		return BridgeUtil.toBiome(handle[0].getBiomeType(x, 0, z));
	}

	@Override
	public double getRawBiomeTemperature(int x, int z) {
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
		return false; //TODO: Adjust for usage with Spout!
	}
}
