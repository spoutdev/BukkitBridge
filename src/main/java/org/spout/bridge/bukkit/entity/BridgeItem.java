package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class BridgeItem extends BridgeEntity implements Item {
	@Override
	public ItemStack getItemStack() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setItemStack(ItemStack itemStack) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getPickupDelay() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setPickupDelay(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
