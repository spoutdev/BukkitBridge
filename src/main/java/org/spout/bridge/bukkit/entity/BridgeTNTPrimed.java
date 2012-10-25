package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.spout.api.entity.Entity;

public class BridgeTNTPrimed extends BridgeEntity implements TNTPrimed {
	protected BridgeTNTPrimed(Entity handle) {
		super(handle);
	}

	@Override
	public void setFuseTicks(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getFuseTicks() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setYield(float v) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public float getYield() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsIncendiary(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isIncendiary() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EntityType getType() {
		return EntityType.PRIMED_TNT;
	}
}
