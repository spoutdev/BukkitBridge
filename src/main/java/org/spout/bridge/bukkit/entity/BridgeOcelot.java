package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.Ocelot;

public class BridgeOcelot extends BridgeTameableAnimal implements Ocelot {
	@Override
	public Type getCatType() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setCatType(Type type) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isSitting() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setSitting(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
