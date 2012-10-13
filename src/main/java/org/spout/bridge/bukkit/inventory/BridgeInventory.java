package org.spout.bridge.bukkit.inventory;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class BridgeInventory implements Inventory {
	@Override
	public int getSize() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getMaxStackSize() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setMaxStackSize(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public String getName() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public ItemStack getItem(int i) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setItem(int i, ItemStack itemStack) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public HashMap<Integer, ItemStack> addItem(ItemStack... itemStacks) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public HashMap<Integer, ItemStack> removeItem(ItemStack... itemStacks) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public ItemStack[] getContents() {
		return new ItemStack[0];  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setContents(ItemStack[] itemStacks) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean contains(int i) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean contains(Material material) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean contains(ItemStack itemStack) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean contains(int i, int i1) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean contains(Material material, int i) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean contains(ItemStack itemStack, int i) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(int i) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(Material material) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(ItemStack itemStack) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int first(int i) {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int first(Material material) {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int first(ItemStack itemStack) {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int firstEmpty() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void remove(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void remove(Material material) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void remove(ItemStack itemStack) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void clear(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void clear() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public List<HumanEntity> getViewers() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public String getTitle() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public InventoryType getType() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public InventoryHolder getHolder() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public ListIterator<ItemStack> iterator() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public ListIterator<ItemStack> iterator(int i) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
