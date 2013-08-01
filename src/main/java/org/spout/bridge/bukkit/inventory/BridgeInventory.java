/*
 * This file is part of BukkitBridge.
 *
 * Copyright (c) 2012 Spout LLC <http://www.spout.org/>
 * BukkitBridge is licensed under the GNU General Public License.
 *
 * BukkitBridge is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BukkitBridge is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.spout.bridge.bukkit.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import org.spout.api.inventory.InventoryViewer;

import org.spout.bridge.BukkitUtil;
import org.spout.vanilla.inventory.window.Window;
import org.spout.vanilla.material.VanillaMaterial;
import org.spout.vanilla.material.VanillaMaterials;

public class BridgeInventory implements Inventory {
	protected org.spout.api.inventory.Inventory handle;
	protected final InventoryHolder holder;
	protected int maxStackSize = 64;
	protected final String name, title;
	protected final InventoryType type;

	public BridgeInventory(org.spout.api.inventory.Inventory handle, InventoryHolder holder, String name, String title, InventoryType type) {
		this.handle = handle;
		this.holder = holder;
		this.name = name;
		this.title = title;
		this.type = type;
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
		return maxStackSize;
	}

	@Override
	public void setMaxStackSize(int maxStackSize) {
		this.maxStackSize = Math.min(maxStackSize, 64);
	}

	@Override
	public String getName() {
		return name;
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
	public boolean containsAtLeast(ItemStack itemStack, int i) {
		return false;
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
		List<HumanEntity> humans = new ArrayList<HumanEntity>();
		for (InventoryViewer viewer : handle.getViewers()) {
			if (viewer instanceof Window) {
				humans.add(Bukkit.getPlayer(((Window) viewer).getPlayer().getName()));
			}
		}
		return humans;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public InventoryType getType() {
		return type;
	}

	@Override
	public InventoryHolder getHolder() {
		return holder;
	}

	@Override
	public ListIterator<ItemStack> iterator() {
		return iterator(0);
	}

	@Override
	public ListIterator<ItemStack> iterator(int i) {
		List<ItemStack> items = new ArrayList<ItemStack>();
		for (org.spout.api.inventory.ItemStack item : handle) {
			items.add(BukkitUtil.fromItemStack(item));
		}
		return items.listIterator(i);
	}
}
