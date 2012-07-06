package org.spout.bridge;

import org.spout.bridge.module.ConversionManager;
import org.spout.bridge.module.HookManager;
import org.spout.bridge.module.ModuleManager;

public class Bridge {
	/**
	 * Starts Bridge. Called by a plugin.
	 */
	public static void start() {
		//Setup managers.
		ConversionManager.init();
		HookManager.init();
		ModuleManager.init();
		
		//Load the modules. This provides conversions and hooks for the respective managers.
		ModuleManager.load();
		//The conversion manager processes the provided converters and determines all the possible conversions.
		ConversionManager.process();
		
		//Enable the modules.
		ModuleManager.start();
	}
	
	/**
	 * Stops the bridge. Called by a plugin.
	 */
	public static void stop() {
		ModuleManager.stop();
	}
}
