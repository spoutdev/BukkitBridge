package org.spout.bridge.module;

/**
 * A module in the bridge.
 */
public interface Module {
	
	/**
	 * Called when the module is loaded.
	 */
	public void onLoad();
	
	/**
	 * Called when everything has been set up and the module can initialize
	 * the API. Note that this is called on the main thread and should be
	 * kept as fast as possible so as to allow for the other modules to initialize.
	 * <br />
	 * <br />
	 * Some things that should probably be done here is loading and activating plugins,
	 * registering for events, doing any initial configuration for the API, etc.
	 */
	public void onEnable();
	
	/**
	 * Called when the bridge is being shut down. This should shut down the API.
	 */
	public void onDisable();
}
