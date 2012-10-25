package org.spout.bridge.bukkit.inventory;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class BridgeInventoryView extends InventoryView {
	@Override
	public Inventory getTopInventory() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Inventory getBottomInventory() {
		throw new UnsupportedOperationException();
	}

	@Override
	public HumanEntity getPlayer() {
		throw new UnsupportedOperationException();
	}

	@Override
	public InventoryType getType() {
		throw new UnsupportedOperationException();
	}
}
