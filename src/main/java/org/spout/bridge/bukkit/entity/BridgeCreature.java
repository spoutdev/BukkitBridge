package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.Creature;
import org.bukkit.entity.LivingEntity;
import org.spout.api.entity.Entity;

public abstract class BridgeCreature extends BridgeLivingEntity implements Creature {
	protected BridgeCreature(Entity handle) {
		super(handle);
	}

	@Override
	public void setTarget(LivingEntity livingEntity) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public LivingEntity getTarget() {
		throw new UnsupportedOperationException();
	}
}
