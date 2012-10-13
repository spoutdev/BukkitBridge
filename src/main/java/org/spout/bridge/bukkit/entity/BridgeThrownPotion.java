package org.spout.bridge.bukkit.entity;

import java.util.Collection;

import org.bukkit.entity.ThrownPotion;
import org.bukkit.potion.PotionEffect;

public class BridgeThrownPotion extends BridgeProjectile implements ThrownPotion {
	@Override
	public Collection<PotionEffect> getEffects() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
