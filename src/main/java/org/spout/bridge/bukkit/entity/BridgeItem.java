package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.spout.api.entity.Entity;

public class BridgeItem extends BridgeEntity implements Item {
	protected BridgeItem(Entity handle) {
		super(handle);
	}

	@Override
	public ItemStack getItemStack() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setItemStack(ItemStack itemStack) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getPickupDelay() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setPickupDelay(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public EntityType getType() {
		return EntityType.DROPPED_ITEM;
	}
}
