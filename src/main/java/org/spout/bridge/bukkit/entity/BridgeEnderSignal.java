package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EnderSignal;
import org.bukkit.entity.EntityType;
import org.spout.api.entity.Entity;

public class BridgeEnderSignal extends BridgeEntity implements EnderSignal {
	protected BridgeEnderSignal(Entity handle) {
		super(handle);
	}

	@Override
	public EntityType getType() {
		return EntityType.ENDER_SIGNAL;
	}
}
