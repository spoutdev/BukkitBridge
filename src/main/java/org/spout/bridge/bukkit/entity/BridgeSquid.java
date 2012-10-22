package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Squid;
import org.spout.api.entity.Entity;

public class BridgeSquid extends BridgeWaterMob implements Squid {

	protected BridgeSquid(Entity handle) {
		super(handle);
	}

	@Override
	public EntityType getType() {
		return EntityType.SQUID;
	}
}
