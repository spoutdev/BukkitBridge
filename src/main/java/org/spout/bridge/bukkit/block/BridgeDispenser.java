package org.spout.bridge.bukkit.block;

import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.inventory.Inventory;
import org.spout.bridge.bukkit.inventory.BridgeInventory;

public class BridgeDispenser extends BridgeBlockState implements Dispenser {
	private final org.spout.vanilla.component.substance.material.Dispenser dispenser;
	public BridgeDispenser(Block b) {
		super(b);
		this.dispenser = (org.spout.vanilla.component.substance.material.Dispenser) getHandle();
	}

	@Override
	public Inventory getInventory() {
		return new BridgeInventory(dispenser.getInventory(), "");
	}

	@Override
	public boolean dispense() {
		throw new UnsupportedOperationException();
	}
}
