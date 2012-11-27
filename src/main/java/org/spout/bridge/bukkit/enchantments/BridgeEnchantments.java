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
package org.spout.bridge.bukkit.enchantments;

import java.util.HashMap;
import java.util.Map;

import org.spout.vanilla.material.enchantment.Enchantments;

public class BridgeEnchantments {
	private static final Map<Integer, BridgeEnchantment> byId = new HashMap<Integer, BridgeEnchantment>();
	private static final Map<String, BridgeEnchantment> byName = new HashMap<String, BridgeEnchantment>();

	public static final BridgeEnchantment PROTECTION = register(new BridgeEnchantment(Enchantments.PROTECTION, 0));
	public static final BridgeEnchantment FIRE_PROTECTION = register(new BridgeEnchantment(Enchantments.FIRE_PROTECTION, 1));
	public static final BridgeEnchantment FEATHER_FALLING = register(new BridgeEnchantment(Enchantments.FEATHER_FALLING, 2));
	public static final BridgeEnchantment BLAST_PROTECTION = register(new BridgeEnchantment(Enchantments.BLAST_PROTECTION, 3));
	public static final BridgeEnchantment PROJECTILE_PROTECTION = register(new BridgeEnchantment(Enchantments.PROJECTILE_PROTECTION, 4));
	public static final BridgeEnchantment RESPIRATION = register(new BridgeEnchantment(Enchantments.RESPIRATION, 5));
	public static final BridgeEnchantment AQUA_AFFINITY = register(new BridgeEnchantment(Enchantments.AQUA_AFFINITY, 6));
	public static final BridgeEnchantment SHARPNESS = register(new BridgeEnchantment(Enchantments.SHARPNESS, 16));
	public static final BridgeEnchantment SMITE = register(new BridgeEnchantment(Enchantments.SMITE, 17));
	public static final BridgeEnchantment BANE_OF_ARTHROPODS = register(new BridgeEnchantment(Enchantments.BANE_OF_ARTHROPODS, 18));
	public static final BridgeEnchantment KNOCKBACK = register(new BridgeEnchantment(Enchantments.KNOCKBACK, 19));
	public static final BridgeEnchantment FIRE_ASPECT = register(new BridgeEnchantment(Enchantments.FIRE_ASPECT, 20));
	public static final BridgeEnchantment LOOTING = register(new BridgeEnchantment(Enchantments.LOOTING, 21));
	public static final BridgeEnchantment EFFICIENCY = register(new BridgeEnchantment(Enchantments.EFFICIENCY, 32));
	public static final BridgeEnchantment SILK_TOUCH = register(new BridgeEnchantment(Enchantments.SILK_TOUCH, 33));
	public static final BridgeEnchantment UNBREAKING = register(new BridgeEnchantment(Enchantments.UNBREAKING, 34));
	public static final BridgeEnchantment FORTUNE = register(new BridgeEnchantment(Enchantments.FORTUNE, 35));
	public static final BridgeEnchantment POWER = register(new BridgeEnchantment(Enchantments.POWER, 48));
	public static final BridgeEnchantment PUNCH = register(new BridgeEnchantment(Enchantments.PUNCH, 49));
	public static final BridgeEnchantment FLAME = register(new BridgeEnchantment(Enchantments.FLAME, 50));
	public static final BridgeEnchantment INFINITY = register(new BridgeEnchantment(Enchantments.INFINITY, 51));

	private static final BridgeEnchantment register(BridgeEnchantment enchant) {
		byId.put(enchant.getId(), enchant);
		byName.put(enchant.getName(), enchant);
		return enchant;
	}
}
