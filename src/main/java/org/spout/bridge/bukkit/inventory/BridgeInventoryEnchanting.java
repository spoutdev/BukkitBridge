package org.spout.bridge.bukkit.inventory;

import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.inventory.ItemStack;

import org.spout.api.inventory.Inventory;

public class BridgeInventoryEnchanting extends BridgeInventory implements EnchantingInventory {
	public BridgeInventoryEnchanting(Inventory handle, String name) {
		super(handle, name);
	}

	@Override
	public void setItem(ItemStack itemStack) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public ItemStack getItem() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
