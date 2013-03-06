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

import org.spout.api.util.access.BanType;

import org.spout.vanilla.data.configuration.VanillaConfiguration;

public class BridgeOfflinePlayer implements OfflinePlayer, ConfigurationSerializable {
	private final String name;
	private final org.spout.api.Server server;

	public BridgeOfflinePlayer(String name, org.spout.api.Server server) {
		this.name = name;
		this.server = server;
	}

	@Override
	public boolean isOp() {
		return VanillaConfiguration.OPS.isOp(this.getName());
	}

	@Override
	public void setOp(boolean op) {
		VanillaConfiguration.OPS.setOp(this.getName(), op);
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
		return name;
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
		return server.getAccessManager().isBanned(BanType.PLAYER, getName());
	}

	@Override
	public boolean isOnline() {
		return server.getPlayer(getName(), true) != null;
	}

	@Override
	public boolean isWhitelisted() {
		return server.getAccessManager().isWhitelisted(getName());
	}

	@Override
	public void setBanned(boolean banned) {
		if (banned) {
			server.getAccessManager().ban(BanType.PLAYER, getName());
		} else {
			server.getAccessManager().unban(BanType.PLAYER, getName());
		}
	}

	@Override
	public void setWhitelisted(boolean whitelisted) {
		if (whitelisted) {
			server.getAccessManager().whitelist(getName());
		} else {
			server.getAccessManager().unwhitelist(getName());
		}
	}
}
