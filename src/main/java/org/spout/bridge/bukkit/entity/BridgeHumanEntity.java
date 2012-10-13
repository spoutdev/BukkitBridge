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

public class BridgeHumanEntity extends BridgeLivingEntity implements HumanEntity {
	@Override
	public String getName() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public PlayerInventory getInventory() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Inventory getEnderChest() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean setWindowProperty(InventoryView.Property property, int i) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public InventoryView getOpenInventory() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public InventoryView openInventory(Inventory itemStacks) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public InventoryView openWorkbench(Location location, boolean b) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public InventoryView openEnchanting(Location location, boolean b) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
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
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setItemInHand(ItemStack itemStack) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public ItemStack getItemOnCursor() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setItemOnCursor(ItemStack itemStack) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isSleeping() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getSleepTicks() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public GameMode getGameMode() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setGameMode(GameMode gameMode) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isBlocking() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getExpToLevel() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isPermissionSet(String s) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isPermissionSet(Permission permission) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean hasPermission(String s) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean hasPermission(Permission permission) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b, int i) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, int i) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
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
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isOp() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setOp(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
