package org.spout.bridge.bukkit.block;

import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.inventory.FurnaceInventory;
import org.spout.bridge.bukkit.inventory.BridgeInventoryFurnace;

public class BridgeFurnace extends BridgeBlockState implements Furnace {
	private final org.spout.vanilla.component.substance.material.Furnace furnace;
	public BridgeFurnace(Block b) {
		super(b);
		this.furnace = (org.spout.vanilla.component.substance.material.Furnace) getHandle();
	}

	@Override
	public short getBurnTime() {
		return (short) furnace.getFuel();
	}

	@Override
	public void setBurnTime(short paramShort) {
		furnace.setFuel(paramShort);
	}

	@Override
	public short getCookTime() {
		return (short) furnace.getSmeltTime();
	}

	@Override
	public void setCookTime(short paramShort) {
		furnace.setSmeltTime(paramShort);
	}

	@Override
	public FurnaceInventory getInventory() {
		return new BridgeInventoryFurnace(furnace.getInventory(), "");
	}
}
