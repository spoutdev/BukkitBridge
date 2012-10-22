package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LightningStrike;
import org.spout.api.entity.Entity;

public class BridgeLightningStrike extends BridgeEntity implements LightningStrike {
	protected BridgeLightningStrike(Entity handle) {
		super(handle);
	}

	@Override
	public boolean isEffect() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public EntityType getType() {
		return EntityType.LIGHTNING;
	}
}
