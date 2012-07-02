package org.spout.bukkitbridge.bukkit;

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
		return getChunk().getMetadata(getX(), getY(), getZ(), key);
	}

	@Override
	public boolean hasMetadata(String key) {
		return getChunk().hasMetadata(getX(), getY(), getZ(), key);
	}

	@Override
	public void removeMetadata(String key, Plugin owner) {
		getChunk().removeMetadata(getX(), getY(), getZ(), key, owner);
	}

	@Override
	public void setMetadata(String key, MetadataValue val) {
		getChunk().setMetadata(getX(), getY(), getZ(), key, val);
	}

	@Override
	public boolean breakNaturally() {
		return getChunk().breakNaturally(getX(), getY(), getZ());
	}

	@Override
	public boolean breakNaturally(ItemStack tool) {
		return getChunk().breakNaturally(getX(), getY(), getZ(), tool);
	}

	@Override
	public Biome getBiome() {
		return getChunk().getBiome(getX(), getZ());
	}

	@Override
	public int getBlockPower() {
		return getChunk().getBlockPower(getX(), getY(), getZ());
	}

	@Override
	public int getBlockPower(BlockFace face) {
		return getChunk().getBlockPower(getX(), getY(), getZ(), face);
	}

	@Override
	public BridgeChunk getChunk() {
		return chunk;
	}

	@Override
	public byte getData() {
		return getChunk().getData(getX(), getY(), getZ());
	}

	@Override
	public Collection<ItemStack> getDrops() {
		return getChunk().getDrops(getX(), getY(), getZ());
	}

	@Override
	public Collection<ItemStack> getDrops(ItemStack tool) {
		return getChunk().getDrops(getX(), getY(), getZ(), tool);
	}

	@Override
	public BlockFace getFace(Block other) {
		return getChunk().getFace(getX(), getY(), getZ(), other.getX(), other.getY(), other.getZ());
	}

	@Override
	public double getHumidity() {
		return getChunk().getHumidity(getX(), getZ());
	}

	@Override
	public byte getLightFromBlocks() {
		return getChunk().getLightFromBlocks(getX(), getY(), getZ());
	}

	@Override
	public byte getLightFromSky() {
		return getChunk().getLightFromSky(getX(), getY(), getZ());
	}

	@Override
	public byte getLightLevel() {
		return getChunk().getLightLevel(getX(), getY(), getZ());
	}

	@Override
	public Location getLocation() {
		return getChunk().getLocation(getX(), getY(), getZ());
	}

	@Override
	public PistonMoveReaction getPistonMoveReaction() {
		return getChunk().getPistonMoveReaction(getX(), getY(), getZ());
	}

	@Override
	public Block getRelative(BlockFace face) {
		return getChunk().getRelative(getX(), getY(), getZ(), face);
	}

	@Override
	public Block getRelative(BlockFace face, int distance) {
		return getChunk().getRelative(getX(), getY(), getZ(), face, distance);
	}

	@Override
	public Block getRelative(int modX, int modY, int modZ) {
		return getChunk().getRelative(getX(), getY(), getZ(), modX, modY, modZ);
	}

	@Override
	public BlockState getState() {
		return getChunk().getState(getX(), getY(), getZ());
	}

	@Override
	public double getTemperature() {
		return getChunk().getTemperature(getX(), getZ());
	}

	@Override
	public Material getType() {
		return getChunk().getType(getX(), getY(), getZ());
	}

	@Override
	public int getTypeId() {
		return getChunk().getTypeId(getX(), getY(), getZ());
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
		return getChunk().isBlockFaceIndirectlyPowered(getX(), getY(), getZ(), face);
	}

	@Override
	public boolean isBlockFacePowered(BlockFace face) {
		return getChunk().isBlockFacePowered(getX(), getY(), getZ(), face);
	}

	@Override
	public boolean isBlockIndirectlyPowered() {
		return getChunk().isBlockIndirectlyPowered(getX(), getY(), getZ());
	}

	@Override
	public boolean isBlockPowered() {
		return getChunk().isBlockPowered(getX(), getY(), getZ());
	}

	@Override
	public boolean isEmpty() {
		return getChunk().isEmpty(getX(), getY(), getZ());
	}

	@Override
	public boolean isLiquid() {
		return getChunk().isLiquid(getX(), getY(), getZ());
	}

	@Override
	public void setBiome(Biome biome) {
		getChunk().setBiome(getX(), getZ(), biome);
	}

	@Override
	public void setData(byte data) {
		getChunk().setData(getX(), getY(), getZ(), data);
	}

	@Override
	public void setData(byte data, boolean applyPhysics) {
		getChunk().setData(getX(), getY(), getZ(), data, applyPhysics);
	}

	@Override
	public void setType(Material type) {
		getChunk().setType(getX(), getY(), getZ(), type);
	}

	@Override
	public boolean setTypeId(int id) {
		return getChunk().setTypeId(getX(), getY(), getZ(), id);
	}

	@Override
	public boolean setTypeId(int id, boolean applyPhysics) {
		return getChunk().setTypeId(getX(), getY(), getZ(), id, applyPhysics);
	}

	@Override
	public boolean setTypeIdAndData(int type, byte data, boolean applyPhysics) {
		return getChunk().setTypeIdAndData(getX(), getY(), getZ(), type, data, applyPhysics);
	}

}
