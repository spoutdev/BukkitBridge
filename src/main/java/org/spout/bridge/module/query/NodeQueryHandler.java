package org.spout.bridge.module.query;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.spout.bridge.module.NodeHandler;

public class NodeQueryHandler extends NodeHandler {

	public NodeQueryHandler() {
		super("query");
	}

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
