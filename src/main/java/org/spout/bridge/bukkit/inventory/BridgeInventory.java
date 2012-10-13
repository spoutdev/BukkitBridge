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

import org.spout.bridge.BukkitUtil;

import org.spout.vanilla.material.VanillaMaterial;
import org.spout.vanilla.material.VanillaMaterials;

public class BridgeInventory implements Inventory {
	private org.spout.api.inventory.Inventory handle;

	public BridgeInventory(org.spout.api.inventory.Inventory handle, String name) {
		this.handle = handle;
	}

	public org.spout.api.inventory.Inventory getHandle() {
		return handle;
	}

	@Override
	public int getSize() {
		return handle.size();
	}

	@Override
	public int getMaxStackSize() {
		return 64;
	}

	@Override
	public void setMaxStackSize(int maxStackSize) {
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public ItemStack getItem(int i) {
		return BukkitUtil.fromItemStack(handle.get(i));
	}

	@Override
	public void setItem(int i, ItemStack itemStack) {
		handle.set(i, BukkitUtil.toItemStack(itemStack));
	}

	@Override
	public HashMap<Integer, ItemStack> addItem(ItemStack... itemStacks) {
		HashMap<Integer, ItemStack> map = new HashMap<Integer, ItemStack>();
		for (ItemStack item : itemStacks) {
			org.spout.api.inventory.ItemStack i = BukkitUtil.toItemStack(item);
			handle.add(i);
			if (!handle.contains(i)) {
				map.put(item.getAmount(), item);
			}
		}
		return map;
	}

	@Override
	public HashMap<Integer, ItemStack> removeItem(ItemStack... itemStacks) {
		HashMap<Integer, ItemStack> map = new HashMap<Integer, ItemStack>();
		for (ItemStack item : itemStacks) {
			org.spout.api.inventory.ItemStack i = BukkitUtil.toItemStack(item);
			handle.remove(i);
			if (handle.contains(i)) {
				map.put(item.getAmount(), item);
			}
		}
		return map;
	}

	@Override
	public ItemStack[] getContents() {
		org.spout.api.inventory.ItemStack[] contents = handle.toArray(new org.spout.api.inventory.ItemStack[handle.size()]);
	    ItemStack[] newContents = new ItemStack[getSize()];
		for (int i = 0; i < newContents.length; i++) {
			newContents[i] = BukkitUtil.fromItemStack(contents[i]);
		}
		return newContents;
	}

	@Override
	public void setContents(ItemStack[] contents) {
		org.spout.api.inventory.ItemStack[] newContents = new org.spout.api.inventory.ItemStack[contents.length];
		for (int i = 0; i < contents.length; i++) {
			newContents[i] = BukkitUtil.toItemStack(contents[i]);
		}
		handle = new org.spout.api.inventory.Inventory(newContents);
	}

	@Override
	public boolean contains(int typeId) {
		return handle.contains(VanillaMaterials.getMaterial((short) typeId));
	}

	@Override
	public boolean contains(Material material) {
		return contains(material.getId());
	}

	@Override
	public boolean contains(ItemStack itemStack) {
		return handle.contains(BukkitUtil.toItemStack(itemStack));
	}

	@Override
	public boolean contains(int typeId, int amount) {
		return handle.contains(VanillaMaterials.getMaterial((short) typeId), amount);
	}

	@Override
	public boolean contains(Material material, int amount) {
		return contains(material.getId(), amount);
	}

	@Override
	public boolean contains(ItemStack itemStack, int amount) {
		itemStack.setAmount(amount);
		return handle.contains(itemStack);
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(int typeId) {
		HashMap<Integer, ItemStack> map = new HashMap<Integer, ItemStack>();
		for (int i = 0; i < handle.size(); i++) {
			org.spout.api.inventory.ItemStack item = handle.get(i);
			if (item.getMaterial() instanceof VanillaMaterial && ((VanillaMaterial) item.getMaterial()).getMinecraftId() == typeId) {
				map.put(i, BukkitUtil.fromItemStack(item));
			}
		}
		return map;
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(Material material) {
		return all(material.getId());
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(ItemStack itemStack) {
		HashMap<Integer, ItemStack> map = new HashMap<Integer, ItemStack>();
		for (int i = 0; i < handle.size(); i++) {
			org.spout.api.inventory.ItemStack item = handle.get(i);
			if (item.equals(BukkitUtil.toItemStack(itemStack))) {
				map.put(i, BukkitUtil.fromItemStack(item));
			}
		}
		return map;
	}

	@Override
	public int first(int typeId) {
		return handle.indexOf(VanillaMaterials.getMaterial((short) typeId));
	}

	@Override
	public int first(Material material) {
		return first(material.getId());
	}

	@Override
	public int first(ItemStack itemStack) {
		return handle.indexOf(BukkitUtil.toItemStack(itemStack));
	}

	@Override
	public int firstEmpty() {
		for (int i = 0; i < handle.size(); i++) {
			if (handle.get(i) == null) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void remove(int typeId) {
		for (int i = 0; i < handle.size(); i++) {
			org.spout.api.inventory.ItemStack item = handle.get(i);
			if (item.getMaterial() instanceof VanillaMaterial && ((VanillaMaterial) item.getMaterial()).getMinecraftId() == typeId) {
				handle.remove(i);
			}
		}
	}

	@Override
	public void remove(Material material) {
		remove(material.getId());
	}

	@Override
	public void remove(ItemStack itemStack) {
		for (int i = 0; i < handle.size(); i++) {
			org.spout.api.inventory.ItemStack item = handle.get(i);
			if (item.equals(BukkitUtil.toItemStack(itemStack))) {
				handle.remove(i);
			}
		}
	}

	@Override
	public void clear(int slot) {
		handle.remove(slot);
	}

	@Override
	public void clear() {
		handle.clear();
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
