package org.spout.bridge.module.hook;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.spout.bridge.module.NodeHandler;

/**
 * A NodeQueryHandler is a NodeHandler that provides additional processing
 * for queries. Note that the NodeHandler prefix is "query" and that all
 * "node-methods" <em><strong>must</strong></em> have a return value and
 * should return the result they want to put into the query and not set
 * the result directly.
 * 
 * @author Pamelloes
 * @version 1.0
 * @see NodeHandler
 * @see NodeQuery
 */
public abstract class NodeQueryHandler extends NodeHandler {

	/**
	 * Creates a new NodeQueryHandler. Note that the
	 * NodeHandler prefix is "query".
	 */
	public NodeQueryHandler() {
		super("query");
	}

	/**
	 * Processes the given Query. This method invokes all off the
	 * relevant methods for the Query and then sets the result to
	 * the result of the given methods (they are put into a list if
	 * there is more than one).
	 * 
	 * @param q The query to process.
	 */
	@SuppressWarnings("unchecked")
	public <T> void processQuery(Query<T> q) {
		String node = q.getName().substring(q.getName().indexOf(": ") + 2);
		List<Method> methods = processNode(node);
		if(methods.size() == 0) q.setResult(null);
		else if(methods.size() == 1) {
			try {
				q.setResult((T) methods.get(0).invoke(this, q));
			} catch (Exception e) {
				e.printStackTrace();
				q.setResult(null);
			}
		} else {
			List<T> results = new ArrayList<T>();
			for(Method m : methods) {
				try {
					results.add((T) m.invoke(this, q));
				} catch (Exception  e) {
					e.printStackTrace();
					results.add(null);
				}
			}
			q.setResult((T) results);//this is a nasty hack. Essentially the way this will work
			//is you will create a NodeQuery<List<Object>> with a star node and everything should
			//work out. This looks very questionable here, but will work fine because generics is
			//stripped at runtime allowing for code like this to work.
		}
	}
}
