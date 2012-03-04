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
package org.spout.bukkit;

import java.util.Map;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class BridgeOfflinePlayer implements OfflinePlayer{
	@Override
	public boolean isOnline() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public String getName() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isBanned() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setBanned(boolean b) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isWhitelisted() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setWhitelisted(boolean b) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public Player getPlayer() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public long getFirstPlayed() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public long getLastPlayed() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean hasPlayedBefore() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Location getBedSpawnLocation() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Map<String, Object> serialize() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isOp() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setOp(boolean b) {
		//TODO: Adjust for usage with Spout!
	}
}
