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

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

import org.spout.bridge.BukkitUtil;

public class BridgeEnchantment extends Enchantment {
	private org.spout.vanilla.material.enchantment.Enchantment vanillaEnchantment;

	protected BridgeEnchantment(org.spout.vanilla.material.enchantment.Enchantment vanillaEnchantment, int id) {
		super(id);
		this.vanillaEnchantment = vanillaEnchantment;
	}

	@Override
	public boolean canEnchantItem(ItemStack is) {
		return vanillaEnchantment.canEnchant(BukkitUtil.getVanillaMaterial(is));
	}

	@Override
	public boolean conflictsWith(Enchantment enchant) {
		return vanillaEnchantment.compatibleWith(BukkitUtil.getVanillaEnchantment(enchant), null /* TODO: Not sure what to do for the VanillaMaterial */);
	}

	@Override
	public EnchantmentTarget getItemTarget() {
		return BukkitUtil.getEnchantmentTargetFromEnchantment(vanillaEnchantment);
	}

	@Override
	public int getMaxLevel() {
		return vanillaEnchantment.getMaximumLevel();
	}

	@Override
	public String getName() {
		return vanillaEnchantment.getName();
	}

	@Override
	public int getStartLevel() {
		return 1; //Vanilla enchantments have no concept of a start level, and I think the only potential one in Vanilla MC is 1
	}
}
