package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.ThrownExpBottle;
import org.spout.api.entity.Entity;

public class BridgeThrownExpBottle extends BridgeProjectile implements ThrownExpBottle {

	protected BridgeThrownExpBottle(Entity handle) {
		super(handle);
	}

	@Override
	public EntityType getType() {
		return EntityType.THROWN_EXP_BOTTLE;
	}
}
