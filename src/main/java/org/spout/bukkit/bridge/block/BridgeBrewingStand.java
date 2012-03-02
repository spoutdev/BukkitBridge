package org.spout.bukkit.bridge.block;

import org.bukkit.block.BrewingStand;
import org.bukkit.inventory.BrewerInventory;

public class BridgeBrewingStand extends BridgeBlockState implements BrewingStand{
    @Override
    public int getBrewingTime() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setBrewingTime(int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public BrewerInventory getInventory() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
