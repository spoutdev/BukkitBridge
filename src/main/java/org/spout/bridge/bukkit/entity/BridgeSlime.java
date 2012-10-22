package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Slime;
import org.spout.api.entity.Entity;

public class BridgeSlime extends BridgeLivingEntity implements Slime {
	protected BridgeSlime(Entity handle) {
		super(handle);
	}

	@Override
	public int getSize() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setSize(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public EntityType getType() {
		return EntityType.SLIME;
	}
}
