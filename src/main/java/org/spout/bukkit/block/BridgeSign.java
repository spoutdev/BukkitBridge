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

import org.bukkit.block.Block;
import org.bukkit.block.Sign;

public class BridgeSign extends BridgeBlockState implements Sign {
	
	public BridgeSign(final Block block) {
		super(block);
	}
	@Override
	public String[] getLines() {
		return new String[0];  //TODO: Adjust for usage with Spout!
	}

	@Override
	public String getLine(int i) throws IndexOutOfBoundsException {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setLine(int i, String s) throws IndexOutOfBoundsException {
		//TODO: Adjust for usage with Spout!
	}
}
