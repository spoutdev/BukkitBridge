/*
 * This file is part of BukkitBridge (http://www.spout.org/).
 *
 * BukkitBridge is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BukkitBridge is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.spout.bukkit.block;

import java.util.Collection;
import java.util.List;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import org.spout.bukkit.BridgeWorld;

public class BridgeBlock implements Block {
	private final org.spout.api.geo.cuboid.Block block;
	private final org.spout.api.geo.cuboid.Chunk chunk;

	public BridgeBlock(org.spout.api.geo.cuboid.Chunk chunk, org.spout.api.geo.cuboid.Block block) {
		this.block = block;
		this.chunk = chunk;
	}

	@Override
	public byte getData() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Block getRelative(int i, int i1, int i2) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Block getRelative(BlockFace blockFace) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Block getRelative(BlockFace blockFace, int i) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Material getType() {
		return Material.getMaterial(block.getBlockId());
	}

	@Override
	public int getTypeId() {
		return block.getBlockId();
	}

	@Override
	public byte getLightLevel() {
		return (byte) block.getBlockMaterial().getLightLevel(); //TODO: Light not fully implemented in Spout
	}

	@Override
	public byte getLightFromSky() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public byte getLightFromBlocks() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public World getWorld() {
		return new BridgeWorld(chunk.getWorld());
	}

	@Override
	public int getX() {
		return block.getX();
	}

	@Override
	public int getY() {
		return block.getY();
	}

	@Override
	public int getZ() {
		return block.getZ();
	}

	@Override
	public Location getLocation() {
		return new Location(getWorld(), getX(), getY(), getZ());
	}

	@Override
	public Chunk getChunk() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setData(byte data) {
		setData(data, true);
	}

	@Override
	public void setData(byte data, boolean updatePhysics) {
		chunk.setBlockData(block.getX(), block.getY(), block.getZ(), data, true, chunk.getWorld());
	}

	@Override
	public void setType(Material material) {
		setTypeId(material.getId(), true);
	}

	@Override
	public boolean setTypeId(int i) {
		return setTypeId(i, true);
	}

	@Override
	public boolean setTypeId(int i, boolean physics) {
		return chunk.setBlockId(getX(), getY(), getZ(), (short) i, physics, chunk.getWorld());
	}

	@Override
	public boolean setTypeIdAndData(int i, byte data, boolean physics) {
		return chunk.setBlockIdAndData(getX(), getY(), getZ(), (short) i, data, physics, chunk.getWorld());
	}

	@Override
	public BlockFace getFace(Block block) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public BlockState getState() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Biome getBiome() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setBiome(Biome biome) {

	}

	@Override
	public boolean isBlockPowered() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isBlockIndirectlyPowered() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isBlockFacePowered(BlockFace blockFace) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isBlockFaceIndirectlyPowered(BlockFace blockFace) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public int getBlockPower(BlockFace blockFace) {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public int getBlockPower() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isEmpty() {
		return block.getBlockId() == 0;
	}

	@Override
	public boolean isLiquid() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public double getTemperature() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public double getHumidity() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public PistonMoveReaction getPistonMoveReaction() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean breakNaturally() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean breakNaturally(ItemStack itemStack) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Collection<ItemStack> getDrops() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Collection<ItemStack> getDrops(ItemStack itemStack) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setMetadata(String s, MetadataValue metadataValue) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public List<MetadataValue> getMetadata(String s) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean hasMetadata(String s) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void removeMetadata(String s, Plugin plugin) {
		//TODO: Adjust for usage with Spout!
	}
}
