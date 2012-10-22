package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.util.Vector;
import org.spout.api.entity.Entity;

public class BridgeFireball extends AbstractProjectile implements Fireball {
	protected BridgeFireball(Entity handle) {
		super(handle);
	}

	@Override
	public void setDirection(Vector vector) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Vector getDirection() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setYield(float v) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public float getYield() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setIsIncendiary(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isIncendiary() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public EntityType getType() {
		return EntityType.FIREBALL;
	}
}
