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
package org.spout.bridge.bukkit.block;

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

import org.spout.api.component.type.BlockComponent;

import org.spout.bridge.BukkitUtil;

public class BridgeBlockState implements BlockState {
	private BlockComponent handle;
	private Block b;
	private int x, y, z;
	private Chunk chunk;
	private World world;
	private MaterialData data = null;
	private int typeid;
	private byte lightlevel;
	private Location location;

	public BridgeBlockState(Block b) {
		this.handle = BukkitUtil.toBlock(b).getComponent();
		this.b = b;
		this.x = b.getX();
		this.y = b.getY();
		this.z = b.getZ();
		this.chunk = b.getChunk();
		this.world = b.getWorld();
		lightlevel = b.getLightLevel();
		location = b.getLocation();
	}

	public BlockComponent getHandle() {
		return handle;
	}

	@Override
	public Block getBlock() {
		return b;
	}

	@Override
	public Chunk getChunk() {
		return chunk;
	}

	@Override
	public MaterialData getData() {
		return data;
	}

	@Override
	public byte getLightLevel() {
		return lightlevel;
	}

	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public byte getRawData() {
		return data.getData();
	}

	@Override
	public Material getType() {
		return Material.getMaterial(typeid);
	}

	@Override
	public int getTypeId() {
		return typeid;
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
	public void setData(MaterialData data) {
		updateMaterialData(data);
	}

	@Override
	public void setRawData(byte data) {
		updateMaterialData(data);
	}

	@Override
	public void setType(Material type) {
		setTypeId(type.getId());
	}

	@Override
	public boolean setTypeId(int type) {
		this.typeid = type;
		updateMaterialData(getRawData());
		return true;
	}

	@Override
	public boolean update() {
		return update(false);
	}

	private void updateMaterialData(MaterialData data) {
		if (getType() == null) {
			this.data = data;
		} else if (getType().getData() == null) {
			this.data = data;
		} else if (getType().getData().equals(data)) {
			this.data = data;
		} else if (MaterialData.class.equals(data)) {
			this.data = data;
		} else {
			throw new IllegalArgumentException("Specified data is invalid must be an instance of org.bukkit.material.MaterialData or " + getType().getData().getName());
		}
	}

	private void updateMaterialData(byte data) {
		if (getType() == null || getType().getData() == null) {
			this.data = new MaterialData(getTypeId(), data);
		} else {
			this.data = getType().getNewData(data);
		}
	}

	@Override
	public boolean update(boolean force) {
		if (b.getType().equals(getType())) {
			b.setData(getRawData());
		} else if (force) {
			b.setType(getType());
			b.setData(getRawData());
		} else {
			return false;
		}
		return true;
	}

	@Override
	public List<MetadataValue> getMetadata(String metadataKey) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasMetadata(String metadataKey) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
		throw new UnsupportedOperationException();
	}
}
