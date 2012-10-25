package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.Boat;
import org.bukkit.entity.EntityType;
import org.spout.api.entity.Entity;

public class BridgeBoat extends BridgeVehicle implements Boat {
	protected BridgeBoat(Entity handle) {
		super(handle);
	}

	@Override
	public double getMaxSpeed() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setMaxSpeed(double v) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public double getOccupiedDeceleration() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOccupiedDeceleration(double v) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public double getUnoccupiedDeceleration() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setUnoccupiedDeceleration(double v) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean getWorkOnLand() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setWorkOnLand(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public EntityType getType() {
		return EntityType.BOAT;
	}
}
