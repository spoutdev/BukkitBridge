package org.spout.bridge.module;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The NodeHandler class will process the current instance's methods for ones that
 * match the node format. The subclass, can then use the processNode() method to
 * find a list of methods that match the given node.
 * <br />
 * <br />
 * A node is a period-separated list used to denote a hierarchical relationship in this
 * case. In general it matches the format used to identify a Java class, for instance:
 * "this.is.a.node" is a node where the highest level segment is "this" and the subsequent
 * segments are of lesser significance as they specify more specific parts. Within Bridge,
 * nodes are used to identify Hooks and Queries. For instance, a Query for the server's
 * default max animal spawn-limit could be expressed as "server.default.spawnlimit.animal".
 * In this case, the most important node is "server" indicating that this node is about
 * the server itself. Some other typical high-level nodes are "world" "block" and "entity".
 * The second part of the node is "default" indicating that the node is talking about
 * a default server value. After that, the "spawnlimit" node is found indicating that
 * the value being searched for. Finally, the last part of the node is "animal" indicating
 * it is the animal spawn limit the node is identifying, not the monster spawn limit. It is
 * important to note that <strong>nodes are not case sensitive</strong>.
 * <br />
 * <br />
 * The NodeHandler classes recognizes a method as a "node method" if the methods name starts
 * with the prefix given in the constructor, followed by the different parts of the node each
 * capitalized. For instance, if the prefix is "query", then the method "queryServerDefaultSpawnlimitAnimal"
 * would be mapped to the node "server.default.spawnlimit.animal". Then, if an object was to
 * invoke <em>processNode("server.default.spawnlimit.animal")</em>, that method would be among
 * the list returned.  It is important to note that <strong>methods must be public</strong>.
 * <br />
 * <br />
 * It is also important to realize that the NodeHandler class calculates the list of methods
 * on a per-instance basis. This is beneficial because this means that you can subclass
 * NodeHandler and add a "node-method" and it will pick it up, however this also means
 * that you should try to avoid instantiating NodeHandlers whenever possible and try to re-use
 * instances instead. It is also important to note that the behavior under the event that
 * a method is overwritten in a subclass, that the way NodeHandler will treat the overwritten
 * method is undefined because each node can only have one method mapped to it.
 * 
 * @author Pamelloes
 * @version 1.0
 */
public class NodeHandler {
	/**
	 * The map containing nodes and their corresponding methods.
	 */
	protected final Map<String, Method> nodes;
	
	/**
	 * Creates a NodeHandler with the given prefix.
	 * 
	 * @param prefix The prefix for "node-methods"
	 */
	public NodeHandler(String prefix) {
		nodes = resolveMethods(prefix);
	}
	
	/**
	 * Finds all node methods.
	 * 
	 * @param prefix The prefix used to identify "node-methods"
	 */
	private Map<String, Method> resolveMethods(String prefix) {
		Map<String, Method> found = new HashMap<String, Method>();
		Class<?> c = getClass();
		do {
			for(Method m : c.getMethods()) {
				if(!m.getName().startsWith(prefix.toLowerCase()) || m.getParameterTypes().length != 1) continue;
				String[] parts = m.getName().split("(?=\\p{Upper})");
				if(parts.length <= 1) continue;
				StringBuilder name = new StringBuilder();
				for(int i = 1; i < parts.length; i++) name.append(parts[i]).append(".");
				name.deleteCharAt(name.length() - 1);
				found.put(name.toString().toUpperCase(), m);
			}
		} while((c = c.getSuperclass()) != null);
		return found;
	}
	
	/**
	 * Finds all of the methods that correspond to the
	 * given node. Note that the given node may contain
	 * an astrisk (*) which means that anything will
	 * be accepted in the given slot. However, only
	 * one item will be allowed, so in the event that
	 * there are the nodes "test.a" "test.b" "test.a.b"
	 * and "test.b.a", a search for "test.*" will return
	 * only "test.a" and "test.b", and "test.*.*" will
	 * return only "test.b.a" and "test.a.b".
	 * 
	 * @param node The node to search for.
	 * @return A list of methods matching the given
	 * node, may be empty, but not null.
	 */
	public List<Method> processNode(String node) {
		String name = node.toUpperCase();
		if(name.contains("*")) return handleStarNode(name);
		return handleSingleNode(name);
	}
	
	/**
	 * Searches for methods using a node with an asterisk (*)
	 * in its name.
	 * 
	 * @param node The node to search for.
	 * @return A list of the matching methods, may be empty, but not null.
	 */
	private List<Method> handleStarNode(String node) {
		String[] parts = node.split(".");
		List<Method> results = new ArrayList<Method>();
		loop: for(String s : nodes.keySet()) {
			String[] mparts = s.split(".");
			if(mparts.length != parts.length) continue;
			for(int i = 0; i < parts.length; i++) {
				if(parts[i].equals("*")) continue;
				if(!parts[i].equals(mparts[i])) continue loop;
			}
			
			Method m = nodes.get(s);
			if(m == null) continue;
			results.add(m);
		}
		return results;
	}

	
	/**
	 * Searches for methods using a node without an asterisk (*)
	 * in its name.
	 * 
	 * @param node The node to search for.
	 * @return A list of the matching methods, may be empty, but not null.
	 */
	private List<Method> handleSingleNode(String node) {
		List<Method> results = new ArrayList<Method>();
		Method m = nodes.get(node);
		if(m != null) results.add(m);
		return results;
	}
}

