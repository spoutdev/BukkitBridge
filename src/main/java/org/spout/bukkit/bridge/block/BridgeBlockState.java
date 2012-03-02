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

public class BridgeBlockState implements BlockState{

    @Override
    public Block getBlock() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MaterialData getData() {
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
    public void setData(MaterialData materialData) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setType(Material material) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean setTypeId(int i) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean update() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean update(boolean b) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public byte getRawData() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setRawData(byte b) {
        //To change body of implemented methods use File | Settings | File Templates.
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
