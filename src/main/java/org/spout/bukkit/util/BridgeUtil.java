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
import org.spout.api.inventory.ItemStack;
import org.spout.api.material.Material;
import org.spout.api.material.MaterialRegistry;
import org.spout.api.math.Quaternion;
import org.spout.api.math.Vector3;
import org.spout.bukkit.BridgeWorld;
import org.spout.vanilla.world.generator.VanillaBiome;
import org.spout.vanilla.world.generator.VanillaBiomes;
import org.spout.vanilla.world.generator.nether.biome.NetherrackBiome;
import org.spout.vanilla.world.generator.normal.biome.shore.BeachBiome;
import org.spout.vanilla.world.generator.normal.biome.basic.DesertBiome;
import org.spout.vanilla.world.generator.normal.biome.basic.ForestBiome;
import org.spout.vanilla.world.generator.normal.biome.basic.JungleBiome;
import org.spout.vanilla.world.generator.normal.biome.basic.MountainsBiome;
import org.spout.vanilla.world.generator.normal.biome.basic.MushroomBiome;
import org.spout.vanilla.world.generator.normal.biome.basic.OceanBiome;
import org.spout.vanilla.world.generator.normal.biome.basic.PlainBiome;
import org.spout.vanilla.world.generator.normal.biome.basic.RiverBiome;
import org.spout.vanilla.world.generator.normal.biome.basic.SmallMountainsBiome;
import org.spout.vanilla.world.generator.normal.biome.shore.SwampBiome;
import org.spout.vanilla.world.generator.normal.biome.basic.TaigaBiome;
import org.spout.vanilla.world.generator.normal.biome.basic.TundraBiome;

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

	public static ItemStack toItemStack(org.bukkit.inventory.ItemStack itemStack) {
		Material material = MaterialRegistry.get(itemStack.getType().name());
		return new ItemStack(material, itemStack.getAmount());
	}
	
	public static Biome toBiome(org.spout.api.generator.biome.Biome biome) {
		if(!(biome instanceof VanillaBiome)) return null;
		if(biome instanceof BeachBiome) return Biome.BEACH;
		if(biome instanceof DesertBiome) return Biome.DESERT;
		if(biome instanceof ForestBiome) return Biome.FOREST;
		if(biome instanceof JungleBiome) return Biome.JUNGLE;
		if(biome instanceof MountainsBiome) return Biome.EXTREME_HILLS;
		if(biome instanceof MushroomBiome) return Biome.MUSHROOM_ISLAND;
		if(biome instanceof NetherrackBiome) return Biome.HELL;
		if(biome instanceof OceanBiome) return Biome.OCEAN;
		if(biome instanceof PlainBiome) return Biome.PLAINS;
		if(biome instanceof RiverBiome) return Biome.RIVER;
		if(biome instanceof SmallMountainsBiome) return Biome.SMALL_MOUNTAINS;
		if(biome instanceof SwampBiome) return Biome.SWAMPLAND;
		if(biome instanceof TaigaBiome) return Biome.TAIGA;
		if(biome instanceof TundraBiome) return Biome.TUNDRA;
		return null;
	}
	
	public static org.spout.api.generator.biome.Biome toVanillaBiome(Biome biome) {
		switch(biome) {
		case BEACH:
			return VanillaBiomes.BEACH;
		case ICE_DESERT:
		case DESERT: 
		case SAVANNA:
		case DESERT_HILLS:
			return VanillaBiomes.DESERT;
		case EXTREME_HILLS:
			return VanillaBiomes.MOUNTAINS;
		case FOREST: 
		case FOREST_HILLS:
		case RAINFOREST:
		case SEASONAL_FOREST: 
			return VanillaBiomes.FOREST;
		case FROZEN_OCEAN: 
		case OCEAN:
			return VanillaBiomes.OCEAN;
		case FROZEN_RIVER:
		case RIVER:
			return VanillaBiomes.RIVER;
		case HELL:
			return VanillaBiomes.NETHERRACK;
		case ICE_PLAINS:
		case PLAINS:
		case SHRUBLAND:
			return VanillaBiomes.PLAIN;
		case JUNGLE:
		case JUNGLE_HILLS:
			return VanillaBiomes.JUNGLE;
		case MUSHROOM_ISLAND:
		case MUSHROOM_SHORE:
			return VanillaBiomes.MUSHROOM;
		case ICE_MOUNTAINS: 
		case SMALL_MOUNTAINS:
			return VanillaBiomes.SMALL_MOUNTAINS;
		case SWAMPLAND:
			return VanillaBiomes.SWAMP;
		case TAIGA:
		case TAIGA_HILLS:
			return VanillaBiomes.TAIGA;
		case TUNDRA:
			return VanillaBiomes.TUNDRA;
		default:
			return null;
		}
	}
}
