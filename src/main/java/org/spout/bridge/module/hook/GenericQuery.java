package org.spout.bridge.module.hook;

/**
 * The default implementation of Query.
 * 
 * @author Pamelloes
 * @version 1.0
 * 
 * @param <T> The return type of the Query.
 */
public class GenericQuery<T> extends GenericHook implements Query<T> {
	private T result = null;
	
	/**
	 * Creates a GenericQuery with the given name and arguments.
	 * 
	 * @param name The name of the GenericQuery.
	 * @param args The GenericQuery's arguments.
	 */
	public GenericQuery(String name, Object...args) {
		super(name, args);
	}
	
	@Override
	public void setResult(T result) {
		this.result = result;
	}
	
	@Override
	public T getResult() {
		return result;
	}
	
	/**
	 * Changes the GenericQuery to match the new state. Note that this
	 * resets the result to null.
	 * 
	 * @param name The GenericQuery's new name.
	 * @param args The GenericQuery's new arguments.
	 */
	@Override
	public void configure(String name, Object... args) {
		super.configure(name, args);
		setResult(null);
	}
}
