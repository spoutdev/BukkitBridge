package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;
import org.spout.api.entity.Entity;

public class BridgeBlaze extends BridgeMonster implements Blaze {

	protected BridgeBlaze(Entity handle) {
		super(handle);
	}

	@Override
	public EntityType getType() {
		return EntityType.BLAZE;
	}
}
