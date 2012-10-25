package org.spout.bridge.bukkit.inventory;

import org.bukkit.block.DoubleChest;
import org.bukkit.inventory.DoubleChestInventory;
import org.bukkit.inventory.Inventory;

public class BridgeInventoryDoubleChest extends BridgeInventory implements DoubleChestInventory {
	public BridgeInventoryDoubleChest(org.spout.api.inventory.Inventory handle, String name) {
		super(handle, name);
	}

	@Override
	public Inventory getLeftSide() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Inventory getRightSide() {
		throw new UnsupportedOperationException();
	}

	@Override
	public DoubleChest getHolder() {
		return null;
	}
}
