package org.spout.bridge.module.hook;

import java.lang.reflect.Method;

import org.spout.bridge.module.NodeHandler;

/**
 * A NodeHookHandler is a NodeHandler that provides additional processing
 * for hooks. Note that the NodeHandler prefix is "hook".
 * 
 * @author Pamelloes
 * @version 1.0
 * @see NodeHandler
 * @see NodeHook
 */
public abstract class NodeHookHandler extends NodeHandler {

	/**
	 * Creates a new NodeHookHandler. Note that the
	 * NodeHandler prefix is "hook".
	 */
	public NodeHookHandler() {
		super("hook");
	}

	/**
	 * Processes the given NodeHook. This method finds and invokes
	 * all off the relevant methods for the NodeHook.
	 * 
	 * @param h The NodeHook to process.
	 */
	public void processHook(NodeHook h) {
		String node = h.getName().substring(h.getName().indexOf(": ") + 2);
		for(Method m : processNode(node)) {
			try {
				m.invoke(this, h);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
