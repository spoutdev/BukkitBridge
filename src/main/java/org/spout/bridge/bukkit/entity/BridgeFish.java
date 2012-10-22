package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fish;
import org.spout.api.entity.Entity;

public class BridgeFish extends AbstractProjectile implements Fish {

	protected BridgeFish(Entity handle) {
		super(handle);
	}

	@Override
	public EntityType getType() {
		return EntityType.FISHING_HOOK;
	}
}
