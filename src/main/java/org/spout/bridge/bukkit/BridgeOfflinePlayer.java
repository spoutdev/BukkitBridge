/*
 * This file is part of BukkitBridge.
 *
 * Copyright (c) 2012, VanillaDev <http://www.spout.org/>
 * BukkitBridge is licensed under the GNU General Public License.
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
package org.spout.bridge.bukkit;

import java.util.Map;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Player;

public class BridgeOfflinePlayer implements OfflinePlayer, ConfigurationSerializable {

	@Override
	public boolean isOp() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOp(boolean op) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<String, Object> serialize() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Location getBedSpawnLocation() {
		throw new UnsupportedOperationException();
	}

	@Override
	public long getFirstPlayed() {
		throw new UnsupportedOperationException();
	}

	@Override
	public long getLastPlayed() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Player getPlayer() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasPlayedBefore() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isBanned() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isOnline() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isWhitelisted() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBanned(boolean banned) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setWhitelisted(boolean whitelisted) {
		throw new UnsupportedOperationException();
	}

}
