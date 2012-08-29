package org.spout.bridge.module.query;

public class NodedQuery<T> extends Query<T> implements Cloneable {
	private String base;
	private String node;
	
	/**
	 * Creates a BlockWuery for the given node with the
	 * given arguments.
	 */
	public NodedQuery(String base, String node, Object ...args) {
		super(base + ": " + node, args);
		this.node = node;
		this.base = base;
	}
	
	/**
	 * Changes the query to match the new state.
	 */
	public void configure(String node, Object ...args) {
		this.node = node;
		super.configure(base + ": " + node, args);
	}
	
	/**
	 * Gets the node being requested.
	 */
	public String getNode() {
		return node;
	}
	
	/**
	 * Gets this configuration's base.
	 */
	public String getBase() {
		return base;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public NodedQuery<T> clone() throws CloneNotSupportedException {
		return (NodedQuery<T>) super.clone();
	}

}
