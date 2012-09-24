package org.spout.bridge.bukkit;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.spout.bridge.bukkit.manager.BlockManager;
import org.spout.bridge.bukkit.manager.ChunkManager;

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
	
	@Override
	public Block getBlock(int x, int y, int z) {
		return BlockManager.getBlockAt(getWorld(), x, y, z);
	}

	@Override
	public ChunkSnapshot getChunkSnapshot() {
		return ChunkManager.getChunkSnapshot(getWorld(), getX(), getZ());
	}

	@Override
	public ChunkSnapshot getChunkSnapshot(boolean includeMaxBlockY, boolean includeBiome, boolean includeBiomeTempRain) {
		return ChunkManager.getChunkSnapshot(getWorld(), getX(), getZ(), includeMaxBlockY, includeBiome, includeBiomeTempRain);
	}

	@Override
	public Entity[] getEntities() {
		return ChunkManager.getEntitiesAt(getWorld(), getX(), getZ());
	}

	@Override
	public BlockState[] getTileEntities() {
		return ChunkManager.getTileEntitiesAt(getWorld(), getX(), getZ());
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
	public boolean isLoaded() {
		return ChunkManager.isChunkLoaded(getWorld(), this);
	}

	@Override
	public boolean load() {
		return load(true);
	}

	@Override
	public boolean load(boolean generate) {
		return ChunkManager.loadChunk(getWorld(), getX(), getZ(), generate);
	}

	@Override
	public boolean unload() {
		return ChunkManager.unloadChunk(getWorld(), getX(), getZ());
	}

	@Override
	public boolean unload(boolean save) {
		return ChunkManager.unloadChunk(getWorld(), getX(), getZ(), save);
	}

	@Override
	public boolean unload(boolean save, boolean safe) {
		return ChunkManager.unloadChunk(getWorld(), getX(), getZ(), save, safe);
	}

}
