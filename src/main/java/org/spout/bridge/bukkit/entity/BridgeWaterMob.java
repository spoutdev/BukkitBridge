package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.WaterMob;
import org.spout.api.entity.Entity;

public abstract class BridgeWaterMob extends BridgeCreature implements WaterMob {
	protected BridgeWaterMob(Entity handle) {
		super(handle);
	}
}
