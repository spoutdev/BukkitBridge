package org.spout.bridge.bukkit.inventory;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class BridgeShapedRecipe extends ShapedRecipe implements BridgeRecipe {
	public BridgeShapedRecipe(ItemStack result) {
		super(result);
	}
}
