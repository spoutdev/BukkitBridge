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
package org.spout.bukkit.util;

import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.util.Vector;

import org.spout.api.geo.discrete.Point;
import org.spout.api.geo.discrete.Transform;
import org.spout.api.math.Quaternion;
import org.spout.api.math.Vector3;
import org.spout.bukkit.BridgeWorld;
import org.spout.vanilla.world.generator.VanillaBiome;
import org.spout.vanilla.world.generator.normal.biome.BeachBiome;
import org.spout.vanilla.world.generator.normal.biome.DesertBiome;
import org.spout.vanilla.world.generator.normal.biome.ForestBiome;
import org.spout.vanilla.world.generator.normal.biome.JungleBiome;
import org.spout.vanilla.world.generator.normal.biome.MountainsBiome;
import org.spout.vanilla.world.generator.normal.biome.MushroomBiome;
import org.spout.vanilla.world.generator.normal.biome.OceanBiome;
import org.spout.vanilla.world.generator.normal.biome.PlainBiome;
import org.spout.vanilla.world.generator.normal.biome.RiverBiome;
import org.spout.vanilla.world.generator.normal.biome.SmallMountainsBiome;
import org.spout.vanilla.world.generator.normal.biome.SwampBiome;
import org.spout.vanilla.world.generator.normal.biome.TaigaBiome;
import org.spout.vanilla.world.generator.normal.biome.TundraBiome;

public class BridgeUtil {
	public static Location toLocation(Point p) {
		return new Location(new BridgeWorld(p.getWorld()), p.getX(), p.getY(), p.getZ());
	}

	public static Location toLocation(Transform t) {
		return toLocation(t.getPosition(), t.getRotation());
	}

	public static Location toLocation(Point p, Quaternion q) {
		return new Location(new BridgeWorld(p.getWorld()), p.getX(), p.getY(), p.getZ(), q.getYaw(), q.getPitch());
	}

	public static Point toPoint(Location loc) {
		return new Point(((BridgeWorld) loc.getWorld()).getSpoutWorld(), (float) loc.getX(), (float) loc.getY(), (float) loc.getZ());
	}

	public static Vector3 toVector(Vector vec) {
		return new Vector3(vec.getX(), vec.getY(), vec.getZ());
	}

	public static Vector toVector(Vector3 vec) {
		return new Vector(vec.getX(), vec.getY(), vec.getZ());
	}
	
	public static Biome toBiome(org.spout.api.generator.biome.Biome biome) {
		if(!(biome instanceof VanillaBiome)) return null;
		if(biome instanceof BeachBiome) return Biome.BEACH;
		if(biome instanceof DesertBiome) return Biome.DESERT;
		if(biome instanceof ForestBiome) return Biome.FOREST;
		if(biome instanceof JungleBiome) return Biome.JUNGLE;
		if(biome instanceof MountainsBiome) return Biome.EXTREME_HILLS;
		if(biome instanceof MushroomBiome) return Biome.MUSHROOM_ISLAND;
		if(biome instanceof OceanBiome) return Biome.OCEAN;
		if(biome instanceof PlainBiome) return Biome.PLAINS;
		if(biome instanceof RiverBiome) return Biome.RIVER;
		if(biome instanceof SmallMountainsBiome) return Biome.SMALL_MOUNTAINS;
		if(biome instanceof SwampBiome) return Biome.SWAMPLAND;
		if(biome instanceof TaigaBiome) return Biome.TAIGA;
		if(biome instanceof TundraBiome) return Biome.TUNDRA;
		return null;
	}
}
