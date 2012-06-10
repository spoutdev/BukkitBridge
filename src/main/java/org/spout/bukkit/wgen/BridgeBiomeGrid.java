package org.spout.bukkit.wgen;

import org.bukkit.block.Biome;
import org.bukkit.generator.ChunkGenerator.BiomeGrid;
import org.spout.api.geo.World;
import org.spout.api.geo.discrete.Point;
import org.spout.bukkit.util.BridgeUtil;

public class BridgeBiomeGrid implements BiomeGrid {
	private BridgeBiomeGridSelector sel;
	private World world;
	
	public BridgeBiomeGrid(World world) {
		sel = new BridgeBiomeGridSelector();
		this.world = world;
	}
	
	@Override
	public Biome getBiome(int x, int z) {
		return BridgeUtil.toBiome(getVanillaBiome(x,z));
	}

	@Override
	public void setBiome(int x, int z, Biome biome) {
		sel.setBiome(new Point(world, x, 0, z), BridgeUtil.toVanillaBiome(biome));
	}

	public org.spout.api.generator.biome.Biome getVanillaBiome(int x, int z) {
		return sel.pickBiome(x, z, world.getSeed());
	}

}
