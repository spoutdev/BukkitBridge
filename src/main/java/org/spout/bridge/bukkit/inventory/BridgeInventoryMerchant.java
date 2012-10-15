package org.spout.bridge.bukkit.inventory;

import org.bukkit.inventory.MerchantInventory;

import org.spout.api.inventory.Inventory;

public class BridgeInventoryMerchant extends BridgeInventory implements MerchantInventory {
	public BridgeInventoryMerchant(Inventory handle, String name) {
		super(handle, name);
	}
}
