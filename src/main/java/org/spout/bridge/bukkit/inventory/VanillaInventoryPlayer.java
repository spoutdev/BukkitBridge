package org.spout.bridge.bukkit.inventory;

import org.spout.api.inventory.Inventory;
import org.spout.vanilla.component.inventory.PlayerInventory;

/* 
 * In Vanilla, a player inventory is split into 3 different sub-inventories
 * (quickbar, main, and armor), as opposed to the single inventory in Bukkit.
 * This class acts as the single BukkitBridge inventory, and has methods to sync
 * itself with Vanilla's PlayerInventory object.
 */

public final class VanillaInventoryPlayer extends Inventory {
	private static final long serialVersionUID = 1L;
	public static final int SIZE = 40;
	private PlayerInventory inventory;
	
	public VanillaInventoryPlayer(PlayerInventory inventory) {
		super(SIZE);
		this.inventory = inventory;
		syncWithVanilla();
	}
	
	protected int getHeldItemSlot() {
		return inventory.getQuickbar().getCurrentSlot();
	}
	
/* 
 * Synchronization methods between the SpoutInventoryPlayer
 * and the Vanilla PlayerInventory object.
 */
	protected void syncWithVanilla(int i) {
		if (i < 9)
			set(i, inventory.getQuickbar().get(i));
		else if (i < 36)
			set(i, inventory.getMain().get(i - 9));
		else
			set(i, inventory.getArmor().get(i - 36));
	}
	
	protected void syncWithVanilla() {
		for (int i = 0; i < 40; i++)
			syncWithVanilla(i);
	}
	
	protected void syncVanillaWith(int i) {
			if (i < 9)
				inventory.getQuickbar().set(i, get(i));
			else if (i < 36)
				inventory.getMain().set(i - 9, get(i));
			else
				inventory.getArmor().set(i - 36, get(i));
	}
	
	protected void syncVanillaWith() {
		for (int i = 0; i < 40; i++)
			syncVanillaWith(i);
	}
	
}
