/*
 * This file is part of BukkitBridge.
 *
 * Copyright (c) 2012, VanillaDev <http://www.spout.org/>
 * BukkitBridge is licensed under the GNU General Public License.
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

import java.util.ArrayList;
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

import org.spout.api.material.BlockMaterial;
import org.spout.api.material.range.EffectRange;

import org.spout.bukkit.BridgeWorld;
import org.spout.bukkit.util.BridgeUtil;

import org.spout.vanilla.material.VanillaBlockMaterial;
import org.spout.vanilla.material.block.Liquid;
import org.spout.vanilla.util.RedstonePowerMode;

@SuppressWarnings("deprecation")
public class BridgeBlock implements Block {
	private final org.spout.api.geo.cuboid.Block block;

	public BridgeBlock(org.spout.api.geo.cuboid.Block block) {
		this.block = block;
	}

	@Override
	public byte getData() {
		return (byte) this.block.getData();
	}

	@Override
	public Block getRelative(int modX, int modY, int modZ) {
		return new BridgeBlock(this.block.translate(modX, modY, modZ));
	}

	@Override
	public Block getRelative(BlockFace blockFace) {
		return getRelative(blockFace, 1);
	}

	@Override
	public Block getRelative(BlockFace blockFace, int distance) {
		return getRelative(blockFace.getModX() * distance, blockFace.getModY() * distance, blockFace.getModZ() * distance);
	}

	@Override
	public Material getType() {
		return Material.getMaterial(this.getTypeId());
	}

	@Override
	public int getTypeId() {
		return block.getMaterial().getId();
	}

	@Override
	public byte getLightLevel() {
		return block.getMaterial().getLightLevel(block.getData());
	}

	@Override
	public byte getLightFromSky() {
		return this.block.getSkyLight();
	}

	@Override
	public byte getLightFromBlocks() {
		return this.block.getLight();
	}

	@Override
	public World getWorld() {
		return new BridgeWorld(block.getWorld());
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
		return getWorld().getChunkAt(this);
	}

	@Override
	public void setData(byte data) {
		setData(data, true);
	}

	@Override
	public void setData(byte data, boolean updatePhysics) {
		block.setData(data);
		if (updatePhysics) {
			block.queueUpdate(EffectRange.THIS_AND_NEIGHBORS);
		}
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
		block.setMaterial(BlockMaterial.get((short) i));
		if (physics) {
			block.queueUpdate(EffectRange.THIS_AND_NEIGHBORS);
		}
		return true;
	}

	@Override
	public boolean setTypeIdAndData(int i, byte data, boolean physics) {
		block.setMaterial(BlockMaterial.get((short) i), data);
		if (physics) {
			block.queueUpdate(EffectRange.THIS_AND_NEIGHBORS);
		}
		return true;
	}

	@Override
	public BlockFace getFace(Block block) {
		BlockFace[] values = BlockFace.values();

		for (BlockFace face : values) {
			if ((this.getX() + face.getModX() == block.getX()) &&
					(this.getY() + face.getModY() == block.getY()) &&
					(this.getZ() + face.getModZ() == block.getZ())
					) {
				return face;
			}
		}

		return null;
	}

	@Override
	public BlockState getState() {
		Material material = getType();

		switch (material) {
			case SIGN:
			case SIGN_POST:
			case WALL_SIGN:
				return new BridgeSign(this, (org.spout.vanilla.controller.block.Sign) block.getController());
			case CHEST:
				return new BridgeChest(this, (org.spout.vanilla.controller.block.Chest) block.getController());
			case BURNING_FURNACE:
			case FURNACE:
				return new BridgeFurnace(this, (org.spout.vanilla.controller.block.Furnace) block.getController());
			case DISPENSER:
				return new BridgeDispenser(this, (org.spout.vanilla.controller.block.Dispenser) block.getController());
			case MOB_SPAWNER:
				return new BridgeCreatureSpawner(this, (org.spout.vanilla.controller.block.MonsterSpawner) block.getController());
			case NOTE_BLOCK:
				return new BridgeNoteBlock(this, (org.spout.vanilla.controller.block.NoteBlock) block.getController());
			case JUKEBOX:
				return new BridgeJukebox(this, (org.spout.vanilla.controller.block.Jukebox) block.getController());
			case BREWING_STAND:
				return new BridgeBrewingStand(this, (org.spout.vanilla.controller.block.BrewingStand) block.getController());
			default:
				return new BridgeBlockState(this);
		}
	}

	@Override
	public Biome getBiome() {
		return BridgeUtil.toBiome(block.getBiomeType());
	}

	@Override
	public void setBiome(Biome biome) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isBlockPowered() {
		BlockMaterial mat = this.block.getSubMaterial();
		if (mat instanceof VanillaBlockMaterial) {
			return ((VanillaBlockMaterial) mat).hasRedstonePower(this.block, RedstonePowerMode.ALLEXCEPTWIRE);
		} else {
			return false;
		}
	}

	@Override
	public boolean isBlockIndirectlyPowered() {
		BlockMaterial mat = this.block.getSubMaterial();
		if (mat instanceof VanillaBlockMaterial) {
			return ((VanillaBlockMaterial) mat).hasRedstonePower(this.block, RedstonePowerMode.ALL);
		} else {
			return false;
		}
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
		return block.getMaterial().getId() == 0;
	}

	@Override
	public boolean isLiquid() {
		return block.getMaterial() instanceof Liquid;
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
		return this.breakNaturally(null);
	}

	@Override
	public boolean breakNaturally(ItemStack itemStack) {
		this.block.getMaterial().onDestroy(this.block);
		return true;
	}

	@Override
	public Collection<ItemStack> getDrops() {
		return this.getDrops(null);
	}

	@Override
	public Collection<ItemStack> getDrops(ItemStack itemStack) {
		ArrayList<ItemStack> bukkitDrops = new ArrayList<ItemStack>();
		if (block.getMaterial() instanceof VanillaBlockMaterial) {
			List<org.spout.api.inventory.ItemStack> drops = ((VanillaBlockMaterial) block.getMaterial()).getDrops(block);

			if (drops == null || drops.isEmpty()) {
				return null;
			}

			for (org.spout.api.inventory.ItemStack item : drops) {
				bukkitDrops.add(BridgeUtil.toItemStack(item));
			}
		}
		return bukkitDrops;
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
