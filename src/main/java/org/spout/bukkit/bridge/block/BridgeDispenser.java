package org.spout.bukkit.bridge.block;

import org.bukkit.block.Dispenser;
import org.bukkit.inventory.Inventory;

public class BridgeDispenser extends BridgeBlockState implements Dispenser {
    @Override
    public boolean dispense() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Inventory getInventory() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
