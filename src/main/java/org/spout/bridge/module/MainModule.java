package org.spout.bridge.module;

import org.spout.bridge.module.query.Query;

/**
 * The MainModule can be queried for data from the native api.
 */
public interface MainModule {
	
	/**
	 * Processes the given Query.
	 */
	public <T> void processQuery(Query<T> query);
}
