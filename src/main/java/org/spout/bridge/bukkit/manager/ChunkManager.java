package org.spout.bridge.bukkit.manager;

import java.util.UUID;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.spout.bridge.bukkit.BridgeChunk;
import org.spout.bridge.bukkit.BridgeChunkSnapshot;
import org.spout.bridge.bukkit.BridgeWorld;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

public class ChunkManager {
	private static final Cache<ChunkKey,BridgeChunk> chunks;
	private static final ChunkKey ckey = new ChunkKey();
	
	static {
		chunks = CacheBuilder.newBuilder().maximumSize(256 * 256 * 256).build(new CacheLoader<ChunkKey,BridgeChunk>() {
			@Override
			public BridgeChunk load(ChunkKey key) {
				BridgeWorld w = WorldManager.getWorld(key.getUUID());
				return new BridgeChunk(w, key.getX(), key.getZ());
			}
		});
	}

	public static BridgeChunk getChunkAt(BridgeWorld world, Location location) {
		return getChunkAt(world, (int) location.getX(), (int) location.getZ());
	}

	public static BridgeChunk getChunkAt(BridgeWorld world, Block block) {
		return getChunkAt(world, block.getX(), block.getZ());
	}

	public static BridgeChunk getChunkAt(BridgeWorld world, int x, int z) {
		return chunks.getUnchecked(ckey.configure(world.getUID().getMostSignificantBits(), world.getUID().getLeastSignificantBits(), x, z));
	}

	public static void loadChunk(BridgeWorld world, int x, int z) {
		loadChunk(world, x, z, true);
	}

	public static boolean loadChunk(BridgeWorld world, int x, int z, boolean generate) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isChunkLoaded(BridgeWorld world, Chunk chunk) {
		return isChunkLoaded(world, chunk.getX(), chunk.getZ());
	}

	public static boolean isChunkLoaded(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean unloadChunk(BridgeWorld world, Chunk chunk) {
		return unloadChunk(world, chunk.getX(), chunk.getZ());
	}

	public static boolean unloadChunk(BridgeWorld world, int x, int z) {
		return unloadChunk(world, x, z, true);
	}

	public static boolean unloadChunk(BridgeWorld world, int x, int z, boolean save) {
		return unloadChunk(world, x, z, save, false);
	}

	public static boolean unloadChunk(BridgeWorld world, int x, int z, boolean save, boolean safe) {
		// TODO Auto-generated method stub
		return false;
	}

	public static ChunkSnapshot getChunkSnapshot(BridgeWorld world, Chunk chunk) {
		return getChunkSnapshot(world, chunk.getX(), chunk.getZ());
	}

	public static ChunkSnapshot getChunkSnapshot(BridgeWorld world, int x, int z) {
		return getChunkSnapshot(world, x, z, true, false, false);
	}

	public static ChunkSnapshot getChunkSnapshot(BridgeWorld world, int x, int z, boolean includeMaxBlockY, boolean includeBiome, boolean includeBiomeTempRain) {
		int height = WorldManager.getMaxHeight(world);
		int alen = height / 16;
		short[][] sectionBlockIDs = new short[alen][4096];
		byte[][] sectionBlockData = new byte[alen][2048];
		byte[][] sectionSkyLights = new byte[alen][2048];
		byte[][] sectionEmitLights = new byte[alen][2048];
		boolean[] sectionEmpty = new boolean[alen];
		for (int py = 0; py < height; py+=16) {
			boolean empty = true;
			for(int px = 0; x < 16; x++) {
				for(int pz = 0; z < 16; z++) {
					sectionBlockIDs[py >> 4][((py & 0xF) << 8) | (pz << 4) | px] = (short) BlockManager.getBlockTypeIdAt(world, px, py, pz);
					sectionBlockData[py >> 4][((py & 0xF) << 8) | (pz << 4) | px] = BlockManager.getData(world, px, py, pz);
					sectionSkyLights[py >> 4][((py & 0xF) << 8) | (pz << 4) | px] = BlockManager.getLightFromSky(world, px, py, pz);
					//TODO sectionEmitLights[py >> 4][((py & 0xF) << 8) | (pz << 4) | px] = ....?
					empty = empty && BlockManager.getBlockTypeIdAt(world, px, py, pz) == 0;
				}
			}
			sectionEmpty[py >> 4] = empty;
		}

		int[] hmap = null;
		if (includeMaxBlockY) {
			hmap = new int[256]; // Get copy of height map
			for(int px = 0; x < 16; x++) {
				for(int pz = 0; z < 16; z++) {
					hmap[z << 4 | x] = WorldManager.getHighestBlockYAt(world, px, pz);
				}
			}
		}

		Biome[] biome = null;
		double[] biomeTemp = null;
		double[] biomeRain = null;
		if (includeBiome ||includeBiomeTempRain ) {
			if(includeBiome) biome = new Biome[256];
			if (includeBiomeTempRain) {
				biomeTemp = new double[256];
				biomeRain = new double[256];
			}
			for(int px = 0; x < 16; x++) {
				for(int pz = 0; z < 16; z++) {
					if(includeBiome) biome[z << 4 | x] = BlockManager.getBiome(world, px, pz);
					if (includeBiomeTempRain) {
						biomeTemp[z << 4 | x] = BlockManager.getTemperature(world, px, pz);
						biomeRain[z << 4 | x] = BlockManager.getHumidity(world, px, pz);
					}
				}
			}
		}

		return new BridgeChunkSnapshot(x, z, WorldManager.getName(world), WorldManager.getFullTime(world), sectionBlockIDs, sectionBlockData, sectionSkyLights, sectionEmitLights, sectionEmpty, hmap, biome, biomeTemp, biomeRain);
	}

	public static Entity[] getEntitiesAt(BridgeWorld world, Chunk chunk) {
		return getEntitiesAt(world, chunk.getX(), chunk.getZ());
	}

	public static Entity[] getEntitiesAt(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public BlockState[] getTileEntitiesAt(BridgeWorld world, Chunk chunk) {
		return getTileEntitiesAt(world, chunk.getX(), chunk.getZ());
	}

	public static BlockState[] getTileEntitiesAt(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static class ChunkKey {
		private long high;
		private long low;
		
		private int x, z;
		
		public ChunkKey configure(long high, long low, int x, int z) {
			this.high = high;
			this.low = low;
			this.x = x;
			this.z = z;
			return this;
		}
		
		public UUID getUUID() {
			return new UUID(high, low);
		}
		
		public int getX() {
			return x;
		}
		
		public int getZ() {
			return z;
		}
	}
}
