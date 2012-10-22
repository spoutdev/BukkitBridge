package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.IronGolem;
import org.spout.api.entity.Entity;

public class BridgeIronGolem extends BridgeGolem implements IronGolem {
	protected BridgeIronGolem(Entity handle) {
		super(handle);
	}

	@Override
	public boolean isPlayerCreated() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setPlayerCreated(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
