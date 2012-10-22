package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Golem;
import org.spout.api.entity.Entity;

public class BridgeGolem extends BridgeCreature implements Golem {

	protected BridgeGolem(Entity handle) {
		super(handle);
	}

	@Override
	public EntityType getType() {
		return EntityType.IRON_GOLEM;
	}
}
