package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.PoweredMinecart;
import org.spout.api.entity.Entity;

public class BridgePoweredMinecart extends BridgeMinecart implements PoweredMinecart {
	protected BridgePoweredMinecart(Entity handle) {
		super(handle);
	}
}
