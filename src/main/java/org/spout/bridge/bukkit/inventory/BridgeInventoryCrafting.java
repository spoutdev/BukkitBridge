package org.spout.bridge.bukkit.inventory;

import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

public class BridgeInventoryCrafting extends BridgeInventory implements CraftingInventory {
	@Override
	public ItemStack getResult() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public ItemStack[] getMatrix() {
		return new ItemStack[0];  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setResult(ItemStack itemStack) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setMatrix(ItemStack[] itemStacks) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Recipe getRecipe() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
