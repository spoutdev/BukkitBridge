package org.spout.bridge.bukkit.block;

import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;

public class BridgeChest extends BridgeBlockState implements Chest {

	public BridgeChest(Block b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Inventory getInventory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory getBlockInventory() {
		// TODO Auto-generated method stub
		return null;
	}

}
