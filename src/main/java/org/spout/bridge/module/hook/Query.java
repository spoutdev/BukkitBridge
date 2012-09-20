package org.spout.bridge.module.hook;

/**
 * A Query is a Hook with a result. Queries are typically used
 * to get information about the state of the game whereas Hooks
 * are typically used for modifying the game's state. Note that
 * a Query can only be sent to the MainModule, whereas a Hook
 * can be sent to any Module. Note that because Query subclasses
 * Hook, it can be passed to the {@link org.spout.bridge.module.Module#processHook(Hook) processHook()}
 * method, normal Modules are not required to support it and it
 * will most likely be processed incorrectly.
 * 
 * @author Pamelloes
 * @version 1.1
 * 
 * @param <T> The return type of the Query.
 * @see Hook
 * @see NodeQuery
 */
public class Query<T> extends Hook {
	private T result = null;
	
	/**
	 * Creates a Query with the given name and arguments.
	 * 
	 * @param name The name of the Query.
	 * @param args The Query's arguments.
	 */
	public Query(String name, Object...args) {
		super(name, args);
	}
	
	/**
	 * Set the Query's result.
	 * 
	 * return The new result.
	 */
	public void setResult(T result) {
		this.result = result;
	}
	
	/**
	 * Gets the Query's result.
	 * 
	 * @return The result of the Query. Can be null.
	 */
	public T getResult() {
		return result;
	}
	
	/**
	 * Changes the Query to match the new state. Note that this
	 * resets the result to null.
	 * 
	 * @param name The Query's new name.
	 * @param args The Query's new arguments.
	 */
	@Override
	public void configure(String name, Object... args) {
		super.configure(name, args);
		setResult(null);
	}
}
