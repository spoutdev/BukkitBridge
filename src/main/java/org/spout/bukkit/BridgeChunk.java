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
package org.spout.bukkit;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.spout.bukkit.block.BridgeBlock;

public class BridgeChunk implements Chunk {
	private org.spout.api.geo.cuboid.Chunk handle;
	
	public BridgeChunk(org.spout.api.geo.cuboid.Chunk chunk) {
		this.handle = chunk;
	}
	
	@Override
	public int getX() {
		return this.handle.getX();
	}

	@Override
	public int getZ() {
		return this.handle.getZ();
	}

	@Override
	public World getWorld() {
		return new BridgeWorld(this.handle.getWorld());
	}

	@Override
	public Block getBlock(int x, int y, int z) {
		return new BridgeBlock(this.handle.getWorld().getChunk(x, y, z), this.handle.getWorld().getBlock(x, y, z));
	}

	@Override
	public ChunkSnapshot getChunkSnapshot() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public ChunkSnapshot getChunkSnapshot(boolean b, boolean b1, boolean b2) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Entity[] getEntities() {
		return new Entity[0];  //TODO: Adjust for usage with Spout!
	}

	@Override
	public BlockState[] getTileEntities() {
		return new BlockState[0];  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isLoaded() {
		return handle.isLoaded();
	}

	@Override
	public boolean load(boolean b) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean load() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean unload(boolean save, boolean safe) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean unload(boolean b) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean unload() {
		return false;  //TODO: Adjust for usage with Spout!
	}
}
