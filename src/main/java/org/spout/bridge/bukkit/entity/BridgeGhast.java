package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ghast;
import org.spout.api.entity.Entity;

public class BridgeGhast extends BridgeFlying implements Ghast {

	protected BridgeGhast(Entity handle) {
		super(handle);
	}

	@Override
	public EntityType getType() {
		return EntityType.GHAST;
	}
}
