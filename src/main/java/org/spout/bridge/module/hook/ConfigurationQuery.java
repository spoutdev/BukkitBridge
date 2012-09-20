package org.spout.bridge.module.hook;

import java.util.HashMap;
import java.util.Map;

/**
 * A ConfigurationQuery is used to get info about the Configuration
 * of various elements within the game. Note that if using "*" for an
 * element, the type parameter <strong>must</strong> be List&lt;Object&gt;
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
 * <li>server.ip</li>
 * <li>server.port</li>
 * 
 * <li>server.default.flight</li>
 * <li>server.default.spawnlimit.animal</li>
 * <li>server.default.spawnlimit.monster</li>
 * <li>server.default.gamemode</li>
 * 
 * <li>server.wgen.genstructures</li>
 * 
 * <li>server.player.max</li>
 * 
 * </ul>
 * 
 * @param <T> The result type of this query.
 * @author Pamelloes
 * @version 1.0
 * @see Hook
 * @see Query
 * @see NodeQuery
 */
public class ConfigurationQuery<T> extends NodeQuery<T> implements Cloneable {
	private static final Map<Thread, ConfigurationQuery<?>> map = new HashMap<Thread, ConfigurationQuery<?>>();
	
	/**
	 * Gets and configures the query for the current thread. Note that this query is reused, so if it needs
	 * to be preserved for later, use the clone method.
	 * 
	 * @param node The Query's node.
	 * @param args The Query's arguments.
	 * @return The current Thread's ConfigurationQuery configured for the specified parameters.
	 */
	public static <U> ConfigurationQuery<U> getInstance(String node, Object ...args) {
		Thread t = Thread.currentThread();
		@SuppressWarnings("unchecked")
		ConfigurationQuery<U> conf = (ConfigurationQuery<U>) map.get(t);//Because generics data isn't stored at runtime,
																		//a ConfigurationQuery<Boolean> can magically become
																		//a ConfigurationQuery<Integer>. :D
		if(conf == null) conf = new ConfigurationQuery<U>(node, args);
		else conf.configure(node, args);
		return conf;
		
	}
	
	/**
	 * Creates a ConfigurationQuery for the given node with the
	 * given arguments.
	 * 
	 * @param node The Query's node.
	 * @param args The Query's arguments.
	 */
	private ConfigurationQuery(String node, Object ...args) {
		super("Configuration", node, args);
	}
	
	@Override
	public ConfigurationQuery<T> clone() throws CloneNotSupportedException {
		return (ConfigurationQuery<T>) super.clone();
	}
}
