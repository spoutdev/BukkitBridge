package org.spout.bridge.bukkit.inventory;


import java.util.Arrays;
import java.util.HashMap;

import org.apache.commons.lang3.ArrayUtils;
import org.bukkit.Material;
import org.bukkit.block.DoubleChest;
import org.bukkit.inventory.DoubleChestInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.spout.bridge.BukkitUtil;

public class BridgeInventoryDoubleChest extends BridgeInventory implements DoubleChestInventory {
	private final BridgeInventory left;
	private final BridgeInventory right;
	
	public BridgeInventoryDoubleChest(org.spout.api.inventory.Inventory handle, String name) {
		super(handle, name);
		this.getContents();
		left = new BridgeInventory(new VanillaChestInventory(), "");
		right = new BridgeInventory(new VanillaChestInventory(), "");
		syncSides();
	}

	@Override
	public Inventory getLeftSide() {
		return left;
	}

	@Override
	public Inventory getRightSide() {
		return right;
	}

	@Override
	public DoubleChest getHolder() {
		throw new UnsupportedOperationException();
	}
	
	private void syncSides() {
		left.setContents(Arrays.copyOfRange(this.getContents(), 0, 26));
		right.setContents(Arrays.copyOfRange(this.getContents(), 27, 53));
	}
	
	private void syncSides(int i) {
		if (i < 27)
			left.setItem(i, this.getItem(i));
		else
			right.setItem(i - 27, this.getItem(i));
	}
	
	private void syncChest() {
		this.setContents(ArrayUtils.addAll(left.getContents(), right.getContents()));
	}
	
	private void syncChest(int i) {
		if (i < 27)
			this.setItem(i, left.getItem(i));
		else
			this.setItem(i, left.getItem(i - 27));
	}
	
/* 
 * Override BridgeInventory methods, to keep the chest and its two sides
 * in sync.
 */
	@Override
	public ItemStack getItem(int i) {
		syncChest(i);
		return super.getItem(i);
	}
	
	@Override
	public void setItem(int i, ItemStack itemStack) {
		super.setItem(i, itemStack);
		syncSides();
	}

	@Override
	public HashMap<Integer, ItemStack> addItem(ItemStack... itemStacks) {
		HashMap<Integer, ItemStack> map = new HashMap<Integer, ItemStack>();
		for (ItemStack item : itemStacks) {
			org.spout.api.inventory.ItemStack i = BukkitUtil.toItemStack(item);
			getHandle().add(0, 35, i);
			if (!getHandle().contains(i)) {
				map.put(item.getAmount(), item);
			}
		}
		syncSides();
		return map;
	}

	@Override
	public HashMap<Integer, ItemStack> removeItem(ItemStack... itemStacks) {
		HashMap<Integer, ItemStack> map = new HashMap<Integer, ItemStack>();
		for (ItemStack item : itemStacks) {
			org.spout.api.inventory.ItemStack i = BukkitUtil.toItemStack(item);
			getHandle().remove(i);
			if (getHandle().contains(i)) {
				map.put(item.getAmount(), item);
			}
		}
		syncSides();
		return map;
	}
	
	@Override
	public ItemStack[] getContents() {
		syncChest();
		return super.getContents();
	}
	
	@Override
	public void setContents(ItemStack[] contents) {
		super.setContents(contents);
		syncSides();
	}
	
	@Override
	public boolean contains(int typeId) {
		syncChest();
		return super.contains(typeId);
	}

	@Override
	public boolean contains(Material material) {
		syncChest();
		return super.contains(material);
	}

	@Override
	public boolean contains(ItemStack itemStack) {
		syncChest();
		return super.contains(itemStack);
	}

	@Override
	public boolean contains(int typeId, int amount) {
		syncChest();
		return super.contains(typeId, amount);
	}

	@Override
	public boolean contains(Material material, int amount) {
		syncChest();
		return super.contains(material, amount);
	}

	@Override
	public boolean contains(ItemStack itemStack, int amount) {
		syncChest();
		return super.contains(itemStack, amount);
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(int typeId) {
		syncChest();
		return super.all(typeId);
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(Material material) {
		syncChest();
		return super.all(material);
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(ItemStack itemStack) {
		syncChest();
		return super.all(itemStack);
	}

	@Override
	public int first(int typeId) {
		syncChest();
		return super.first(typeId);
	}

	@Override
	public int first(Material material) {
		syncChest();
		return super.first(material);
	}

	@Override
	public int first(ItemStack itemStack) {
		syncChest();
		return super.first(itemStack);
	}

	@Override
	public int firstEmpty() {
		syncChest();
		return super.firstEmpty();
	}
	
	@Override
	public void remove(int typeId) {
		super.remove(typeId);
		syncSides();
	}

	@Override
	public void remove(Material material) {
		super.remove(material);
		syncSides();
	}

	@Override
	public void remove(ItemStack itemStack) {
		super.remove(itemStack);
		syncSides();
	}

	@Override
	public void clear(int slot) {
		super.remove(slot);
		syncSides(slot);
	}

	@Override
	public void clear() {
		super.clear();
		syncSides();
	}
}
