package org.spout.bridge.module.hook;

import java.util.HashMap;
import java.util.Map;

/**
 * A BlockQuery is used to get info about blocks within the server.
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
 * <li></li>
 * 
 * </ul>
 * 
 * @param <T> The result type of this query.
 * @author Pamelloes
 * @version 1.0
 * @see Hook
 * @see NodeHook
 * @see Query
 * @see NodeQuery
 */
public class BlockQuery<T> extends GenericNodeQuery<T> {
	private static final Map<Thread, BlockQuery<?>> map = new HashMap<Thread, BlockQuery<?>>();
	
	/**
	 * Gets and configures the query for the current thread. Note that this query is reused, so if it needs
	 * to be preserved for later, use the clone method.
	 * 
	 * @param node The Query's node.
	 * @param args The Query's arguments.
	 * @return The current Thread's BlockQuery configured for the specified parameters.
	 */
	public static <U> BlockQuery<U> getInstance(String node, Object ...args) {
		Thread t = Thread.currentThread();
		@SuppressWarnings("unchecked")
		BlockQuery<U> conf = (BlockQuery<U>) map.get(t);//Because generics data isn't stored at runtime,
																		//a ConfigurationQuery<Boolean> can magically become
																		//a ConfigurationQuery<Integer>. :D
		if(conf == null) conf = new BlockQuery<U>(node, args);
		else conf.configure(node, args);
		return conf;
		
	}
	
	/**
	 * Creates a BlockQuery for the given node with the
	 * given arguments.
	 * 
	 * @param node The Query's node.
	 * @param args The Query's arguments.
	 */
	private BlockQuery(String node, Object ...args) {
		super("Block", node, args);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public BlockQuery<T> clone() throws CloneNotSupportedException {
		return (BlockQuery<T>) super.clone();
	}
}
