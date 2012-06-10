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

import org.bukkit.block.Biome;
import org.bukkit.generator.ChunkGenerator.BiomeGrid;
import org.spout.api.geo.World;
import org.spout.api.geo.discrete.Point;
import org.spout.bukkit.util.BridgeUtil;

public class BridgeBiomeGrid implements BiomeGrid {
	private BridgeBiomeGridSelector sel;
	private World world;
	
	public BridgeBiomeGrid(World world) {
		sel = new BridgeBiomeGridSelector();
		this.world = world;
	}
	
	@Override
	public Biome getBiome(int x, int z) {
		return BridgeUtil.toBiome(getVanillaBiome(x,z));
	}

	@Override
	public void setBiome(int x, int z, Biome biome) {
		sel.setBiome(new Point(world, x, 0, z), BridgeUtil.toVanillaBiome(biome));
	}

	public org.spout.api.generator.biome.Biome getVanillaBiome(int x, int z) {
		return sel.pickBiome(x, z, world.getSeed());
	}

}
