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
package org.spout.bukkit.block;

import org.bukkit.block.BrewingStand;
import org.bukkit.inventory.BrewerInventory;

public class BridgeBrewingStand extends BridgeBlockState implements BrewingStand{
	@Override
	public int getBrewingTime() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setBrewingTime(int i) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public BrewerInventory getInventory() {
		return null;  //TODO: Adjust for usage with Spout!
	}
}
