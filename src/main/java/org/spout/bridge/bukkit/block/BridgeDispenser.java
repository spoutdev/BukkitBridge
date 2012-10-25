package org.spout.bridge.bukkit.block;

import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.inventory.Inventory;

public class BridgeDispenser extends BridgeBlockState implements Dispenser {
	public BridgeDispenser(Block b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Inventory getInventory() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean dispense() {
		throw new UnsupportedOperationException();
	}
}
