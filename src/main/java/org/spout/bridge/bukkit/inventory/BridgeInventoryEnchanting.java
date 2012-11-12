package org.spout.bridge.bukkit.inventory;

import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.inventory.ItemStack;

import org.spout.api.inventory.Inventory;

public class BridgeInventoryEnchanting extends BridgeInventory implements EnchantingInventory {
	public BridgeInventoryEnchanting(Inventory handle, String name) {
		super(handle, name);
	}
	
	@Override
	public ItemStack getItem() {
		return getItem(0);
	}

	@Override
	public void setItem(ItemStack itemStack) {
		setItem(0, itemStack);
	}

}
