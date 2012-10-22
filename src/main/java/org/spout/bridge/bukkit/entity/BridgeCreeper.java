package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.spout.api.entity.Entity;

public class BridgeCreeper extends BridgeMonster implements Creeper {
	protected BridgeCreeper(Entity handle) {
		super(handle);
	}

	@Override
	public boolean isPowered() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setPowered(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public EntityType getType() {
		return EntityType.CREEPER;
	}
}
