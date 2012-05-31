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

import java.util.List;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import org.spout.bukkit.BridgeChunk;
import org.spout.bukkit.BridgeWorld;

public class BridgeBlockState implements BlockState {
	private final BridgeWorld world;
	private final BridgeChunk chunk;
	private final int x;
	private final int y;
	private final int z;
	protected int type;
	protected MaterialData data;
	protected byte light;

	public BridgeBlockState(final Block block) {
		this.world = (BridgeWorld) block.getWorld();
		this.x = block.getX();
		this.y = block.getY();
		this.z = block.getZ();
		this.type = block.getTypeId();
		this.light = block.getLightLevel();
		this.chunk = (BridgeChunk) block.getChunk();

		createData(block.getData());
	}

	private void createData(final byte data) {
		Material mat = getType();
		if (mat == null || mat.getData() == null) {
			this.data = new MaterialData(type, data);
		} else {
			this.data = mat.getNewData(data);
		}
	}

	@Override
	public Block getBlock() {
		return this.world.getBlockAt(x, y, z);
	}

	@Override
	public MaterialData getData() {
		return this.data;
	}

	@Override
	public Material getType() {
		return Material.getMaterial(getTypeId());
	}

	@Override
	public int getTypeId() {
		return type;
	}

	@Override
	public byte getLightLevel() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public World getWorld() {
		return world;
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
	public Location getLocation() {
		return new Location(world, x, y, z);
	}

	@Override
	public Chunk getChunk() {
		return this.chunk;
	}

	@Override
	public void setData(final MaterialData data) {
		Material mat = getType();

		if ((mat == null) || (mat.getData() == null)) {
			this.data = data;
		} else {
			if ((data.getClass() == mat.getData()) || (data.getClass() == MaterialData.class)) {
				this.data = data;
			} else {
				throw new IllegalArgumentException("Provided data is not of type " + mat.getData().getName() + ", found " + data.getClass().getName());
			}
		}
	}

	@Override
	public void setType(final Material type) {
		setTypeId(type.getId());
	}

	@Override
	public boolean setTypeId(int type) {
		if (this.type != type) {
			this.type = type;

			createData((byte) 0);
		}
		return true;
	}

	@Override
	public boolean update() {
		return update(false);
	}

	@Override
	public boolean update(boolean force) {
		Block block = getBlock();

		synchronized (block) {
			if (block.getType() != this.getType()) {
				if (force) {
					block.setTypeId(this.getTypeId());
				} else {
					return false;
				}
			}

			block.setData(getRawData());
			world.notify();
		}

		return true;
	}

	@Override
	public byte getRawData() {
		return data.getData();
	}

	@Override
	public void setRawData(byte b) {
		this.data.setData(b);
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
