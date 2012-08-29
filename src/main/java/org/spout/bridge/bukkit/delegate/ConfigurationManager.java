package org.spout.bridge.bukkit.delegate;

import org.bukkit.GameMode;
import org.spout.bridge.Bridge;
import org.spout.bridge.bukkit.BridgeServer;
import org.spout.bridge.module.query.ConfigurationQuery;

public class ConfigurationManager {

	public static boolean getAllowEnd(BridgeServer delegator) {
		return Bridge.callQuery(ConfigurationQuery.<Boolean>getInstance("server.end.allow", new Object[0]));
	}

	public static boolean getAllowNether(BridgeServer delegator) {
		return Bridge.callQuery(ConfigurationQuery.<Boolean>getInstance("server.nether.allow", new Object[0]));
	}
	
	public static long getConnectionThrottle(BridgeServer delegator) {
		return Bridge.callQuery(ConfigurationQuery.<Long>getInstance("server.throttle", new Object[0]));
	}

	public static boolean getOnlineMode(BridgeServer delegator) {
		return Bridge.callQuery(ConfigurationQuery.<Boolean>getInstance("server.online", new Object[0]));
	}

	public static String getIp(BridgeServer delegator) {
		return Bridge.callQuery(ConfigurationQuery.<String>getInstance("server.ip", new Object[0]));
	}

	public static int getPort(BridgeServer delegator) {
		return Bridge.callQuery(ConfigurationQuery.<Integer>getInstance("server.port", new Object[0]));
	}

	//server.default.*
	
	public static boolean getAllowFlight(BridgeServer delegator) {
		return Bridge.callQuery(ConfigurationQuery.<Boolean>getInstance("server.default.flight", new Object[0]));
	}

	public static int getAnimalSpawnLimit(BridgeServer delegator) {
		return Bridge.callQuery(ConfigurationQuery.<Integer>getInstance("server.default.spawnlimit.animal", new Object[0]));
	}

	public static int getMonsterSpawnLimit(BridgeServer delegator) {
		return Bridge.callQuery(ConfigurationQuery.<Integer>getInstance("server.default.spawnlimit.monster", new Object[0]));
	}

	public static GameMode getDefaultGameMode(BridgeServer delegator) {
		return GameMode.getByValue(Bridge.callQuery(ConfigurationQuery.<Integer>getInstance("server.default.gamemode", new Object[0])));
	}

	//server.player.*
	
	public static int getMaxPlayers(BridgeServer delegator) {
		return Bridge.callQuery(ConfigurationQuery.<Integer>getInstance("server.player.max", new Object[0]));
	}

	//server.wgen.*
	
	public static boolean getGenerateStructures(BridgeServer delegator) {
		return Bridge.callQuery(ConfigurationQuery.<Boolean>getInstance("server.wgen.genstructures", new Object[0]));
	}
}
