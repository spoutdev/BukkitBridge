package org.spout.bridge.bukkit.block;

import java.util.Collection;
import java.util.List;

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
import org.spout.bridge.bukkit.manager.BlockManager;

/**
 * BridgeBlock is an implementation of Block. It delegates all method calls to its corresponding BridgeChunk.
 */
public class BridgeBlock implements Block {
	private final BridgeChunk chunk;
	private final int x, y, z;
	
	public BridgeBlock(BridgeChunk chunk, int x, int y, int z) {
		this.chunk = chunk;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public List<MetadataValue> getMetadata(String key) {
		return BlockManager.getBlockMetadata(getWorld(), getX(), getY(), getZ(), key);
	}

	@Override
	public boolean hasMetadata(String key) {
		return BlockManager.hasBlockMetadata(getWorld(), getX(), getY(), getZ(), key);
	}

	@Override
	public void removeMetadata(String key, Plugin owner) {
		BlockManager.removeBlockMetadata(getWorld(), getX(), getY(), getZ(), key, owner);
	}

	@Override
	public void setMetadata(String key, MetadataValue val) {
		BlockManager.setBlockMetadata(getWorld(), getX(), getY(), getZ(), key, val);
	}

	@Override
	public boolean breakNaturally() {
		return BlockManager.breakNaturally(getWorld(), getX(), getY(), getZ());
	}

	@Override
	public boolean breakNaturally(ItemStack tool) {
		return BlockManager.breakNaturally(getWorld(), getX(), getY(), getZ(), tool);
	}

	@Override
	public Biome getBiome() {
		return BlockManager.getBiome(getWorld(), getX(), getZ());
	}

	@Override
	public int getBlockPower() {
		return BlockManager.getBlockPower(getWorld(), getX(), getY(), getZ());
	}

	@Override
	public int getBlockPower(BlockFace face) {
		return BlockManager.getBlockPower(getWorld(), getX(), getY(), getZ(), face);
	}

	@Override
	public BridgeChunk getChunk() {
		return chunk;
	}

	@Override
	public byte getData() {
		return BlockManager.getData(getWorld(), getX(), getY(), getZ());
	}

	@Override
	public Collection<ItemStack> getDrops() {
		return BlockManager.getDrops(getWorld(), getX(), getY(), getZ());
	}

	@Override
	public Collection<ItemStack> getDrops(ItemStack tool) {
		return BlockManager.getDrops(getWorld(), getX(), getY(), getZ(), tool);
	}

	@Override
	public BlockFace getFace(Block other) {
		return BlockManager.getFace(getWorld(), getX(), getY(), getZ(), other.getX(), other.getY(), other.getZ());
	}

	@Override
	public double getHumidity() {
		return BlockManager.getHumidity(getWorld(), getX(), getZ());
	}

	@Override
	public byte getLightFromBlocks() {
		return BlockManager.getLightFromBlocks(getWorld(), getX(), getY(), getZ());
	}

	@Override
	public byte getLightFromSky() {
		return BlockManager.getLightFromSky(getWorld(), getX(), getY(), getZ());
	}

	@Override
	public byte getLightLevel() {
		return BlockManager.getLightLevel(getWorld(), getX(), getY(), getZ());
	}

	@Override
	public Location getLocation() {
		return BlockManager.getLocation(getWorld(), getX(), getY(), getZ());
	}

	@Override
	public PistonMoveReaction getPistonMoveReaction() {
		return BlockManager.getPistonMoveReaction(getWorld(), getX(), getY(), getZ());
	}

	@Override
	public Block getRelative(BlockFace face) {
		return BlockManager.getRelative(getWorld(), getX(), getY(), getZ(), face);
	}

	@Override
	public Block getRelative(BlockFace face, int distance) {
		return BlockManager.getRelative(getWorld(), getX(), getY(), getZ(), face, distance);
	}

	@Override
	public Block getRelative(int modX, int modY, int modZ) {
		return BlockManager.getRelative(getWorld(), getX(), getY(), getZ(), modX, modY, modZ);
	}

	@Override
	public BlockState getState() {
		return BlockManager.getState(getWorld(), getX(), getY(), getZ());
	}

	@Override
	public double getTemperature() {
		return BlockManager.getTemperature(getWorld(), getX(), getZ());
	}

	@Override
	public Material getType() {
		return BlockManager.getType(getWorld(), getX(), getY(), getZ());
	}

	@Override
	public int getTypeId() {
		return BlockManager.getBlockTypeIdAt(getWorld(), getX(), getY(), getZ());
	}

	@Override
	public BridgeWorld getWorld() {
		return getChunk().getWorld();
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getZ() {
		return z;
	}

	@Override
	public boolean isBlockFaceIndirectlyPowered(BlockFace face) {
		return BlockManager.isBlockFaceIndirectlyPowered(getWorld(), getX(), getY(), getZ(), face);
	}

	@Override
	public boolean isBlockFacePowered(BlockFace face) {
		return BlockManager.isBlockFacePowered(getWorld(), getX(), getY(), getZ(), face);
	}

	@Override
	public boolean isBlockIndirectlyPowered() {
		return BlockManager.isBlockIndirectlyPowered(getWorld(), getX(), getY(), getZ());
	}

	@Override
	public boolean isBlockPowered() {
		return BlockManager.isBlockPowered(getWorld(), getX(), getY(), getZ());
	}

	@Override
	public boolean isEmpty() {
		return BlockManager.isEmpty(getWorld(), getX(), getY(), getZ());
	}

	@Override
	public boolean isLiquid() {
		return BlockManager.isLiquid(getWorld(), getX(), getY(), getZ());
	}

	@Override
	public void setBiome(Biome biome) {
		BlockManager.setBiome(getWorld(), getX(), getZ(), biome);
	}

	@Override
	public void setData(byte data) {
		BlockManager.setData(getWorld(), getX(), getY(), getZ(), data);
	}

	@Override
	public void setData(byte data, boolean applyPhysics) {
		BlockManager.setData(getWorld(), getX(), getY(), getZ(), data, applyPhysics);
	}

	@Override
	public void setType(Material type) {
		BlockManager.setType(getWorld(), getX(), getY(), getZ(), type);
	}

	@Override
	public boolean setTypeId(int id) {
		return BlockManager.setTypeId(getWorld(), getX(), getY(), getZ(), id);
	}

	@Override
	public boolean setTypeId(int id, boolean applyPhysics) {
		return BlockManager.setTypeId(getWorld(), getX(), getY(), getZ(), id, applyPhysics);
	}

	@Override
	public boolean setTypeIdAndData(int type, byte data, boolean applyPhysics) {
		return BlockManager.setTypeIdAndData(getWorld(), getX(), getY(), getZ(), type, data, applyPhysics);
	}

}
