package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;

public class AbstractProjectile extends BridgeEntity implements Projectile {
	@Override
	public LivingEntity getShooter() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setShooter(LivingEntity livingEntity) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean doesBounce() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setBounce(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
