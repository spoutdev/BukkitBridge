package org.spout.bukkit.bridge.block;

import org.bukkit.Material;
import org.bukkit.block.Jukebox;

public class BridgeJukebox extends BridgeBlockState implements Jukebox {
    @Override
    public Material getPlaying() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setPlaying(Material material) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isPlaying() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean eject() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
