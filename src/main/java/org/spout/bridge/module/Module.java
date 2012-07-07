package org.spout.bridge.module;

import java.util.List;

import org.spout.bridge.module.conversion.Converter;
import org.spout.bridge.module.hook.Hook;

/**
 * A module in the bridge.
 */
public interface Module {
	
	/**
	 * Called when the module is loaded. This is called immediately
	 * before getHooks() and getConverters(), so any processing for
	 * them should (probably) be done here.
	 */
	public void onLoad();
	
	/**
	 * Gets a list of the hooks this module uses. Can be null
	 * for no hooks.
	 */
	public List<Hook<?>> getHooks();
	
	/**
	 * Gets a list of converters this module uses. Can contain
	 * BidiConverters. Can be null for no hooks.
	 */
	public List<Converter<?,?>> getConverters();
	
	/**
	 * Called when everything has been set up and the module can initialize
	 * the API. Note that this is called on the main thread and should be
	 * kept as fast as possible so as to allow for the other modules to initialize.
	 * <br />
	 * <br />
	 * Some things that should probably be done here is loading and activating plugins,
	 * registering for events, doing any intial configuration for the API, etc.
	 */
	public void onEnable();
	
	/**
	 * Called when the bridge is being shut down. This should shut down the API.
	 */
	public void onDisable();
}
