package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.Cow;
import org.bukkit.entity.EntityType;
import org.spout.api.entity.Entity;

public class BridgeCow extends BridgeAnimals implements Cow {
	protected BridgeCow(Entity handle) {
		super(handle);
	}

	@Override
	public EntityType getType() {
		return EntityType.COW;
	}
}
