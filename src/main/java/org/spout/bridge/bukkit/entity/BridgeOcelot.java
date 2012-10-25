package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ocelot;
import org.spout.api.entity.Entity;

public class BridgeOcelot extends BridgeTameableAnimal implements Ocelot {
	protected BridgeOcelot(Entity handle) {
		super(handle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Type getCatType() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setCatType(Type type) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isSitting() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setSitting(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public EntityType getType() {
		return EntityType.OCELOT;
	}
}
