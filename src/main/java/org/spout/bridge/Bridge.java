package org.spout.bridge;

import org.spout.bridge.module.ModuleManager;
import org.spout.bridge.module.hook.Hook;
import org.spout.bridge.module.hook.Query;

/**
 * Static utility class used for various high-level Bridge functions.
 */
public class Bridge {
	/**
	 * Starts Bridge. Called by a plugin.
	 */
	public static void start() {
		//Setup managers.
		ModuleManager.init();
		
		//Load the modules. This provides conversions and hooks for the respective managers.
		ModuleManager.load();
		
		//Enable the modules.
		ModuleManager.start();
	}
	
	/**
	 * Stops the bridge. Called by a plugin.
	 */
	public static void stop() {
		ModuleManager.stop();
	}
	
	/**
	 * Executes the given query.
	 */
	public static <T> T callQuery(Query<T> q) {
		ModuleManager.getMainModule().processQuery(q);
		return q.getResult();
	}
	
	/**
	 * Executes the given hook.
	 */
	public static void callHook(Hook h) {
		if(h instanceof Query) callQuery((Query<?>) h);
		else ModuleManager.getMainModule().processHook(h);
	}
}
