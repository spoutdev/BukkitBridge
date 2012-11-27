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
package org.spout.bridge.bukkit.entity;

import java.util.Set;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.spout.api.entity.Entity;

public abstract class BridgeHumanEntity extends BridgeLivingEntity implements HumanEntity {
	protected BridgeHumanEntity(Entity handle) {
		super(handle);
	}

	@Override
	public String getName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public PlayerInventory getInventory() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Inventory getEnderChest() {
		throw new UnsupportedOperationException();
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
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void closeInventory() {
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
	public ItemStack getItemOnCursor() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setItemOnCursor(ItemStack itemStack) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isSleeping() {
		throw new UnsupportedOperationException();
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
		//To change body of implemented methods use File | Settings | File Templates.
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
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void recalculatePermissions() {
		//To change body of implemented methods use File | Settings | File Templates.
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
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
