package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;
import org.spout.api.entity.Entity;

public class BridgeChicken extends BridgeAnimals implements Chicken {

	protected BridgeChicken(Entity handle) {
		super(handle);
	}

	@Override
	public EntityType getType() {
		return EntityType.CHICKEN;
	}
}
