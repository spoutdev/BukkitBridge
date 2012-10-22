package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Snowball;
import org.spout.api.entity.Entity;

public class BridgeSnowball extends BridgeProjectile implements Snowball {

	protected BridgeSnowball(Entity handle) {
		super(handle);
	}

	@Override
	public EntityType getType() {
		return EntityType.SNOWBALL;
	}
}
