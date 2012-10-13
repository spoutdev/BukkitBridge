package org.spout.bridge.bukkit.inventory;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class BridgeInventoryView extends InventoryView {
	@Override
	public Inventory getTopInventory() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Inventory getBottomInventory() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public HumanEntity getPlayer() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public InventoryType getType() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
