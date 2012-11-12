package org.spout.bridge.bukkit.inventory;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.spout.api.inventory.Inventory;
import org.spout.bridge.BukkitUtil;

public class BridgeInventoryPlayer extends BridgeInventory implements PlayerInventory {
	private VanillaInventoryPlayer vanillaInventory;
	
	public BridgeInventoryPlayer(Inventory handle, String name) {
		super(handle, name);
		this.vanillaInventory = (VanillaInventoryPlayer) handle;
	}
	
	@Override
	public ItemStack[] getArmorContents() {
		return new ItemStack[] {getItem(36), getItem(37), getItem(38), getItem(39)};
	}

	@Override
	public ItemStack getHelmet() {
		return getItem(39);
	}

	@Override
	public ItemStack getChestplate() {
		return getItem(38);
	}

	@Override
	public ItemStack getLeggings() {
		return getItem(37);
	}

	@Override
	public ItemStack getBoots() {
		return getItem(36);
	}

	@Override
	public void setArmorContents(ItemStack[] itemStacks) {
		if (itemStacks == null)
			for (int i = 36; i < 40; i++)
				clear(i);
			
		for (int i = 0; i < 4; i++)
			setItem(i, itemStacks[i]);
	}

	@Override
	public void setHelmet(ItemStack itemStack) {
		setItem(39, itemStack);
	}

	@Override
	public void setChestplate(ItemStack itemStack) {
		setItem(38, itemStack);
	}

	@Override
	public void setLeggings(ItemStack itemStack) {
		setItem(37, itemStack);
	}

	@Override
	public void setBoots(ItemStack itemStack) {
		setItem(36, itemStack);
	}

	@Override
	public ItemStack getItemInHand() {
		return getItem(getHeldItemSlot());
	}

	@Override
	public void setItemInHand(ItemStack itemStack) {
		setItem(getHeldItemSlot(), itemStack);
	}

	@Override
	public int getHeldItemSlot() {
		return vanillaInventory.getHeldItemSlot();
	}

	@Override
	public Player getHolder() {
		throw new UnsupportedOperationException();
	}
	
/* 
 * Override BridgeInventory methods, in order to appropriately sync SpoutInventoryPlayer 
 * with the Vanilla PlayerInventory object.
 */
	@Override
	public ItemStack getItem(int i) {
		vanillaInventory.syncWithVanilla(i);
		return super.getItem(i);
	}
	
	@Override
	public void setItem(int i, ItemStack itemStack) {
		super.setItem(i, itemStack);
		vanillaInventory.syncVanillaWith(i);
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
		vanillaInventory.syncVanillaWith();
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
		vanillaInventory.syncVanillaWith();
		return map;
	}
	
	@Override
	public ItemStack[] getContents() {
		vanillaInventory.syncWithVanilla();
		return super.getContents();
	}
	
	@Override
	public void setContents(ItemStack[] contents) {
		super.setContents(contents);
		vanillaInventory.syncVanillaWith();
	}
	
	@Override
	public boolean contains(int typeId) {
		vanillaInventory.syncWithVanilla();
		return super.contains(typeId);
	}

	@Override
	public boolean contains(Material material) {
		vanillaInventory.syncWithVanilla();
		return super.contains(material);
	}

	@Override
	public boolean contains(ItemStack itemStack) {
		vanillaInventory.syncWithVanilla();
		return super.contains(itemStack);
	}

	@Override
	public boolean contains(int typeId, int amount) {
		vanillaInventory.syncWithVanilla();
		return super.contains(typeId, amount);
	}

	@Override
	public boolean contains(Material material, int amount) {
		vanillaInventory.syncWithVanilla();
		return super.contains(material, amount);
	}

	@Override
	public boolean contains(ItemStack itemStack, int amount) {
		vanillaInventory.syncWithVanilla();
		return super.contains(itemStack, amount);
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(int typeId) {
		vanillaInventory.syncWithVanilla();
		return super.all(typeId);
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(Material material) {
		vanillaInventory.syncWithVanilla();
		return super.all(material);
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(ItemStack itemStack) {
		vanillaInventory.syncWithVanilla();
		return super.all(itemStack);
	}

	@Override
	public int first(int typeId) {
		vanillaInventory.syncWithVanilla();
		return super.first(typeId);
	}

	@Override
	public int first(Material material) {
		vanillaInventory.syncWithVanilla();
		return super.first(material);
	}

	@Override
	public int first(ItemStack itemStack) {
		vanillaInventory.syncWithVanilla();
		return super.first(itemStack);
	}

	@Override
	public int firstEmpty() {
		vanillaInventory.syncWithVanilla();
		return super.firstEmpty();
	}
	
	@Override
	public void remove(int typeId) {
		super.remove(typeId);
		vanillaInventory.syncVanillaWith();
	}

	@Override
	public void remove(Material material) {
		super.remove(material);
		vanillaInventory.syncVanillaWith();
	}

	@Override
	public void remove(ItemStack itemStack) {
		super.remove(itemStack);
		vanillaInventory.syncVanillaWith();
	}

	@Override
	public void clear(int slot) {
		super.remove(slot);
		vanillaInventory.syncVanillaWith(slot);
	}

	@Override
	public void clear() {
		super.clear();
		vanillaInventory.syncVanillaWith();
	}
	
}
