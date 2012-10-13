package org.spout.bridge.bukkit.inventory;

import org.bukkit.Material;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;

public class BridgeFurnaceRecipe extends FurnaceRecipe {
	public BridgeFurnaceRecipe(ItemStack result, Material source) {
		super(result, source);
	}
}
