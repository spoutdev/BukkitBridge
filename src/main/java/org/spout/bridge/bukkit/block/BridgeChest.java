package org.spout.bridge.bukkit.block;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.spout.bridge.bukkit.inventory.BridgeInventory;
import org.spout.bridge.bukkit.inventory.BridgeInventoryDoubleChest;

public class BridgeChest extends BridgeBlockState implements Chest {
	private final org.spout.vanilla.component.substance.material.chest.Chest chest;
	public BridgeChest(Block b) {
		super(b);
		this.chest = (org.spout.vanilla.component.substance.material.chest.Chest) getHandle();
	}

	@Override
	public Inventory getInventory() {
		if (chest.isDouble()) {
			BridgeInventoryDoubleChest chester = new BridgeInventoryDoubleChest(chest.getInventory(), "");
			return chester;
		} else {
			return new BridgeInventory(chest.getInventory(), "");
		}
	}

	@Override
	public Inventory getBlockInventory() {
		if (!chest.isDouble()) {
			return new BridgeInventory(chest.getInventory(), "");
		} else {
			BridgeInventoryDoubleChest chester = new BridgeInventoryDoubleChest(chest.getInventory(), "");
			int x = getX();
			int y = getY();
			int z = getZ();
			if (getWorld().getBlockTypeIdAt(x - 1, y, z) == Material.CHEST.getId()) {
				return chester.getRightSide();
			} else if (getWorld().getBlockTypeIdAt(x + 1, y, z) == Material.CHEST.getId()) {
				return chester.getLeftSide();
			} else if (getWorld().getBlockTypeIdAt(x, y, z - 1) == Material.CHEST.getId()) {
				return chester.getRightSide();
			} else {
				return chester.getLeftSide();
			}
		}
	}
}
