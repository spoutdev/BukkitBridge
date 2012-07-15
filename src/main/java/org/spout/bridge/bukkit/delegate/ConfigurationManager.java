package org.spout.bridge.bukkit.delegate;

import org.spout.bridge.Bridge;
import org.spout.bridge.bukkit.BridgeServer;
import org.spout.bridge.module.query.ServerEndEnabledQuery;
import org.spout.bridge.module.query.ServerNetherEnabledQuery;

public class ConfigurationManager {

	public static boolean getAllowEnd(BridgeServer delegator) {
		return Bridge.callQuery(new ServerEndEnabledQuery());
	}

	public static boolean getAllowNether(BridgeServer delegator) {
		return Bridge.callQuery(new ServerNetherEnabledQuery());
	}

	public static boolean getAllowFlight(BridgeServer delegator) {
		// TODO Auto-generated method stub
		return false;
	}

	public static int getAnimalSpawnLimit(BridgeServer delegator) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static long getConnectionThrottle(BridgeServer delegator) {
		// TODO Auto-generated method stub
		return 0;
	}

}
