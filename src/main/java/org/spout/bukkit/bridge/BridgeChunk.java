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

package org.spout.bukkit.bridge;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;

public class BridgeChunk implements Chunk {

    @Override
    public int getX() {
        return 0;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public int getZ() {
        return 0;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public World getWorld() {
        return null;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public Block getBlock(int i, int i1, int i2) {
        return null;  //TODO: Adjust for usage with Spout!
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
        return false;  //TODO: Adjust for usage with Spout!
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
    public boolean unload(boolean b, boolean b1) {
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
