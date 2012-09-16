package org.spout.bridge;

import org.spout.bridge.module.ModuleManager;
import org.spout.bridge.module.hook.HookManager;
import org.spout.bridge.module.query.Query;

public class Bridge {
	/**
	 * Starts Bridge. Called by a plugin.
	 */
	public static void start() {
		//Setup managers.
		HookManager.init();
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
	public static void callHook(String name, Object parameter) {
		HookManager.callHook(name, parameter);
	}
}
