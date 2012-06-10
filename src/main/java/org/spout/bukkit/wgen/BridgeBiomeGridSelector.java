package org.spout.bukkit.wgen;

import java.util.HashMap;
import java.util.Map;

import org.spout.api.generator.biome.Biome;
import org.spout.api.geo.discrete.Point;
import org.spout.api.math.Vector3;
import org.spout.vanilla.world.selector.VanillaBiomeSelector;

public class BridgeBiomeGridSelector extends VanillaBiomeSelector {
	private Map<Vector3, Biome> overrides = new HashMap<Vector3, Biome>();

	public BridgeBiomeGridSelector() {
		super(2.0, 2.0, 0.35, 0.05, false);
	}
	
	public Biome pickBiome(int x, int y, int z, long seed) {
		Vector3 loc = new Vector3(x,y,z); 
		if(overrides.containsKey(loc)) return overrides.get(loc);
		return super.pickBiome(x, y, z, seed);
	}
	
	public void setBiome(Point loc, Biome biome) {
		if(super.pickBiome(loc.getFloorX(), loc.getFloorY(), loc.getFloorZ(), loc.getWorld().getSeed()).equals(biome)) overrides.remove(loc);
		overrides.remove(loc);
		overrides.put(loc, biome);
	}

}
