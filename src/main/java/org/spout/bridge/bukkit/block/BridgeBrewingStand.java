package org.spout.bridge.bukkit.block;

import org.bukkit.block.Block;
import org.bukkit.block.BrewingStand;
import org.bukkit.inventory.BrewerInventory;
import org.spout.bridge.bukkit.inventory.BridgeInventoryBrewer;

public class BridgeBrewingStand extends BridgeBlockState implements BrewingStand {
	private final org.spout.vanilla.component.substance.material.BrewingStand stand;
	public BridgeBrewingStand(Block b) {
		super(b);
		this.stand = (org.spout.vanilla.component.substance.material.BrewingStand) getHandle();
	}

	@Override
	public int getBrewingTime() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBrewingTime(int paramInt) {
		throw new UnsupportedOperationException();
	}

	@Override
	public BrewerInventory getInventory() {
		return new BridgeInventoryBrewer(stand.getInventory(), "");
	}
}
