package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.EntityType;
import org.spout.api.entity.Entity;

public class BridgeEnderPearl extends BridgeProjectile implements EnderPearl {

	protected BridgeEnderPearl(Entity handle) {
		super(handle);
	}

	@Override
	public EntityType getType() {
		return EntityType.ENDER_PEARL;
	}
}
