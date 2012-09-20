package org.spout.bridge.module;

import org.spout.bridge.module.hook.Hook;
import org.spout.bridge.module.hook.Query;

/**
 * The MainModule can be queried for data from the native api.
 */
public interface MainModule {
	
	/**
	 * Processes the given Query.
	 */
	public <T> void processQuery(Query<T> query);

	
	/**
	 * Processes the given Hook.
	 */
	public void processHook(Hook h);
}
