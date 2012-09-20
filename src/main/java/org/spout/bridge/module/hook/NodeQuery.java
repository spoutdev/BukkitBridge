package org.spout.bridge.module.hook;

/**
 * A NodeQuery is a Query identified by a node. A {@link org.spout.bridge.module.NodeHandler node}
 * is essentially a string with a base id, and then a path. NodeQuerie are the standard query in Bridge.
 * 
 * @author Pamelloes
 * @version 1.0
 * 
 * @see Hook
 * @see Query
 * @see NodeQueryHandler
 */
public class NodeQuery<T> extends Query<T> implements Cloneable {
	private final String base;
	private String node;
	
	/**
	 * Creates a NodeQuery for the given node with the
	 * given arguments.
	 * 
	 * @param base The Query's base.
	 * @param node The node of the NodeQuery.
	 */
	public NodeQuery(String base, String node, Object ...args) {
		super(base + ": " + node, args);
		this.base = base;
		this.node = node;
	}
	
	/**
	 * Changes the Query to match the new state.
	 * 
	 * @param node The Query's new node.
	 * @param args The Query's new arguments.
	 */
	@Override
	public void configure(String node, Object ...args) {
		this.node = node;
		super.configure(base + ": " + node, args);
	}
	
	/**
	 * Gets the node being requested.
	 * 
	 * @return The Query's current node.
	 */
	public String getNode() {
		return node;
	}
	
	/**
	 * Gets this Query's base.
	 * 
	 * @return The Query's base.
	 */
	public String getBase() {
		return base;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public NodeQuery<T> clone() throws CloneNotSupportedException {
		return (NodeQuery<T>) super.clone();
	}

}
