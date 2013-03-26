/*
 * This file is part of BukkitBridge.
 *
 * Copyright (c) 2012, VanillaDev <http://www.spout.org/>
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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.spout.bridge.BukkitUtil;
import org.spout.bridge.bukkit.entity.BridgePlayer;

import org.spout.api.inventory.Inventory;

public class BridgeInventoryPlayer extends BridgeInventory implements PlayerInventory {
	private final org.spout.vanilla.component.entity.inventory.PlayerInventory playerInventory;

	public BridgeInventoryPlayer(Inventory handle, BridgePlayer holder) {
		super(handle, holder, "container.player", "Inventory", InventoryType.PLAYER);
		this.playerInventory = holder.getHandle().get(org.spout.vanilla.component.entity.inventory.PlayerInventory.class);
	}

	@Override
	public ItemStack[] getArmorContents() {
		return new ItemStack[0];  //To change body of implemented methods use File | Settings | File Templates.
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
		throw new UnsupportedOperationException();
	}

	@Override
	public void setHelmet(ItemStack itemStack) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setChestplate(ItemStack itemStack) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setLeggings(ItemStack itemStack) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBoots(ItemStack itemStack) {
		throw new UnsupportedOperationException();
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
	public HumanEntity getHolder() {
		return (HumanEntity) holder;
	}
}
