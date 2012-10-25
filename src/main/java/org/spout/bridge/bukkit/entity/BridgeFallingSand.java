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
		throw new UnsupportedOperationException();
	}

	@Override
	public int getBlockId() {
		throw new UnsupportedOperationException();
	}

	@Override
	public byte getBlockData() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean getDropItem() {
		throw new UnsupportedOperationException();
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
