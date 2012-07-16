package org.spout.bridge.bukkit.delegate;

import org.bukkit.GameMode;
import org.spout.bridge.Bridge;
import org.spout.bridge.bukkit.BridgeServer;
import org.spout.bridge.module.query.ConfigurationQuery;

public class ConfigurationManager {

	public static boolean getAllowEnd(BridgeServer delegator) {
		return Bridge.callQuery(new ConfigurationQuery<Boolean>("server.end.allow", new Object[0]));
	}

	public static boolean getAllowNether(BridgeServer delegator) {
		return Bridge.callQuery(new ConfigurationQuery<Boolean>("server.nether.allow", new Object[0]));
	}

	public static boolean getAllowFlight(BridgeServer delegator) {
		return Bridge.callQuery(new ConfigurationQuery<Boolean>("server.default.flight", new Object[0]));
	}

	public static int getAnimalSpawnLimit(BridgeServer delegator) {
		return Bridge.callQuery(new ConfigurationQuery<Integer>("server.default.spawnlimit.animal", new Object[0]));
	}

	public static GameMode getDefaultGameMode(BridgeServer delegator) {
		return GameMode.getByValue(Bridge.callQuery(new ConfigurationQuery<Integer>("server.default.gamemode", new Object[0])));
	}


	public static long getConnectionThrottle(BridgeServer delegator) {
		return Bridge.callQuery(new ConfigurationQuery<Long>("server.throttle", new Object[0]));
	}

	public static boolean getOnlineMode(BridgeServer delegator) {
		return Bridge.callQuery(new ConfigurationQuery<Boolean>("server.online", new Object[0]));
	}
}
