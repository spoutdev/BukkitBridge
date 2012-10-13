package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.Creeper;

public class BridgeCreeper extends BridgeMonster implements Creeper {
	@Override
	public boolean isPowered() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setPowered(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
