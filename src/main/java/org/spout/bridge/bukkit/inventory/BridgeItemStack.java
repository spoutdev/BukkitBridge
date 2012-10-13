package org.spout.bridge.bukkit.inventory;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BridgeItemStack extends ItemStack {
	public BridgeItemStack(Material type, int amount) {
		super(type, amount);
	}

	public BridgeItemStack(Material type, int amount, short damage) {
		super(type, amount, damage);
	}

	public BridgeItemStack(Material type, int amount, short damage, byte data) {
		super(type, amount, damage, data);
	}
}
