package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;
import org.spout.api.entity.Entity;

public class BridgePig extends BridgeAnimals implements Pig {
	protected BridgePig(Entity handle) {
		super(handle);
	}

	@Override
	public boolean hasSaddle() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setSaddle(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public EntityType getType() {
		return EntityType.PIG;
	}
}
