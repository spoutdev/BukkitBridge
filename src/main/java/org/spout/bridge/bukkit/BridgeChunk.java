package org.spout.bridge.bukkit;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.spout.api.geo.LoadOption;

/**
 * BridgeChunk is Bridge's version of Bukkit's Chunk.
 */
public class BridgeChunk implements Chunk {
	private final BridgeWorld world;
	private final int x, z;

	public BridgeChunk(BridgeWorld world, int x, int z) {
		this.world = world;
		this.x = x;
		this.z = z;
	}

	public org.spout.api.geo.cuboid.Chunk[] getHandle(LoadOption opt) {
		org.spout.api.geo.cuboid.Chunk[] handle = new org.spout.api.geo.cuboid.Chunk[16];
		for (int i = 0; i < handle.length; i++) {
			handle[i] = world.getHandle().getChunk(x, i, z, opt);
		}
		return handle;
	}

	@Override
	public BridgeWorld getWorld() {
		return world;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getZ() {
		return z;
	}

	@Override
	public boolean load() {
		return load(true);
	}

	@Override
	public Block getBlock(int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChunkSnapshot getChunkSnapshot() {
		return getChunkSnapshot(true, true, true);
	}

	@Override
	public ChunkSnapshot getChunkSnapshot(boolean includeMaxblocky, boolean includeBiome, boolean includeBiomeTempRain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity[] getEntities() {
		// TODO Auto-generated method stub
		return new Entity[0];
	}

	@Override
	public BlockState[] getTileEntities() {
		// TODO Auto-generated method stub
		return new BlockState[0];
	}

	@Override
	public boolean isLoaded() {
		org.spout.api.geo.cuboid.Chunk[] handle = getHandle(LoadOption.NO_LOAD);
		for (int i = 0; i < handle.length; i++) {
			if (handle[i] == null || !handle[i].isLoaded()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean load(boolean arg0) {
		getHandle(LoadOption.LOAD_GEN);
		return true;
	}

	@Override
	public boolean unload() {
		return unload(true);
	}

	@Override
	public boolean unload(boolean save) {
		return unload(save, true);
	}

	@Override
	public boolean unload(boolean save, boolean safe) {
		if (safe) {
			org.spout.api.geo.cuboid.Chunk[] handle = getHandle(LoadOption.NO_LOAD);
			for (int i = 0; i < handle.length; i++) {
				if (handle[i] != null && handle[i].isLoaded()) {
					if (handle[i].getNumObservers() > 0) {
						return false;
					}
				}
			}
		}
		int amt = 0;
		org.spout.api.geo.cuboid.Chunk[] handle = getHandle(LoadOption.NO_LOAD);
		for (int i = 0; i < handle.length; i++) {
			if (handle[i] != null && handle[i].isLoaded()) {
				handle[i].unload(save);
				amt++;
			}
		}
		return amt > 0;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(x).append(z).append(world).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BridgeChunk)) {
			return false;
		}
		BridgeChunk other = (BridgeChunk)obj;
		return other.x == x && other.z == z && other.world.equals(world);
	}

	@Override
	public String toString() {
		return "BridgeChunk {x: " + x + ", z: " + z + ", world: " + world + "}";
	}
}
