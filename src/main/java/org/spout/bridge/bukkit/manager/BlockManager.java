package org.spout.bridge.bukkit.manager;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.spout.bridge.bukkit.BridgeChunk;
import org.spout.bridge.bukkit.BridgeWorld;
import org.spout.bridge.bukkit.block.BridgeBlock;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

public class BlockManager {
	private static final Cache<BlockKey,BridgeBlock> blocks;
	private static final BlockKey bkey = new BlockKey();
	
	static {
		blocks = CacheBuilder.newBuilder().maximumSize(256 * 256 * 256).build(new CacheLoader<BlockKey,BridgeBlock>() {
			@Override
			public BridgeBlock load(BlockKey key) {
				BridgeChunk c = ChunkManager.getChunkAt(WorldManager.getWorld(key.getUUID()), key.getX() >> 4, key.getZ() >> 4);
				return new BridgeBlock(c, key.getX(), key.getY(), key.getZ());
			}
		});
	}

	public static Block getBlockAt(BridgeWorld world, Location location) {
		return getBlockAt(world, location.getBlockX(), location.getBlockY(), location.getBlockZ());
	}
	
	public static BridgeBlock getBlockAt(BridgeWorld world, int x, int y, int z) {
		return blocks.getUnchecked(bkey.configure(world.getUID().getMostSignificantBits(), world.getUID().getLeastSignificantBits(), x, y, z));
	}
	

	public static Biome getBiome(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public static double getHumidity(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static double getTemperature(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void setBiome(BridgeWorld world, int x, int z, Biome biome) {
		// TODO Auto-generated method stub

	}

	public static int getBlockTypeIdAt(BridgeWorld world, Location location) {
		return getBlockTypeIdAt(world, location.getBlockX(), location.getBlockY(), location.getBlockZ());
	}

	public static int getBlockTypeIdAt(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static List<MetadataValue> getBlockMetadata(BridgeWorld world, int x, int y, int z, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean hasBlockMetadata(BridgeWorld world, int x, int y, int z, String key) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void removeBlockMetadata(BridgeWorld world, int x, int y, int z, String key, Plugin owner) {
		// TODO Auto-generated method stub
		
	}

	public static void setBlockMetadata(BridgeWorld world, int x, int y, int z, String key, MetadataValue val) {
		// TODO Auto-generated method stub
		
	}

	public static boolean breakNaturally(BridgeWorld world, int x, int y, int z) {
		return breakNaturally(world, x, y, z, null);
	}

	public static boolean breakNaturally(BridgeWorld world, int x, int y, int z, ItemStack tool) {
		// TODO Auto-generated method stub
		return false;
	}

	public static int getBlockPower(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int getBlockPower(BridgeWorld world, int x, int y, int z, BlockFace face) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static byte getData(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static Collection<ItemStack> getDrops(BridgeWorld world, int x, int y, int z) {
		return getDrops(world, x, y, z, null);
	}

	public static Collection<ItemStack> getDrops(BridgeWorld world, int x, int y, int z, ItemStack tool) {
		// TODO Auto-generated method stub
		return null;
	}

	public static BlockFace getFace(BridgeWorld world, int x, int y, int z, int x2, int y2, int z2) {
		//faster method maybe?
		int modx = x2-x;
		int mody = y2-y;
		int modz = z2-z;
		for(BlockFace f : BlockFace.values()) {
			if(f.getModX() == modx && f.getModY() == mody && f.getModZ() == modz) return f;
		}
		return null;
	}

	public static byte getLightFromBlocks(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static byte getLightFromSky(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static byte getLightLevel(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static Location getLocation(BridgeWorld world, int x, int y, int z) {
		return new Location(world, x, y, z); //find some more efficient alternative to creating a new instance.
	}

	public static PistonMoveReaction getPistonMoveReaction(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Block getRelative(BridgeWorld world, int x, int y, int z, BlockFace face) {
		return getRelative(world, x, y, z, face, 1);
	}

	public static Block getRelative(BridgeWorld world, int x, int y, int z, BlockFace face, int distance) {
		return getRelative(world, x, y, z, face.getModX() * distance, face.getModY() * distance, face.getModZ() * distance);
	}

	public static Block getRelative(BridgeWorld world, int x, int y, int z, int modX, int modY, int modZ) {
		return getBlockAt(world, x + modX, y + modY, z + modZ);
	}

	public static BlockState getState(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Material getType(BridgeWorld world, int x, int y, int z) {
		return Material.getMaterial(getBlockTypeIdAt(world, x, y, z));
	}

	public static boolean isBlockFaceIndirectlyPowered(BridgeWorld world, int x, int y, int z, BlockFace face) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isBlockFacePowered(BridgeWorld world, int x, int y, int z, BlockFace face) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isBlockIndirectlyPowered(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isBlockPowered(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isEmpty(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isLiquid(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void setData(BridgeWorld world, int x, int y, int z, byte data) {
		setData(world, x,y ,z, data, true);
	}

	public static void setData(BridgeWorld world, int x, int y, int z, byte data, boolean applyPhysics) {
		setTypeIdAndData(world, x, y, z, getBlockTypeIdAt(world, x, y, z), data, applyPhysics);
	}

	public static void setType(BridgeWorld world, int x, int y, int z, Material type) {
		setTypeId(world, x, y, z, type.getId(), true);
	}

	public static boolean setTypeId(BridgeWorld world, int x, int y, int z, int id) {
		return setTypeId(world, x, y, z, id, true);
	}

	public static boolean setTypeId(BridgeWorld world, int x, int y, int z, int id, boolean applyPhysics) {
		return setTypeIdAndData(world, x, y, z, id, getData(world, x, y, z), applyPhysics);
	}

	public static boolean setTypeIdAndData(BridgeWorld world, int x, int y, int z, int type, byte data, boolean applyPhysics) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private static class BlockKey {
		private long high;
		private long low;
		
		private int x, y, z;
		
		public BlockKey configure(long high, long low, int x, int y, int z) {
			this.high = high;
			this.low = low;
			this.x = x;
			this.y = y;
			this.z = z;
			return this;
		}
		
		public UUID getUUID() {
			return new UUID(high, low);
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
		
		public int getZ() {
			return z;
		}
	}
}
