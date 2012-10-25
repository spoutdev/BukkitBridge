package org.spout.bridge.bukkit.entity;

import java.util.Collection;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.potion.PotionEffect;
import org.spout.api.entity.Entity;

public class BridgeThrownPotion extends BridgeProjectile implements ThrownPotion {
	protected BridgeThrownPotion(Entity handle) {
		super(handle);
	}

	@Override
	public Collection<PotionEffect> getEffects() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EntityType getType() {
		return EntityType.SPLASH_POTION;
	}
}
