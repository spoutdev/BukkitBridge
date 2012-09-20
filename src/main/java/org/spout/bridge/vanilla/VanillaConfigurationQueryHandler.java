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
	
	public void queryServerAllowEnd(Query<Boolean> q) {
		q.setResult(WorldConfiguration.END.LOAD.getBoolean());
	}
	
	public void queryServerAllowNether(Query<Boolean> q) {
		q.setResult(WorldConfiguration.NETHER.LOAD.getBoolean());
	}
	
	public void queryServerOnline(Query<Boolean> q) {
		q.setResult(VanillaConfiguration.ONLINE_MODE.getBoolean());
	}
	
	public void queryServerThrottle(Query<Long> q) {
		q.setResult(0l); //TODO Find a way of getting this.
	}
	
	public void queryServerIp(Query<String> q) {
		q.setResult(((Server) Spout.getEngine()).getBoundAddresses().get(0).getAddress().toString()); //TODO Figure out a better method here.
	}
	
	public void queryServerPort(Query<Integer> q) {
		q.setResult(0); //TODO Find a way of getting this.
	}
	
	//server.default.*
	
	public void queryServerDefaultFlight(Query<Boolean> q) {
		q.setResult(false); //TODO Find a way of getting this.
	}
	
	public void queryServerDefaultGamemode(Query<Integer> q) {
		q.setResult((int) GameMode.SURVIVAL.getId()); //TODO Find a way of getting this.
	}
	
	public void queryServerDefaultSpawnlimitAnimal(Query<Integer> q) {
		q.setResult(0); //TODO Find a way of getting this.
	}
	
	public void queryServerDefaultSpawnlimitMonster(Query<Integer> q) {
		q.setResult(0); //TODO Find a way of getting this.
	}
	
	//server.wgen.*
	
	public void queryServerWgenGenstructures(Query<Boolean> q) {
		q.setResult(false); //TODO Find a way of getting this.
	}
	
	//server.player.*
	
	public void queryServerPlayerMax(Query<Integer> q) {
		q.setResult(((Server) Spout.getEngine()).getMaxPlayers());
	}
}
