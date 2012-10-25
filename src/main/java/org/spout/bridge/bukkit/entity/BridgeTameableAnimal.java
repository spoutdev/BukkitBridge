package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Tameable;
import org.spout.api.entity.Entity;

public abstract class BridgeTameableAnimal extends BridgeAnimals implements Tameable, Creature {
	protected BridgeTameableAnimal(Entity handle) {
		super(handle);
	}

	@Override
	public boolean isTamed() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setTamed(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public AnimalTamer getOwner() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOwner(AnimalTamer animalTamer) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
