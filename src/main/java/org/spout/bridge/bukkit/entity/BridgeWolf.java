package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wolf;
import org.spout.api.entity.Entity;

public class BridgeWolf extends BridgeTameableAnimal implements Wolf {
	protected BridgeWolf(Entity handle) {
		super(handle);
	}

	@Override
	public boolean isAngry() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setAngry(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isSitting() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setSitting(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public EntityType getType() {
		return EntityType.WOLF;
	}
}
