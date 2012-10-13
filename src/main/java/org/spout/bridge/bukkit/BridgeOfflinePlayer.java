package org.spout.bridge.bukkit;

import java.util.Map;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Player;

public class BridgeOfflinePlayer implements OfflinePlayer, ConfigurationSerializable {
	@Override
	public boolean isOnline() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public String getName() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isBanned() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setBanned(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isWhitelisted() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setWhitelisted(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Player getPlayer() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public long getFirstPlayed() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public long getLastPlayed() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean hasPlayedBefore() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Location getBedSpawnLocation() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Map<String, Object> serialize() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isOp() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setOp(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
