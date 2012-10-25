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
