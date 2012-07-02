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
package org.spout.bukkit.wgen;

import java.lang.reflect.Method;

import org.bukkit.Material;
import org.bukkit.WorldCreator;
import org.bukkit.generator.ChunkGenerator;

import org.spout.api.generator.Populator;
import org.spout.api.generator.WorldGenerator;
import org.spout.api.generator.WorldGeneratorUtils;
import org.spout.api.generator.biome.Biome;
import org.spout.api.generator.biome.BiomeManager;
import org.spout.api.generator.biome.Simple2DBiomeManager;
import org.spout.api.geo.World;
import org.spout.api.geo.cuboid.Chunk;
import org.spout.api.util.cuboid.CuboidShortBuffer;

import org.spout.bukkit.BridgeWorld;

public class BridgeWorldGenerator implements WorldGenerator {
	private final WorldCreator backing;
	private final ChunkGenerator generator;
	private BridgeBiomeGrid bbg;

	public BridgeWorldGenerator(WorldCreator wc) {
		backing = wc;
		ChunkGenerator temp = wc.generator();
		if (temp == null) {
			;
		}
		generator = temp;
	}

	@Override
	public BiomeManager generate(CuboidShortBuffer buffer, int chunkX, int chunkY, int chunkZ) {
		if (bbg == null) {
			bbg = new BridgeBiomeGrid(buffer.getWorld());
		}
		generator.generateExtBlockSections(new BridgeWorld(buffer.getWorld()), WorldGeneratorUtils.getRandom(buffer.getWorld(), chunkX, chunkY, chunkZ, 0), chunkX, chunkZ, bbg);

		Method m = null;
		try {
			m = Biome.class.getDeclaredMethod("getId");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		m.setAccessible(true);

		int x = chunkX << Chunk.BLOCKS.BITS;
		int z = chunkZ << Chunk.BLOCKS.BITS;
		Simple2DBiomeManager biomeManager = new Simple2DBiomeManager(chunkX, chunkY, chunkZ);
		byte[] biomeData = new byte[Chunk.BLOCKS.AREA];
		for (int dx = x; dx < x + Chunk.BLOCKS.SIZE; ++dx) {
			for (int dz = z; dz < z + Chunk.BLOCKS.SIZE; ++dz) {
				Biome biome = bbg.getVanillaBiome(dx, dz);
				try {
					biomeData[((dz & Chunk.BLOCKS.MASK) << 4 | dx & Chunk.BLOCKS.MASK)] = (Byte) m.invoke(biome);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
		biomeManager.deserialize(biomeData);
		return biomeManager;
	}

	@Override
	public String getName() {
		return backing.name();
	}

	@Override
	public Populator[] getPopulators() {
		return new Populator[0];
	}

	@Override
	public int[][] getSurfaceHeight(World w, int chunkX, int chunkZ) {
		int[][] heights = new int[Chunk.BLOCKS.SIZE][Chunk.BLOCKS.SIZE];
		for (int x = 0; x < Chunk.BLOCKS.SIZE; x++) {
			for (int z = 0; z < Chunk.BLOCKS.SIZE; z++) {
				int y = 0;
				for (int i = 256; i > 0; i--) {
					if (w.getBlockMaterial(x + (chunkX * Chunk.BLOCKS.SIZE), y, z + (chunkX * Chunk.BLOCKS.SIZE)).equals(Material.AIR)) {
						break;
					}
				}
				heights[x][z] = y;
			}
		}
		return heights;
	}
}
