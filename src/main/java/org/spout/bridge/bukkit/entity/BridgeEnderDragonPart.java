package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EnderDragonPart;
import org.bukkit.entity.EntityType;
import org.spout.api.entity.Entity;

public class BridgeEnderDragonPart extends BridgeComplexPart implements EnderDragonPart {
	protected BridgeEnderDragonPart(Entity handle) {
		super(handle);
	}

	public EnderDragon getParent() {
		return null;
	}

	@Override
	public EntityType getType() {
		return EntityType.ENDER_DRAGON;
	}
}
