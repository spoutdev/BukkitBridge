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
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.Collection;
import java.util.List;

public class BridgeBlock implements Block {

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
    public byte getLightFromSky() {
        return 0;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public byte getLightFromBlocks() {
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
    public void setData(byte b) {
        //TODO: Adjust for usage with Spout!
    }

    @Override
    public void setData(byte data, boolean b) {
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
    public boolean setTypeId(int i, boolean b) {
        return false;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public boolean setTypeIdAndData(int i, byte data, boolean b) {
        return false;  //TODO: Adjust for usage with Spout!
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
        return false;  //TODO: Adjust for usage with Spout!
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
