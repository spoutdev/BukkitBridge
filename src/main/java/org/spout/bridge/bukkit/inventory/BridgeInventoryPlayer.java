package org.spout.bridge.bukkit.inventory;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import org.spout.api.inventory.Inventory;

public class BridgeInventoryPlayer extends BridgeInventory implements PlayerInventory {
	public BridgeInventoryPlayer(Inventory handle, String name) {
		super(handle, name);
	}

	@Override
	public ItemStack[] getArmorContents() {
		return new ItemStack[0];  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public ItemStack getHelmet() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ItemStack getChestplate() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ItemStack getLeggings() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ItemStack getBoots() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setArmorContents(ItemStack[] itemStacks) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setHelmet(ItemStack itemStack) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setChestplate(ItemStack itemStack) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setLeggings(ItemStack itemStack) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setBoots(ItemStack itemStack) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public ItemStack getItemInHand() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setItemInHand(ItemStack itemStack) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getHeldItemSlot() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Player getHolder() {
		return null;
	}
}
