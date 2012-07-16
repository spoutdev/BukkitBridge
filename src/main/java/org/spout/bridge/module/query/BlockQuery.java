package org.spout.bridge.module.query;

/**
 * A BlokcQuery is used to get info about blocks within the server.
 * Note that if using "*" for an element, the type parameter
 * <strong>must</strong> be List&lt;Object&gt;
 * <br />
 * <br />
 * The configuration data requested is determined by the specified node
 * which is set up in a hierarchy, each level separated by a period similar
 * to how a YAML node is identified. If there is a star within the name, an array
 * of all matching results is returned. The current list of configuration options
 * is as follows:
 * <ul>
 * 
 * <li>server.nether.allow</li>
 * <li>server.end.allow</li>
 * <li>server.online</li>
 * <li>server.throttle</li>
 * 
 * <li>server.default.flight</li>
 * <li>server.default.spawnlimit.animal</li>
 * <li>server.default.gamemode</li>
 * 
 * </ul>
 * 
 * @param <T> The result type of this query.
 */
public class BlockQuery<T> extends Query<T> {
	private final String node;
	
	/**
	 * Creates a BlockQuery for the given node with the
	 * given arguments.
	 */
	public BlockQuery(String node, Object ...args) {
		super("Block: " + node, args);
		this.node = node;
	}
	
	/**
	 * Gets the node being requested.
	 */
	public String getNode() {
		return node;
	}

}
