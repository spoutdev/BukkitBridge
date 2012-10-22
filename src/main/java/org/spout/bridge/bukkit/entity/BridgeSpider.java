package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Spider;
import org.spout.api.entity.Entity;

public class BridgeSpider extends BridgeMonster implements Spider {

	protected BridgeSpider(Entity handle) {
		super(handle);
	}

	@Override
	public EntityType getType() {
		return EntityType.SPIDER;
	}
}
