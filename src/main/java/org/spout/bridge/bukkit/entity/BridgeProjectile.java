package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.Projectile;
import org.spout.api.entity.Entity;

public abstract class BridgeProjectile extends AbstractProjectile implements Projectile {

	protected BridgeProjectile(Entity handle) {
		super(handle);
	}
}
