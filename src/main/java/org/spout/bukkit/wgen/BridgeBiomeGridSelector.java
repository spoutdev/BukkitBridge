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

import java.util.HashMap;
import java.util.Map;

import org.spout.api.generator.biome.Biome;
import org.spout.api.geo.discrete.Point;
import org.spout.api.math.Vector3;

import org.spout.vanilla.world.selector.VanillaBiomeSelector;

public class BridgeBiomeGridSelector extends VanillaBiomeSelector {
	private Map<Vector3, Biome> overrides = new HashMap<Vector3, Biome>();

	public BridgeBiomeGridSelector() {
		super(2); //TODO check this class
	}

	public Biome pickBiome(int x, int y, int z, long seed) {
		Vector3 loc = new Vector3(x, y, z);
		if (overrides.containsKey(loc)) {
			return overrides.get(loc);
		}
		return super.pickBiome(x, y, z, seed);
	}

	public void setBiome(Point loc, Biome biome) {
		if (super.pickBiome(loc.getFloorX(), loc.getFloorY(), loc.getFloorZ(), loc.getWorld().getSeed()).equals(biome)) {
			overrides.remove(loc);
		}
		overrides.remove(loc);
		overrides.put(loc, biome);
	}
}
