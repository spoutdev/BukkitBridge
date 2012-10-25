package org.spout.bridge.bukkit.enchantments;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class BridgeEnchantment extends Enchantment {
	public BridgeEnchantment(int id) {
		super(id);
	}

	@Override
	public String getName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getMaxLevel() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getStartLevel() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EnchantmentTarget getItemTarget() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean conflictsWith(Enchantment enchantment) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean canEnchantItem(ItemStack itemStack) {
		throw new UnsupportedOperationException();
	}
}
