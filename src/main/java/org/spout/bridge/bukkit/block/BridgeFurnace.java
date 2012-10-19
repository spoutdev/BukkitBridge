package org.spout.bridge.bukkit.block;

import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.inventory.FurnaceInventory;

public class BridgeFurnace extends BridgeBlockState implements Furnace {
	public BridgeFurnace(Block b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public short getBurnTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBurnTime(short paramShort) {
		// TODO Auto-generated method stub

	}

	@Override
	public short getCookTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCookTime(short paramShort) {
		// TODO Auto-generated method stub

	}

	@Override
	public FurnaceInventory getInventory() {
		// TODO Auto-generated method stub
		return null;
	}
}
