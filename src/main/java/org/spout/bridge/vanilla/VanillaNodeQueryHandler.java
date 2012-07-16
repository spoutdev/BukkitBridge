package org.spout.bridge.vanilla;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.spout.bridge.module.query.Query;


/**
 * This class is used to handle requests for node queries. To add a node,
 * add a method called "query" followed by  all of the node's parts capitalized.
 * For instance, the node "this.is.a.test.node"  would need a method called
 * queryThisIsATestNode(). Note that the method needs an argument of "Query<T>".
 */
public class VanillaNodeQueryHandler {
	@SuppressWarnings("unused")
	private final VanillaModule module;
	private final Map<String, Method> nodes = resolveMethods();
	
	public VanillaNodeQueryHandler(VanillaModule module) {
		this.module = module;
	}
	
	/**
	 * Find all query methods.
	 */
	private Map<String, Method> resolveMethods() {
		Map<String, Method> found = new HashMap<String, Method>();
		for(Method m : getClass().getDeclaredMethods()) {
			if(!m.getName().startsWith("query") || !(m.getParameterTypes().length == 1 && m.getParameterTypes()[0].equals(Query.class))) continue;
			String[] parts = m.getName().split("(?=\\p{Upper})");
			if(parts.length <= 1) continue;
			StringBuilder name = new StringBuilder();
			for(int i = 1; i < parts.length; i++) name.append(parts[i]).append(".");
			name.deleteCharAt(name.length() - 1);
			found.put(name.toString().toUpperCase(), m);
		}
		return found;
	}
	
	/**
	 * Process the given query appropriately.
	 */
	public <T> void processQuery(Query<T> query, String node) {
		String name = node.toUpperCase();
		if(name.contains("*")) handleStarQuery(query, name);
		handleSingleQuery(query, name);
	}
	
	@SuppressWarnings("unchecked")
	private <T> void handleStarQuery(Query<T> q, String node) {
		String[] parts = node.split(".");
		List<Object> results = new ArrayList<Object>();
		loop: for(String s : nodes.keySet()) {
			String[] mparts = s.split(".");
			if(mparts.length != parts.length) continue;
			for(int i = 0; i < parts.length; i++) {
				if(parts[i].equals("*")) continue;
				if(!parts[i].equals(mparts[i])) continue loop;
			}
			
			Method m = nodes.get(s);
			if(m == null) continue;
			try {
				q.setResult(null);
				m.invoke(this, q);
				if(q.getResult() != null) results.add(q.getResult());
			} catch (Exception e) {
				System.err.println("Warning: Could not execute method " + m.getName());
				e.printStackTrace();
			}
		}
		q.setResult((T) results);
	}
	
	private <T> void handleSingleQuery(Query<T> q, String node) {
		Method m = nodes.get(node);
		if(m == null) return;
		try {
			m.invoke(this, q);
		} catch (Exception e) {
			System.err.println("Warning: Could not execute method " + m.getName());
			e.printStackTrace();
		}
	}
}
