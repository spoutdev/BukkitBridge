package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.Vehicle;
import org.spout.api.entity.Entity;

public abstract class BridgeVehicle extends BridgeEntity implements Vehicle {
	protected BridgeVehicle(Entity handle) {
		super(handle);
	}
}
