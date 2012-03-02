package org.spout.bukkit.bridge.block;

import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;

public class BridgeChest extends BridgeBlockState implements Chest {
    @Override
    public Inventory getInventory() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
