package org.spout.bridge.bukkit.inventory;

import org.bukkit.block.BrewingStand;
import org.bukkit.inventory.BrewerInventory;
import org.bukkit.inventory.ItemStack;

import org.spout.api.inventory.Inventory;

public class BridgeInventoryBrewer extends BridgeInventory implements BrewerInventory {
	public BridgeInventoryBrewer(Inventory handle, String name) {
		super(handle, name);
	}

	@Override
	public ItemStack getIngredient() {
		return getItem(3);
	}

	@Override
	public void setIngredient(ItemStack itemStack) {
		setItem(3, itemStack);
	}

	@Override
	public BrewingStand getHolder() {
		throw new UnsupportedOperationException();
	}
	
}
