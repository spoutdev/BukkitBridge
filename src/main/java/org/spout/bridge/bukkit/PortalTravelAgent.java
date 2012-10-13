package org.spout.bridge.bukkit;

import org.bukkit.Location;
import org.bukkit.TravelAgent;

public class PortalTravelAgent implements TravelAgent {
	@Override
	public TravelAgent setSearchRadius(int i) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getSearchRadius() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public TravelAgent setCreationRadius(int i) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getCreationRadius() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean getCanCreatePortal() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setCanCreatePortal(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Location findOrCreate(Location location) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Location findPortal(Location location) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean createPortal(Location location) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
