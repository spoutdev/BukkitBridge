package org.spout.bridge.vanilla;

import org.spout.api.Server;
import org.spout.api.Spout;
import org.spout.bridge.module.hook.NodeQueryHandler;
import org.spout.bridge.module.hook.Query;
import org.spout.vanilla.configuration.VanillaConfiguration;
import org.spout.vanilla.configuration.WorldConfiguration;
import org.spout.vanilla.data.GameMode;

/**
 * This class is used to handle requests for configuration info.
 */
public class VanillaConfigurationQueryHandler extends NodeQueryHandler {
	@SuppressWarnings("unused")
	private final VanillaModule module;
	
	public VanillaConfigurationQueryHandler(VanillaModule module) {
		this.module = module;
	}
	
//////////////////////////////////////////////////
//			  QUERY IMPLEMENTATIONS				//
//////////////////////////////////////////////////
	
	public boolean queryServerAllowEnd(Query<Boolean> q) {
		return WorldConfiguration.END.LOAD.getBoolean();
	}
	
	public boolean queryServerAllowNether(Query<Boolean> q) {
		return WorldConfiguration.NETHER.LOAD.getBoolean();
	}
	
	public boolean queryServerOnline(Query<Boolean> q) {
		return VanillaConfiguration.ONLINE_MODE.getBoolean();
	}
	
	public long queryServerThrottle(Query<Long> q) {
		return 0l; //TODO Find a way of getting this.
	}
	
	public String queryServerIp(Query<String> q) {
		return ((Server) Spout.getEngine()).getBoundAddresses().get(0).getAddress().toString(); //TODO Figure out a better method here.
	}
	
	public int queryServerPort(Query<Integer> q) {
		return 0; //TODO Find a way of getting this.
	}
	
	//server.default.*
	
	public boolean queryServerDefaultFlight(Query<Boolean> q) {
		return false; //TODO Find a way of getting this.
	}
	
	public int queryServerDefaultGamemode(Query<Integer> q) {
		return (int) GameMode.SURVIVAL.getId(); //TODO Find a way of getting this.
	}
	
	public int queryServerDefaultSpawnlimitAnimal(Query<Integer> q) {
		return 0; //TODO Find a way of getting this.
	}
	
	public int queryServerDefaultSpawnlimitMonster(Query<Integer> q) {
		return 0; //TODO Find a way of getting this.
	}
	
	//server.wgen.*
	
	public boolean queryServerWgenGenstructures(Query<Boolean> q) {
		return false; //TODO Find a way of getting this.
	}
	
	//server.player.*
	
	public int queryServerPlayerMax(Query<Integer> q) {
		return ((Server) Spout.getEngine()).getMaxPlayers();
	}
}
