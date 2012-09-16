package org.spout.bridge.module.query;

/**
 * A Query identified by a node. A node is essentially a string with a base
 * id, and then a path. The base is used for identifying the type e.g. "Block"
 * and the path is used for determining the actual information (e.g. "block.position.x")
 */
public class NodedQuery<T> extends Query<T> implements Cloneable {
	private String base;
	private String node;
	
	/**
	 * Creates a NodedQuery for the given node with the
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
	 * Gets this query's base.
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
