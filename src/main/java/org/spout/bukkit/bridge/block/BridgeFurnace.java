package org.spout.bukkit.bridge.block;

import org.bukkit.block.Furnace;
import org.bukkit.inventory.FurnaceInventory;

public class BridgeFurnace extends BridgeBlockState implements Furnace {
    @Override
    public short getBurnTime() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setBurnTime(short i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public short getCookTime() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setCookTime(short i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public FurnaceInventory getInventory() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
