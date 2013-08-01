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

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import org.spout.api.inventory.Inventory;

import org.spout.bridge.BukkitUtil;
import org.spout.bridge.bukkit.entity.BridgePlayer;

public class BridgeInventoryPlayer extends BridgeInventory implements PlayerInventory, EntityEquipment {
	private final org.spout.vanilla.component.entity.inventory.PlayerInventory playerInventory;

	public BridgeInventoryPlayer(Inventory handle, BridgePlayer holder) {
		super(handle, holder, "container.player", "Inventory", InventoryType.PLAYER);
		this.playerInventory = holder.getHandle().get(org.spout.vanilla.component.entity.inventory.PlayerInventory.class);
	}

	@Override
	public ItemStack[] getArmorContents() {
		ItemStack[] items = new ItemStack[4];
		for (int i = 0; i < items.length; i++) {
			items[i] = BukkitUtil.fromItemStack(playerInventory.getArmor().get(i));
		}
		return items;
	}

	@Override
	public ItemStack getHelmet() {
		return BukkitUtil.fromItemStack(playerInventory.getArmor().getHelmet());
	}

	@Override
	public ItemStack getChestplate() {
		return BukkitUtil.fromItemStack(playerInventory.getArmor().getChestPlate());
	}

	@Override
	public ItemStack getLeggings() {
		return BukkitUtil.fromItemStack(playerInventory.getArmor().getLeggings());
	}

	@Override
	public ItemStack getBoots() {
		return BukkitUtil.fromItemStack(playerInventory.getArmor().getBoots());
	}

	@Override
	public void setArmorContents(ItemStack[] itemStacks) {
		if (itemStacks == null) {
			itemStacks = new ItemStack[4];
		}
		for (int i = 0; i < itemStacks.length; i++) {
			playerInventory.getArmor().set(i, BukkitUtil.toItemStack(itemStacks[i]), true);
		}
	}

	@Override
	public float getItemInHandDropChance() {
		return 1;
	}

	@Override
	public void setItemInHandDropChance(float v) {
		throw new UnsupportedOperationException();
	}

	@Override
	public float getHelmetDropChance() {
		return 1;
	}

	@Override
	public void setHelmetDropChance(float v) {
		throw new UnsupportedOperationException();
	}

	@Override
	public float getChestplateDropChance() {
		return 1;
	}

	@Override
	public void setChestplateDropChance(float v) {
		throw new UnsupportedOperationException();
	}

	@Override
	public float getLeggingsDropChance() {
		return 1;
	}

	@Override
	public void setLeggingsDropChance(float v) {
		throw new UnsupportedOperationException();
	}

	@Override
	public float getBootsDropChance() {
		return 1;
	}

	@Override
	public void setBootsDropChance(float v) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setHelmet(ItemStack itemStack) {
		playerInventory.getArmor().setHelmet(BukkitUtil.toItemStack(itemStack));
	}

	@Override
	public void setChestplate(ItemStack itemStack) {
		playerInventory.getArmor().setChestPlate(BukkitUtil.toItemStack(itemStack));
	}

	@Override
	public void setLeggings(ItemStack itemStack) {
		playerInventory.getArmor().setLeggings(BukkitUtil.toItemStack(itemStack));
	}

	@Override
	public void setBoots(ItemStack itemStack) {
		playerInventory.getArmor().setBoots(BukkitUtil.toItemStack(itemStack));
	}

	@Override
	public ItemStack getItemInHand() {
		return BukkitUtil.fromItemStack(playerInventory.getHeldItem());
	}

	@Override
	public void setItemInHand(ItemStack itemStack) {
		playerInventory.getQuickbar().set(playerInventory.getQuickbar().getSelectedSlot().getIndex(), BukkitUtil.toItemStack(itemStack), true);
	}

	@Override
	public int getHeldItemSlot() {
		return playerInventory.getQuickbar().getSelectedSlot().getIndex();
	}

	@Override
	public void setHeldItemSlot(int i) {
		playerInventory.getQuickbar().setSelectedSlot(i);
	}

	@Override
	public int clear(int i, int i2) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ItemStack getItem(int i) {
		if (i >= handle.size()) {
			i -= handle.size();
			if (i < 4) {
				return getArmorContents()[i];
			} else {
				return null;
			}
		}
		return BukkitUtil.fromItemStack(handle.get(i));
	}

	@Override
	public HumanEntity getHolder() {
		return (HumanEntity) holder;
	}
}
