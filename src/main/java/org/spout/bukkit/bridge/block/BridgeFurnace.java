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

import org.bukkit.block.Furnace;
import org.bukkit.inventory.FurnaceInventory;

public class BridgeFurnace extends BridgeBlockState implements Furnace {

    @Override
    public short getBurnTime() {
        return 0;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public void setBurnTime(short i) {
        //TODO: Adjust for usage with Spout!
    }

    @Override
    public short getCookTime() {
        return 0;  //TODO: Adjust for usage with Spout!
    }

    @Override
    public void setCookTime(short i) {
        //TODO: Adjust for usage with Spout!
    }

    @Override
    public FurnaceInventory getInventory() {
        return null;  //TODO: Adjust for usage with Spout!
    }
}
