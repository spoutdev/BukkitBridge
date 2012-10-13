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
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getMaxLevel() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getStartLevel() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public EnchantmentTarget getItemTarget() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean conflictsWith(Enchantment enchantment) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean canEnchantItem(ItemStack itemStack) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
