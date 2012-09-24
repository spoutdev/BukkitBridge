package org.spout.bridge.bukkit.manager;

import org.bukkit.GameMode;
import org.spout.bridge.Bridge;
import org.spout.bridge.module.hook.ConfigurationQuery;

public class ConfigurationManager {

	public static boolean getAllowEnd() {
		return Bridge.callQuery(ConfigurationQuery.<Boolean>getInstance("server.end.allow", new Object[0]));
	}

	public static boolean getAllowNether() {
		return Bridge.callQuery(ConfigurationQuery.<Boolean>getInstance("server.nether.allow", new Object[0]));
	}
	
	public static long getConnectionThrottle() {
		return Bridge.callQuery(ConfigurationQuery.<Long>getInstance("server.throttle", new Object[0]));
	}

	public static boolean getOnlineMode() {
		return Bridge.callQuery(ConfigurationQuery.<Boolean>getInstance("server.online", new Object[0]));
	}

	public static String getIp() {
		return Bridge.callQuery(ConfigurationQuery.<String>getInstance("server.ip", new Object[0]));
	}

	public static int getPort() {
		return Bridge.callQuery(ConfigurationQuery.<Integer>getInstance("server.port", new Object[0]));
	}

	//server.default.*
	
	public static boolean getAllowFlight() {
		return Bridge.callQuery(ConfigurationQuery.<Boolean>getInstance("server.default.flight", new Object[0]));
	}

	public static int getAnimalSpawnLimit() {
		return Bridge.callQuery(ConfigurationQuery.<Integer>getInstance("server.default.spawnlimit.animal", new Object[0]));
	}

	public static int getMonsterSpawnLimit() {
		return Bridge.callQuery(ConfigurationQuery.<Integer>getInstance("server.default.spawnlimit.monster", new Object[0]));
	}

	public static GameMode getDefaultGameMode() {
		return GameMode.getByValue(Bridge.callQuery(ConfigurationQuery.<Integer>getInstance("server.default.gamemode", new Object[0])));
	}

	//server.player.*
	
	public static int getMaxPlayers() {
		return Bridge.callQuery(ConfigurationQuery.<Integer>getInstance("server.player.max", new Object[0]));
	}

	//server.wgen.*
	
	public static boolean getGenerateStructures() {
		return Bridge.callQuery(ConfigurationQuery.<Boolean>getInstance("server.wgen.genstructures", new Object[0]));
	}
}
