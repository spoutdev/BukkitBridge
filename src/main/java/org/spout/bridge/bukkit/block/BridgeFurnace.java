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
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBurnTime(short paramShort) {
		throw new UnsupportedOperationException();
	}

	@Override
	public short getCookTime() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setCookTime(short paramShort) {
		throw new UnsupportedOperationException();
	}

	@Override
	public FurnaceInventory getInventory() {
		throw new UnsupportedOperationException();
	}
}
