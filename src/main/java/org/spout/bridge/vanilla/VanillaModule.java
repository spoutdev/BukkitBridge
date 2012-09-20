package org.spout.bridge.vanilla;

import org.spout.bridge.module.MainModule;
import org.spout.bridge.module.hook.Hook;
import org.spout.bridge.module.hook.Query;

public class VanillaModule implements MainModule {
	private final VanillaQueryHandler query = new VanillaQueryHandler(this);
	
	public void onLoad() {
		// TODO Auto-generated method stub
		
	}

	public void onEnable() {
		// TODO Auto-generated method stub
		
	}
 
	public void onDisable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void processQuery(Query<T> query) {
		this.query.processQuery(query);
	}

	@Override
	public void processHook(Hook h) {
		// TODO Auto-generated method stub
		
	}

}
