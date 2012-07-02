package org.spout.bridge.bukkit;

import java.util.Collection;
import java.util.List;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

/**
 * BridgeChunk is an implementation of Chunk. It delegates all of its method calls
 * to BridgeWorld.
 * <br />
 * <br />
 * BridgeBlock delegates its calls here. The calls from BridgeBlock are condensed
 * and delegated. to BridgeWorld.
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
		return this.getWorld().getBlockAt(x, y, z);
	}

	@Override
	public ChunkSnapshot getChunkSnapshot() {
		return getWorld().getChunkSnapshot(getX(), getZ());
	}

	@Override
	public ChunkSnapshot getChunkSnapshot(boolean includeMaxBlockY, boolean includeBiome, boolean inlcudeBiomeTempRain) {
		return getWorld().getChunkSnapshot(getX(), getZ(), includeMaxBlockY, includeBiome, inlcudeBiomeTempRain);
	}

	@Override
	public Entity[] getEntities() {
		return getWorld().getEntitiesAt(getX(), getZ());
	}

	@Override
	public BlockState[] getTileEntities() {
		return getWorld().getTileEntitiesAt(getX(), getZ());
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
		return getWorld().isChunkLoaded(this);
	}

	@Override
	public boolean load() {
		return load(true);
	}

	@Override
	public boolean load(boolean generate) {
		return getWorld().loadChunk(getX(), getZ(), generate);
	}

	@Override
	public boolean unload() {
		return getWorld().unloadChunk(getX(), getZ());
	}

	@Override
	public boolean unload(boolean save) {
		return getWorld().unloadChunk(getX(), getZ(), save);
	}

	@Override
	public boolean unload(boolean save, boolean safe) {
		return getWorld().unloadChunk(getX(), getZ(), save, safe);
	}

//----------------------------------------------------------------------//
//----------------------------------------------------------------------//
//----//				BridgeBlock Delegations					 //-----//
//----------------------------------------------------------------------//
//----------------------------------------------------------------------//
	
	public List<MetadataValue> getMetadata(Block b, String key) {
		return getMetadata(b.getX(), b.getY(), b.getZ(), key);
	}
	
	public List<MetadataValue> getMetadata(int x, int y, int z, String key) {
		return getWorld().getMetadata(x, y, z, key);
	}

	public boolean hasMetadata(Block b, String key) {
		return hasMetadata(b.getX(), b.getY(), b.getZ(), key);
	}
	
	public boolean hasMetadata(int x, int y, int z, String key) {
		return getWorld().hasMetadata(x, y, z, key);
	}

	public void removeMetadata(Block b, String key, Plugin owner) {
		removeMetadata(b.getX(), b.getY(), b.getZ(), key, owner);
	}
	
	public void removeMetadata(int x, int y, int z, String key, Plugin owner) {
		getWorld().removeMetadata(x, y, z, key, owner);
	}

	public void setMetadata(Block b, String key, MetadataValue val) {
		setMetadata(b.getX(), b.getY(), b.getZ(), key, val);
	}
	
	public void setMetadata(int x, int y, int z, String key, MetadataValue val) {
		getWorld().setMetadata(x, y, z, key, val);
	}

	public boolean breakNaturally(Block b) {
		return breakNaturally(b, null);
	}
	
	public boolean breakNaturally(int x, int y, int z) {
		return breakNaturally(x, y, z, null);
	}
	
	public boolean breakNaturally(Block b, ItemStack tool) {
		return breakNaturally(b.getX(), b.getY(), b.getZ(), tool);
	}

	public boolean breakNaturally(int x, int y, int z, ItemStack tool) {
		return getWorld().breakNaturally(x, y, z, tool);
	}

	public Biome getBiome(Block b) {
		return getBiome(b.getX(), b.getZ());
	}
	
	public Biome getBiome(int x, int z) {
		return getWorld().getBiome(x, z);
	}

	public int getBlockPower(Block b) {
		return getBlockPower(b, null);
	}
	
	public int getBlockPower(int x, int y, int z) {
		return getBlockPower(x, y, z, null);
	}
	
	public int getBlockPower(Block b, BlockFace face) {
		return getBlockPower(b.getX(), b.getY(), b.getZ(), face);
	}

	public int getBlockPower(int x, int y, int z, BlockFace face) {
		return getWorld().getBlockPower(x, y, z, face);
	}

	public byte getBlockData(Block b) {
		return getData(b.getX(), b.getY(), b.getZ());
	}
	
	public byte getData(int x, int y, int z) {
		return getWorld().getData(x, y, z);
	}
	
	public Collection<ItemStack> getDrops(Block b) {
		return getDrops(b, null);
	}

	public Collection<ItemStack> getDrops(int x, int y, int z) {
		return getDrops(x, y, z, null);
	}
	
	public Collection<ItemStack> getDrops(Block b, ItemStack tool) {
		return getDrops(b.getX(), b.getY(), b.getZ(), tool);
	}

	public Collection<ItemStack> getDrops(int x, int y, int z, ItemStack tool) {
		return getWorld().getDrops(x, y, z, tool);
	}
	
	public BlockFace getFace(Block b, Block b2) {
		return getFace(b, b2.getX(), b2.getY(), b2.getZ());
	}
	
	public BlockFace getFace(Block b, int x2, int y2, int z2) {
		return getFace(b.getX(), b.getY(), b.getZ(), x2, y2, z2);
	}
	
	public BlockFace getFace(int x, int y, int z, Block b2) {
		return getFace(x, y, z, b2.getX(), b2.getY(), b2.getZ());
	}

	public BlockFace getFace(int x, int y, int z, int x2, int y2, int z2) {
		return getWorld().getFace(x, y, z, x2, y2, z2);
	}

	public double getHumidity(Block b) {
		return getHumidity(b.getX(), b.getZ());
	}
	
	public double getHumidity(int x, int z) {
		return getWorld().getHumidity(x, z);
	}

	public byte getLightFromBlocks(Block b) {
		return getLightFromBlocks(b.getX(), b.getY(), b.getZ());
	}
	
	public byte getLightFromBlocks(int x, int y, int z) {
		return getWorld().getLightFromBlocks(x, y, z);
	}

	public byte getLightFromSky(Block b) {
		return getLightFromSky(b.getX(), b.getY(), b.getZ());
	}
	
	public byte getLightFromSky(int x, int y, int z) {
		return getWorld().getLightFromSky(x, y, z);
	}

	public byte getLightLevel(Block b) {
		return getLightLevel(b.getX(), b.getY(), b.getZ());
	}
	
	public byte getLightLevel(int x, int y, int z) {
		return getWorld().getLightLevel(x, y, z);
	}

	public Location getLocation(Block b) {
		return getLocation(b.getX(), b.getY(), b.getZ());
	}
	
	public Location getLocation(int x, int y, int z) {
		return getWorld().getLocation(x, y, z);
	}

	public PistonMoveReaction getPistonMoveReaction(Block b) {
		return getPistonMoveReaction(b.getX(), b.getY(), b.getZ());
	}
	
	public PistonMoveReaction getPistonMoveReaction(int x, int y, int z) {
		return getWorld().getPistonMoveReaction(x, y, z);
	}

	public Block getRelative(Block b, BlockFace face) {
		return getRelative(b, face, 1);
	}
	
	public Block getRelative(int x, int y, int z, BlockFace face) {
		return getRelative(x, y, z, face, 1);
	}

	public Block getRelative(Block b, BlockFace face, int distance) {
		return getRelative(b.getX(), b.getY(), b.getZ(), face, distance);
	}
	
	public Block getRelative(int x, int y, int z, BlockFace face, int distance) {
		return getRelative(x, y, z, face.getModX() * distance, face.getModY() * distance, face.getModZ() * distance);
	}
	
	public Block getRelative(Block b, int modX, int modY, int modZ) {
		return getRelative(b.getX(), b.getY(), b.getZ(), modX, modY, modZ);
	}

	public Block getRelative(int x, int y, int z, int modX, int modY, int modZ) {
		return getWorld().getRelative(x, y, z, modX, modY, modZ);
	}
	
	public BlockState getState(Block b) {
		return getState(b.getX(), b.getY(), b.getZ());
	}

	public BlockState getState(int x, int y, int z) {
		return getWorld().getState(x, y, z);
	}

	public double getTemperature(Block b) {
		return getTemperature(b.getX(), b.getZ());
	}
	
	public double getTemperature(int x, int z) {
		return getWorld().getTemperature(x, z);
	}

	public Material getType(Block b) {
		return getType(b.getX(), b.getY(), b.getZ());
	}
	
	public Material getType(int x, int y, int z) {
		return getWorld().getType(x, y, z);
	}

	public int getTypeId(Block b) {
		return getTypeId(b.getX(), b.getY(), b.getZ());
	}
	
	public int getTypeId(int x, int y, int z) {
		return getWorld().getBlockTypeIdAt(x, y, z);
	}

	public boolean isBlockFaceIndirectlyPowered(Block b, BlockFace face) {
		return isBlockFaceIndirectlyPowered(b.getX(), b.getY(), b.getZ(), face);
	}
	
	public boolean isBlockFaceIndirectlyPowered(int x, int y, int z, BlockFace face) {
		return getWorld().isBlockFaceIndirectlyPowered(x, y, z, face);
	}

	public boolean isBlockFacePowered(Block b, BlockFace face) {
		return isBlockFacePowered(b.getX(), b.getY(), b.getZ(), face);
	}
	
	public boolean isBlockFacePowered(int x, int y, int z, BlockFace face) {
		return getWorld().isBlockFacePowered(x, y, z, face);
	}

	public boolean isBlockIndirectlyPowered(Block b) {
		return isBlockIndirectlyPowered(b.getX(), b.getY(), b.getZ());
	}
	
	public boolean isBlockIndirectlyPowered(int x, int y, int z) {
		return getWorld().isBlockIndirectlyPowered(x, y, z);
	}

	public boolean isBlockPowered(Block b) {
		return isBlockPowered(b.getX(), b.getY(), b.getZ());
	}
	
	public boolean isBlockPowered(int x, int y, int z) {
		return getWorld().isBlockPowered(x, y, z);
	}

	public boolean isEmpty(Block b) {
		return isEmpty(b.getX(), b.getY(), b.getZ());
	}
	
	public boolean isEmpty(int x, int y, int z) {
		return getWorld().isEmpty(x, y, z);
	}

	public boolean isLiquid(Block b) {
		return isLiquid(b.getX(), b.getY(), b.getZ());
	}

	public boolean isLiquid(int x, int y, int z) {
		return getWorld().isLiquid(x, y, z);
	}

	public void setBiome(Block b, Biome biome) {
		setBiome(b.getX(), b.getZ(), biome);
	}
	
	public void setBiome(int x, int z, Biome biome) {
		getWorld().setBiome(x, z, biome);
	}

	public void setData(Block b, byte data) {
		setData(b, data, true);
	}
	
	public void setData(int x, int y, int z, byte data) {
		setData(x, y, z, data, true);
	}

	public void setData(Block b, byte data, boolean applyPhysics) {
		setData(b.getX(), b.getY(), b.getZ(), data, applyPhysics);
	}

	public void setData(int x, int y, int z, byte data, boolean applyPhysics) {
		getWorld().setData(x, y, z, data, applyPhysics);
	}

	public void setType(Block b, Material type) {
		setType(b.getX(), b.getY(), b.getZ(), type);
	}
	
	public void setType(int x, int y, int z, Material type) {
		getWorld().setType(x, y, z, type);
	}

	public boolean setTypeId(Block b, int id) {
		return setTypeId(b, id, true);
	}
	
	public boolean setTypeId(int x, int y, int z, int id) {
		return setTypeId(x, y, z, id, true);
	}
	
	public boolean setTypeId(Block b, int id, boolean applyPhysics) {
		return setTypeId(b.getX(), b.getY(), b.getZ(), id, applyPhysics);
	}

	public boolean setTypeId(int x, int y, int z, int id, boolean applyPhysics) {
		return getWorld().setTypeId(x, y, z, id, applyPhysics);
	}

	public boolean setTypeIdAndData(Block b, int id, byte data, boolean applyPhysics) {
		return setTypeIdAndData(b.getX(), b.getY(), b.getZ(), id, data, applyPhysics);
	}
	
	public boolean setTypeIdAndData(int x, int y, int z, int type, byte data, boolean applyPhysics) {
		return getWorld().setTypeIdAndData(x, y, z, type, data, applyPhysics);
	}

}
