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
import org.spout.api.material.BlockMaterial;
import org.spout.bridge.VanillaBridgePlugin;
import org.spout.bridge.bukkit.BridgeChunk;
import org.spout.bridge.bukkit.BridgeWorld;
import org.spout.vanilla.material.VanillaMaterial;
import org.spout.vanilla.material.VanillaMaterials;
import org.spout.vanilla.material.block.Liquid;
import org.spout.vanilla.util.RedstoneUtil;

/**
 * BridgeBlock is an implementation of Block.
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
	public BridgeChunk getChunk() {
		return chunk;
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
	public List<MetadataValue> getMetadata(String metadataKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasMetadata(String metadataKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean breakNaturally() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean breakNaturally(ItemStack tool) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Biome getBiome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBlockPower() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBlockPower(BlockFace face) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte getData() {
		BlockMaterial bm = getBlockMaterial();
		if (bm instanceof VanillaMaterial) {
			return (byte) ((VanillaMaterial)bm).getMinecraftData(bm.getData());
		}
		return 0;
	}

	@Override
	public Collection<ItemStack> getDrops() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ItemStack> getDrops(ItemStack tool) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlockFace getFace(Block block) {
		for (BlockFace f : BlockFace.values()) {
			if (f.getModX() + x == block.getX()) {
				if (f.getModY() + y == block.getY()) {
					if (f.getModZ() + z == block.getZ()) {
						return f;
					}
				}
			}
		}
		return null;
	}

	@Override
	public double getHumidity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte getLightFromBlocks() {
		return getWorld().getHandle().getBlockSkyLightRaw(x, y, z);
	}

	@Override
	public byte getLightFromSky() {
		return getWorld().getHandle().getBlockSkyLight(x, y, z);
	}

	@Override
	public byte getLightLevel() {
		return getWorld().getHandle().getBlockLight(x, y, z);
	}

	@Override
	public Location getLocation() {
		return new Location(getWorld(), x, y, z);
	}

	@Override
	public PistonMoveReaction getPistonMoveReaction() {
		// TODO Auto-generated method stub
		return PistonMoveReaction.BLOCK;
	}

	@Override
	public Block getRelative(BlockFace face) {
		return getRelative(face, 1);
	}

	@Override
	public Block getRelative(BlockFace face, int distance) {
		return getRelative(face.getModX() * distance, face.getModY() * distance, face.getModZ() * distance);
	}

	@Override
	public Block getRelative(int modX, int modY, int modZ) {
		return getWorld().getBlockAt(x + modX, y + modY, z + modZ);
	}

	@Override
	public BlockState getState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getTemperature() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Material getType() {
		return Material.getMaterial(getTypeId());
	}

	@Override
	public int getTypeId() {
		BlockMaterial bm = getBlockMaterial();
		if (bm instanceof VanillaMaterial) {
			return ((VanillaMaterial)bm).getMinecraftId();
		}
		return 0;
	}

	@Override
	public boolean isBlockFaceIndirectlyPowered(BlockFace face) {
		return getRelative(face).isBlockIndirectlyPowered();
	}

	@Override
	public boolean isBlockFacePowered(BlockFace face) {
		return getRelative(face).isBlockPowered();
	}

	@Override
	public boolean isBlockIndirectlyPowered() {
		return RedstoneUtil.isReceivingPower(getWorld().getHandle().getBlock(x, y, z, VanillaBridgePlugin.getInstance()));
	}

	@Override
	public boolean isBlockPowered() {
		return RedstoneUtil.isEmittingPower(getWorld().getHandle().getBlock(x, y, z, VanillaBridgePlugin.getInstance()));
	}

	@Override
	public boolean isEmpty() {
		return getTypeId() == 0;
	}

	@Override
	public boolean isLiquid() {
		return getBlockMaterial() instanceof Liquid;
	}

	@Override
	public void setBiome(Biome bio) {
		// TODO Auto-generated method stub
		
	}
	
	public BlockMaterial getBlockMaterial() {
		return getWorld().getHandle().getBlockMaterial(x, y, z);
	}

	@Override
	public void setData(byte data) {
		setData(data, true);
	}

	@Override
	public void setData(byte data, boolean applyPhysics) {
		getWorld().getHandle().setBlockData(x, y, z, data, VanillaBridgePlugin.getInstance());
	}

	@Override
	public void setType(Material type) {
		setTypeId(type.getId());
	}

	@Override
	public boolean setTypeId(int type) {
		return setTypeId(type, true);
	}

	@Override
	public boolean setTypeId(int type, boolean applyPhysics) {
		return setTypeIdAndData(type, (byte) 0, applyPhysics);
	}

	@Override
	public boolean setTypeIdAndData(int type, byte data, boolean applyPhysics) {
		org.spout.api.material.Material mat = VanillaMaterials.getMaterial((short) type, data);
		if (mat instanceof BlockMaterial) {
			getWorld().getHandle().setBlockMaterial(x, y, z, (BlockMaterial)mat, data, VanillaBridgePlugin.getInstance());
			return true;
		}
		return false;
	}
}
