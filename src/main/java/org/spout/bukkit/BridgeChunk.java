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
package org.spout.bukkit;

import java.util.ArrayList;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;

import org.spout.api.entity.component.Controller;
import org.spout.api.geo.LoadOption;

import org.spout.bukkit.block.BridgeBlock;
import org.spout.bukkit.entity.BridgeEntity;

import org.spout.vanilla.controller.VanillaActionController;

public class BridgeChunk implements Chunk {
	private org.spout.api.geo.cuboid.Chunk[] handle;

	public BridgeChunk(org.spout.api.geo.cuboid.Chunk[] chunk) {
		this.handle = chunk;
	}

	@Override
	public int getX() {
		return this.handle[0].getX();
	}

	@Override
	public int getZ() {
		return this.handle[0].getZ();
	}

	@Override
	public World getWorld() {
		return new BridgeWorld(this.handle[0].getWorld());
	}

	@Override
	public Block getBlock(int x, int y, int z) {
		return new BridgeBlock(this.handle[y / 16].getBlock(x, y, z));
	}

	@Override
	public ChunkSnapshot getChunkSnapshot() {
		return getChunkSnapshot(true, false, false);
	}

	@Override
	public ChunkSnapshot getChunkSnapshot(boolean includeMaxblocky, boolean includeBiome, boolean includeBiomeTempRain) {
		org.spout.api.geo.cuboid.ChunkSnapshot[] cs = new org.spout.api.geo.cuboid.ChunkSnapshot[handle.length];
		for (int i = 0; i < handle.length; i++) {
			cs[i] = handle[i].getSnapshot(true);
		}
		return new BridgeChunkSnapshot(cs, includeMaxblocky, includeBiome, includeBiomeTempRain);
	}

	@Override
	public Entity[] getEntities() {
		ArrayList<Entity> entities = new ArrayList<Entity>();
		for (org.spout.api.geo.cuboid.Chunk h : handle) {
			for (org.spout.api.entity.Entity e : h.getEntities()) {
				Controller c = e.getController();
				if (c instanceof VanillaActionController) {
					entities.add(new BridgeEntity((VanillaActionController) e.getController()));
				}
			}
		}
		return entities.toArray(new Entity[0]);
	}

	@Override
	public BlockState[] getTileEntities() {
		return new BlockState[0];  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isLoaded() {
		for (org.spout.api.geo.cuboid.Chunk c : handle) {
			if (!c.isLoaded()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean load(boolean generate) {
		boolean success = true;
		for (int i = 0; i < handle.length; i++) {
			if (!handle[i].isLoaded()) {
				try {
					handle[i] = handle[i].getWorld().getChunk(handle[i].getX(), handle[i].getY(), handle[i].getZ(), generate ? LoadOption.LOAD_GEN : LoadOption.LOAD_ONLY);
				} catch (Exception e) {
					success = false;
					continue;
				}
				success &= handle[i].isLoaded();
			}
		}
		return success;
	}

	@Override
	public boolean load() {
		return load(true);
	}

	@Override
	public boolean unload(boolean save, boolean safe) {
		//TODO Cancel unload if it is too close to a player
		// and safe param is true.
		boolean success = true;
		for (int i = 0; i < handle.length; i++) {
			if (!handle[i].isLoaded()) {
				try {
					handle[i].unload(save);
				} catch (Exception e) {
					success = false;
					continue;
				}
				success &= !handle[i].isLoaded();
			}
		}
		return success;
	}

	@Override
	public boolean unload(boolean save) {
		return unload(save, false);
	}

	@Override
	public boolean unload() {
		return unload(true);
	}
}
