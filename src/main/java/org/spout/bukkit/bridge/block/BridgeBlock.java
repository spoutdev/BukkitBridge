package org.spout.bukkit.bridge.block;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.Collection;
import java.util.List;

public class BridgeBlock implements Block {

    @Override
    public byte getData() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Block getRelative(int x, int y, int z) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Block getRelative(BlockFace blockFace) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Block getRelative(BlockFace blockFace, int i) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Material getType() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getTypeId() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public byte getLightLevel() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public byte getLightFromSky() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public byte getLightFromBlocks() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public World getWorld() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getX() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getY() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getZ() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Location getLocation() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Chunk getChunk() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setData(byte data) {
        setData(data, true);
    }

    @Override
    public void setData(byte data, boolean applyPhysics) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setType(Material material) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean setTypeId(int id) {
        return setTypeId(id, true);
    }

    @Override
    public boolean setTypeId(int id, boolean applyPhysics) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean setTypeIdAndData(int id, byte data, boolean applyPhysics) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public BlockFace getFace(Block block) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public BlockState getState() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Biome getBiome() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isBlockPowered() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isBlockIndirectlyPowered() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isBlockFacePowered(BlockFace blockFace) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isBlockFaceIndirectlyPowered(BlockFace blockFace) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getBlockPower(BlockFace blockFace) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getBlockPower() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isEmpty() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isLiquid() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public double getTemperature() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public double getHumidity() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PistonMoveReaction getPistonMoveReaction() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean breakNaturally() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean breakNaturally(ItemStack itemStack) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<ItemStack> getDrops() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<ItemStack> getDrops(ItemStack itemStack) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setMetadata(String s, MetadataValue metadataValue) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<MetadataValue> getMetadata(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean hasMetadata(String s) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeMetadata(String s, Plugin plugin) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
