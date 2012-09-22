package org.spout.bridge.module.hook;

/**
 * The default implementation of NodeHook.
 * 
 * @author Pamelloes
 * @version 1.0
 */
public class GenericNodeHook extends GenericHook implements NodeHook {
	private final String base;
	private String node;
	
	/**
	 * Creates a GenericNodeHook for the given node with the
	 * given arguments.
	 * 
	 * @param base The GenericNodeHook's base.
	 * @param node The node of the GenericNodeHook.
	 */
	public GenericNodeHook(String base, String node, Object ...args) {
		super(base + ": " + node, args);
		this.base = base;
		this.node = node;
	}
	
	/**
	 * Changes the GenericNodeHook to match the new state.
	 * 
	 * @param node The GenericNodeHook's new node.
	 * @param args The GenericNodeHook's new arguments.
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
