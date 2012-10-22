package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.Animals;
import org.spout.api.entity.Entity;

public abstract class BridgeAnimals extends BridgeAgeable implements Animals {

	protected BridgeAnimals(Entity handle) {
		super(handle);
	}
}
