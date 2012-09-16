package org.spout.bridge.module;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used to process nodes. With a specified prefix To add a node,
 * add a method who's name starts with the given prefix in lower case followed by  all of the node's parts capitalized.
 * For instance, the node "this.is.a.test.node"  would need a method called
 * &lt;prefix&gt;ThisIsATestNode(). Note that the method needs to have only one argument.
 */
public class NodeHandler {
	private final Map<String, Method> nodes;
	
	public NodeHandler(String prefix) {
		nodes = resolveMethods(prefix);
	}
	
	/**
	 * Find all query methods.
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
	 * Process the given query appropriately.
	 */
	public List<Method> processNode(String node) {
		String name = node.toUpperCase();
		if(name.contains("*")) return handleStarNode(name);
		return handleSingleNode(name);
	}
	
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
	
	private List<Method> handleSingleNode(String node) {
		List<Method> results = new ArrayList<Method>();
		Method m = nodes.get(node);
		if(m != null) results.add(m);
		return results;
	}
}

