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
package org.spout.bridge.bukkit.entity;

import java.util.Set;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

import org.spout.api.entity.Entity;

import org.spout.bridge.BukkitUtil;
import org.spout.bridge.bukkit.inventory.BridgeInventory;
import org.spout.bridge.bukkit.inventory.BridgeInventoryPlayer;

import org.spout.vanilla.component.entity.misc.Sleep;

public abstract class BridgeHumanEntity extends BridgeLivingEntity implements HumanEntity {
	private BridgeInventoryPlayer inventory;
	private BridgeInventory enderInventory;

	protected BridgeHumanEntity(Entity handle) {
		super(handle);
		this.inventory = new BridgeInventoryPlayer(getHandle().get(org.spout.vanilla.component.entity.inventory.PlayerInventory.class).getMain(), (BridgePlayer) this);
		this.enderInventory = new BridgeInventory(getHandle().get(org.spout.vanilla.component.entity.inventory.PlayerInventory.class).getEnderChestInventory(), this, "container.enderchest", "container.enderchest", InventoryType.ENDER_CHEST);
	}

	@Override
	public PlayerInventory getInventory() {
		return inventory;
	}

	@Override
	public Inventory getEnderChest() {
		return enderInventory;
	}

	@Override
	public boolean setWindowProperty(InventoryView.Property property, int i) {
		throw new UnsupportedOperationException();
	}

	@Override
	public InventoryView getOpenInventory() {
		throw new UnsupportedOperationException();
	}

	@Override
	public InventoryView openInventory(Inventory itemStacks) {
		throw new UnsupportedOperationException();
	}

	@Override
	public InventoryView openWorkbench(Location location, boolean b) {
		throw new UnsupportedOperationException();
	}

	@Override
	public InventoryView openEnchanting(Location location, boolean b) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void openInventory(InventoryView inventoryView) {
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public ItemStack getItemInHand() {
		org.spout.vanilla.component.entity.inventory.PlayerInventory inv = getHandle().get(org.spout.vanilla.component.entity.inventory.PlayerInventory.class);
		return inv == null ? null : BukkitUtil.fromItemStack(inv.getHeldItem());
	}

	@Override
	public void setItemInHand(ItemStack itemStack) {
		org.spout.vanilla.component.entity.inventory.PlayerInventory inv = getHandle().get(org.spout.vanilla.component.entity.inventory.PlayerInventory.class);
		if (inv != null) {
			inv.getQuickbar().set(inv.getQuickbar().getSelectedSlot().getIndex(), BukkitUtil.toItemStack(itemStack));
		}
	}

	@Override
	public ItemStack getItemOnCursor() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setItemOnCursor(ItemStack itemStack) {
	}

	@Override
	public boolean isSleeping() {
		Sleep sleep = getHandle().get(Sleep.class);
		return sleep != null ? sleep.isSleeping() : false;
	}

	@Override
	public int getSleepTicks() {
		throw new UnsupportedOperationException();
	}

	@Override
	public GameMode getGameMode() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setGameMode(GameMode gameMode) {
	}

	@Override
	public boolean isBlocking() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getExpToLevel() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isPermissionSet(String s) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isPermissionSet(Permission permission) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasPermission(String s) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasPermission(Permission permission) {
		throw new UnsupportedOperationException();
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b) {
		throw new UnsupportedOperationException();
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin) {
		throw new UnsupportedOperationException();
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b, int i) {
		throw new UnsupportedOperationException();
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, int i) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeAttachment(PermissionAttachment permissionAttachment) {
	}

	@Override
	public void recalculatePermissions() {
	}

	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isOp() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOp(boolean b) {
	}

	@Override
	public boolean getCanPickupItems() {
		return true;
	}
}
