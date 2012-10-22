package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.spout.api.entity.Entity;

public class BridgeSkeleton extends BridgeMonster implements Skeleton {

	protected BridgeSkeleton(Entity handle) {
		super(handle);
	}

	@Override
	public EntityType getType() {
		return EntityType.SKELETON;
	}
}
