package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Silverfish;
import org.spout.api.entity.Entity;

public class BridgeSilverfish extends BridgeMonster implements Silverfish {

	protected BridgeSilverfish(Entity handle) {
		super(handle);
	}

	@Override
	public EntityType getType() {
		return EntityType.SILVERFISH;
	}
}
