package org.spout.bridge.bukkit.entity;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingSand;
import org.spout.api.entity.Entity;

public class BridgeFallingSand extends BridgeEntity implements FallingSand {
	protected BridgeFallingSand(Entity handle) {
		super(handle);
	}

	@Override
	public Material getMaterial() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getBlockId() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public byte getBlockData() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean getDropItem() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setDropItem(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public EntityType getType() {
		return EntityType.FALLING_BLOCK;
	}
}
