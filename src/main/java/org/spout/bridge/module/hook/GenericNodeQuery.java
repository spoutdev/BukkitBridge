package org.spout.bridge.module.hook;

/**
 * The default implementation of NodeQuery.
 * 
 * @author Pamelloes
 * @version 1.0
 */
public class GenericNodeQuery<T> extends GenericQuery<T> implements NodeQuery<T> {
	private final String base;
	private String node;
	
	/**
	 * Creates a GenericNodeQuery for the given node with the
	 * given arguments.
	 * 
	 * @param base The GenericNodeQuery's base.
	 * @param node The node of the GenericNodeQuery.
	 */
	public GenericNodeQuery(String base, String node, Object ...args) {
		super(base + ": " + node, args);
		this.base = base;
		this.node = node;
	}
	
	/**
	 * Changes the GenericNodeQuery to match the new state.
	 * 
	 * @param node The GenericNodeQuery's new node.
	 * @param args The GenericNodeQuery's new arguments.
	 */
	@Override
	public void configure(String node, Object ...args) {
		this.node = node;
		super.configure(base + ": " + node, args);
	}
	
	@Override
	public String getNode() {
		return node;
	}
	
	@Override
	public String getBase() {
		return base;
	}
}
