package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.spout.api.entity.Entity;

public class BridgeArrow extends AbstractProjectile implements Arrow {

	protected BridgeArrow(Entity handle) {
		super(handle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public EntityType getType() {
		return EntityType.ARROW;
	}
}
