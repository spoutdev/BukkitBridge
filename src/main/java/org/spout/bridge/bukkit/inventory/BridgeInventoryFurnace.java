package org.spout.bridge.bukkit.inventory;

import org.bukkit.block.Furnace;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.ItemStack;

import org.spout.api.inventory.Inventory;

public class BridgeInventoryFurnace extends BridgeInventory implements FurnaceInventory {
	public BridgeInventoryFurnace(Inventory handle, String name) {
		super(handle, name);
	}

	@Override
	public ItemStack getResult() {
		return getItem(2);
	}

	@Override
	public ItemStack getFuel() {
		return getItem(0);
	}
	
	@Override
	public ItemStack getSmelting() {
		return getItem(1);
	}

	@Override
	public void setFuel(ItemStack itemStack) {
		setItem(0, itemStack);
	}

	@Override
	public void setResult(ItemStack itemStack) {
		setItem(2, itemStack);
	}

	@Override
	public void setSmelting(ItemStack itemStack) {
		setItem(1, itemStack);
	}

	@Override
	public Furnace getHolder() {
		throw new UnsupportedOperationException();
	}
}
