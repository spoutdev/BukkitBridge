package org.spout.bridge.bukkit.inventory;

import org.spout.api.inventory.InventoryViewer;
import org.spout.vanilla.inventory.block.ChestInventory;

public class VanillaChestInventory extends ChestInventory {
	private static final long serialVersionUID = 1L;
		
	public VanillaChestInventory() {
		super();
	}
	
	@Override
	public boolean addViewer(InventoryViewer viewer) {
		return true;
	}
}
