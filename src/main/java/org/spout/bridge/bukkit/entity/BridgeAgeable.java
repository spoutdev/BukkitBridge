package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.Ageable;

public class BridgeAgeable extends BridgeCreature implements Ageable {
	@Override
	public int getAge() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setAge(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setAgeLock(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean getAgeLock() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setBaby() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setAdult() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isAdult() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean canBreed() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setBreed(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
