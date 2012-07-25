package org.spout.bridge.vanilla;

import org.spout.bridge.module.query.Query;
import org.spout.vanilla.configuration.VanillaConfiguration;
import org.spout.vanilla.configuration.WorldConfiguration;
import org.spout.vanilla.data.GameMode;

/**
 * This class is used to handle requests for configuration info.
 */
public class VanillaConfigurationQueryHandler extends VanillaNodeQueryHandler {
	@SuppressWarnings("unused")
	private final VanillaModule module;
	
	public VanillaConfigurationQueryHandler(VanillaModule module) {
		super(module);
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
	
	//server.default.*
	
	public void queryServerDefaultFlight(Query<Boolean> q) {
		q.setResult(false); //TODO Find a way of getting this.
	}
	
	public void queryServerDefaultGamemode(Query<Integer> q) {
		q.setResult((int) GameMode.SURVIVAL.getId()); //TODO Find a way of getting this.
	}
	
	public void queryDefaultSpawnlimitAnimal(Query<Integer> q) {
		q.setResult(0); //TODO Find a way of getting this.
	}
	
}
