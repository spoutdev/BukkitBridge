package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Giant;
import org.spout.api.entity.Entity;

public class BridgeGiant extends BridgeMonster implements Giant {
	protected BridgeGiant(Entity handle) {
		super(handle);
	}

	@Override
	public EntityType getType() {
		return EntityType.GIANT;
	}
}
