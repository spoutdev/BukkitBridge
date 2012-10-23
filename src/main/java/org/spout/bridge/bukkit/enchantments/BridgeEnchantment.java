package org.spout.bridge.bukkit.enchantments;

import org.spout.bridge.BukkitUtil;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

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
