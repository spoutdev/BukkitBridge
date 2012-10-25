package org.spout.bridge.bukkit.potion;

import java.util.Collection;

import org.bukkit.potion.PotionBrewer;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BridgePotionBrewer implements PotionBrewer {
	@Override
	public PotionEffect createEffect(PotionEffectType potionEffectType, int i, int i1) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<PotionEffect> getEffectsFromDamage(int i) {
		throw new UnsupportedOperationException();
	}
}
