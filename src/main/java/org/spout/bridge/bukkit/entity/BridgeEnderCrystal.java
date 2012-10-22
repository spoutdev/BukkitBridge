package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.EntityType;
import org.spout.api.entity.Entity;

public class BridgeEnderCrystal extends BridgeEntity implements EnderCrystal {
	protected BridgeEnderCrystal(Entity handle) {
		super(handle);
	}

	@Override
	public EntityType getType() {
		return EntityType.ENDER_CRYSTAL;
	}
}
