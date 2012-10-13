package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.Boat;

public class BridgeBoat extends BridgeVehicle implements Boat {
	@Override
	public double getMaxSpeed() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setMaxSpeed(double v) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public double getOccupiedDeceleration() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setOccupiedDeceleration(double v) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public double getUnoccupiedDeceleration() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setUnoccupiedDeceleration(double v) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean getWorkOnLand() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setWorkOnLand(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
