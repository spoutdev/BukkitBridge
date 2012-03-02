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
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getZ() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public World getWorld() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Block getBlock(int x, int y, int z) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ChunkSnapshot getChunkSnapshot() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ChunkSnapshot getChunkSnapshot(boolean b, boolean b1, boolean b2) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Entity[] getEntities() {
        return new Entity[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public BlockState[] getTileEntities() {
        return new BlockState[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isLoaded() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean load(boolean b) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean load() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean unload(boolean b, boolean b1) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean unload(boolean b) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean unload() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
