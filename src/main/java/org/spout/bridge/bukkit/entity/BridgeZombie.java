package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.spout.api.entity.Entity;

public class BridgeZombie extends BridgeMonster implements Zombie {
	protected BridgeZombie(Entity handle) {
		super(handle);
	}

	@Override
	public EntityType getType() {
		return EntityType.ZOMBIE;
	}
}
