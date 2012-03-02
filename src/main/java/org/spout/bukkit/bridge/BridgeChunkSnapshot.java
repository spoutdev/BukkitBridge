package org.spout.bukkit.bridge;

import org.bukkit.ChunkSnapshot;
import org.bukkit.block.Biome;

public class BridgeChunkSnapshot implements ChunkSnapshot {

    @Override
    public int getX() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getZ() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getWorldName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getBlockTypeId(int i, int i1, int i2) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getBlockData(int i, int i1, int i2) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getBlockSkyLight(int i, int i1, int i2) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getBlockEmittedLight(int i, int i1, int i2) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getHighestBlockYAt(int i, int i1) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Biome getBiome(int i, int i1) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public double getRawBiomeTemperature(int i, int i1) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public double getRawBiomeRainfall(int i, int i1) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getCaptureFullTime() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isSectionEmpty(int i) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
