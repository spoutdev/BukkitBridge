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

import java.util.HashMap;
import java.util.Map;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import org.spout.api.geo.discrete.Point;
import org.spout.api.geo.discrete.Transform;
import org.spout.api.material.MaterialRegistry;
import org.spout.api.math.Quaternion;
import org.spout.api.math.Vector3;

import org.spout.bukkit.BridgeWorld;

import org.spout.vanilla.world.generator.VanillaBiomes;

public class BridgeUtil {
	private static final Map<org.spout.api.generator.biome.Biome, Biome> spoutBiomeMap = new HashMap<org.spout.api.generator.biome.Biome, Biome>();

	static {
		spoutBiomeMap.put(VanillaBiomes.OCEAN, Biome.OCEAN);
		spoutBiomeMap.put(VanillaBiomes.PLAIN, Biome.PLAINS);
		spoutBiomeMap.put(VanillaBiomes.DESERT, Biome.DESERT);
		spoutBiomeMap.put(VanillaBiomes.DESERT_HILLS, Biome.DESERT_HILLS);
		spoutBiomeMap.put(VanillaBiomes.MOUNTAINS, Biome.EXTREME_HILLS);
		spoutBiomeMap.put(VanillaBiomes.FOREST, Biome.FOREST);
		spoutBiomeMap.put(VanillaBiomes.FOREST_HILLS, Biome.FOREST_HILLS);
		spoutBiomeMap.put(VanillaBiomes.TAIGA, Biome.TAIGA);
		spoutBiomeMap.put(VanillaBiomes.TAIGA_HILLS, Biome.TAIGA_HILLS);
		spoutBiomeMap.put(VanillaBiomes.SWAMP, Biome.SWAMPLAND);
		spoutBiomeMap.put(VanillaBiomes.RIVER, Biome.RIVER);
		spoutBiomeMap.put(VanillaBiomes.FROZEN_RIVER, Biome.FROZEN_OCEAN);
		spoutBiomeMap.put(VanillaBiomes.NETHERRACK, Biome.HELL);
		spoutBiomeMap.put(VanillaBiomes.TUNDRA, Biome.TUNDRA);
		spoutBiomeMap.put(VanillaBiomes.TUNDRA_HILLS, Biome.TUNDRA);
		spoutBiomeMap.put(VanillaBiomes.MUSHROOM, Biome.MUSHROOM_ISLAND);
		spoutBiomeMap.put(VanillaBiomes.MUSHROOM_SHORE, Biome.MUSHROOM_SHORE);
		spoutBiomeMap.put(VanillaBiomes.BEACH, Biome.BEACH);
		spoutBiomeMap.put(VanillaBiomes.SMALL_MOUNTAINS, Biome.SMALL_MOUNTAINS);
		spoutBiomeMap.put(VanillaBiomes.JUNGLE, Biome.JUNGLE);
		spoutBiomeMap.put(VanillaBiomes.JUNGLE_HILLS, Biome.JUNGLE_HILLS);
		spoutBiomeMap.put(VanillaBiomes.FROZEN_OCEAN, Biome.FROZEN_OCEAN);
		spoutBiomeMap.put(VanillaBiomes.ENDSTONE, Biome.SKY);
	}

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

	public static ItemStack toItemStack(org.spout.api.inventory.ItemStack itemStack) {
		return new ItemStack(toMaterial(itemStack.getMaterial()), itemStack.getAmount());  //TODO: Implement durability/damage and data
	}

	public static org.spout.api.inventory.ItemStack toSpoutItemStack(ItemStack itemStack) {
		return new org.spout.api.inventory.ItemStack(toSpoutMaterial(itemStack.getType()), itemStack.getAmount());  //TODO: Implement durability/damage and data
	}

	public static Material toMaterial(org.spout.api.material.Material material) {
		return Material.getMaterial(material.getName());
	}

	public static org.spout.api.material.Material toSpoutMaterial(Material material) {
		return MaterialRegistry.get(material.name());
	}

	public static Biome toBiome(org.spout.api.generator.biome.Biome biome) {
		return spoutBiomeMap.get(biome);
	}

	public static org.spout.api.generator.biome.Biome toSpoutBiome(Biome biome) {
		switch (biome) {
			case FOREST:
			case RAINFOREST:
			case SEASONAL_FOREST:
				return VanillaBiomes.FOREST;
			case SWAMPLAND:
				return VanillaBiomes.SWAMP;
			case ICE_DESERT:
			case DESERT:
			case SAVANNA:
				return VanillaBiomes.DESERT;
			case ICE_PLAINS:
			case PLAINS:
			case SHRUBLAND:
				return VanillaBiomes.PLAIN;
			case TAIGA:
				return VanillaBiomes.TAIGA;
			case TUNDRA:
				return VanillaBiomes.TUNDRA;
			case HELL:
				return VanillaBiomes.NETHERRACK;
			case SKY:
				return VanillaBiomes.ENDSTONE;
			case OCEAN:
				return VanillaBiomes.OCEAN;
			case RIVER:
				return VanillaBiomes.RIVER;
			case EXTREME_HILLS:
				return VanillaBiomes.MOUNTAINS;
			case FROZEN_OCEAN:
				return VanillaBiomes.FROZEN_OCEAN;
			case FROZEN_RIVER:
				return VanillaBiomes.FROZEN_RIVER;
			case ICE_MOUNTAINS:
			case SMALL_MOUNTAINS:
				return VanillaBiomes.SMALL_MOUNTAINS;
			case MUSHROOM_ISLAND:
				return VanillaBiomes.MUSHROOM;
			case MUSHROOM_SHORE:
				return VanillaBiomes.MUSHROOM_SHORE;
			case BEACH:
				return VanillaBiomes.BEACH;
			case DESERT_HILLS:
				return VanillaBiomes.DESERT_HILLS;
			case FOREST_HILLS:
				return VanillaBiomes.FOREST_HILLS;
			case TAIGA_HILLS:
				return VanillaBiomes.TAIGA_HILLS;
			case JUNGLE:
				return VanillaBiomes.JUNGLE;
			case JUNGLE_HILLS:
				return VanillaBiomes.JUNGLE_HILLS;
			default:
				return null;
		}
	}

	public static GameMode toGameMode(org.spout.vanilla.data.GameMode gameMode) {
		switch (gameMode) {
			case SURVIVAL:
				return GameMode.SURVIVAL;
			case CREATIVE:
				return GameMode.CREATIVE;
			default:
				return null;
		}
	}

	public static org.spout.vanilla.data.GameMode toVanillaGameMode(GameMode gameMode) {
		switch (gameMode) {
			case SURVIVAL:
				return org.spout.vanilla.data.GameMode.SURVIVAL;
			case CREATIVE:
				return org.spout.vanilla.data.GameMode.CREATIVE;
			default:
				return null;
		}
	}
}
