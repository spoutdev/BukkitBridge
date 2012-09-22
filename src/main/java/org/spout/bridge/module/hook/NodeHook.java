package org.spout.bridge.module.hook;

/**
 * A NodeHook is a Hook identified by a node. A {@link org.spout.bridge.module.NodeHandler node}
 * is essentially a string with a base id, and then a path. NodeHooks are the standard hook in Bridge.
 * 
 * @author Pamelloes
 * @version 1.0
 * 
 * @see Hook
 * @see Query
 * @see NodeQuery
 * @see NodeHookHandler
 */
public interface NodeHook extends Hook {
	
	/**
	 * Gets the node being requested.
	 * 
	 * @return The Hook's current node.
	 */
	public String getNode();
	
	/**
	 * Gets this Hook's base.
	 * 
	 * @return The Hook's base.
	 */
	public String getBase();
}
