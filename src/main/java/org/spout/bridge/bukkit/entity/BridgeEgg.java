package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;
import org.spout.api.entity.Entity;

public class BridgeEgg extends BridgeProjectile implements Egg {

	protected BridgeEgg(Entity handle) {
		super(handle);
	}

	@Override
	public EntityType getType() {
		return EntityType.EGG;
	}
}
