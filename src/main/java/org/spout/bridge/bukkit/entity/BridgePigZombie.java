package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.PigZombie;
import org.spout.api.entity.Entity;

public class BridgePigZombie extends BridgeZombie implements PigZombie {
	protected BridgePigZombie(Entity handle) {
		super(handle);
	}

	@Override
	public int getAnger() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setAnger(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setAngry(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isAngry() {
		throw new UnsupportedOperationException();
	}
}
