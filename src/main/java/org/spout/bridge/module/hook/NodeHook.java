package org.spout.bridge.module.hook;

public abstract class NodeHook<T> extends Hook<T> implements Cloneable {
	private final String base;
	private final String node;
	private final String name;
	
	/**
	 * Creates a NodedHook for the given base and node.
	 */
	public NodeHook(String base, String node) {
		this.base = base;
		this.node = node;
		this.name = base + ": " + node;
	}
	
	/**
	 * Gets the node being requested.
	 */
	public String getNode() {
		return node;
	}
	
	/**
	 * Gets this hook's base.
	 */
	public String getBase() {
		return base;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public NodeHook<T> clone() throws CloneNotSupportedException {
		return (NodeHook<T>) super.clone();
	}
}
