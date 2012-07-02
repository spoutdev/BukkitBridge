package org.spout.bridge.bukkit.block;

import org.bukkit.block.Block;
import org.bukkit.block.BrewingStand;
import org.bukkit.inventory.BrewerInventory;

public class BridgeBrewingStand extends BridgeBlockState implements BrewingStand {

	public BridgeBrewingStand(Block b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getBrewingTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBrewingTime(int paramInt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BrewerInventory getInventory() {
		// TODO Auto-generated method stub
		return null;
	}

}
