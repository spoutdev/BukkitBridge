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

package org.spout.bukkit.bridge.block;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class BridgeBlockState implements BlockState {

    @Override
    public Block getBlock() {
        return null;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public MaterialData getData() {
        return null;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public Material getType() {
        return null;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public int getTypeId() {
        return 0;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public byte getLightLevel() {
        return 0;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public World getWorld() {
        return null;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public int getX() {
        return 0;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public int getY() {
        return 0;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public int getZ() {
        return 0;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public Location getLocation() {
        return null;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public Chunk getChunk() {
        return null;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public void setData(MaterialData materialData) {
        //TODO: Adjust for usage with Spout!
    }

    @Override
    public void setType(Material material) {
        //TODO: Adjust for usage with Spout!
    }

    @Override
    public boolean setTypeId(int i) {
        return false;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public boolean update() {
        return false;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public boolean update(boolean b) {
        return false;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public byte getRawData() {
        return 0;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public void setRawData(byte b) {
        //TODO: Adjust for usage with Spout!
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
