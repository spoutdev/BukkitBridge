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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean dispense() {
		// TODO Auto-generated method stub
		return false;
	}

}
