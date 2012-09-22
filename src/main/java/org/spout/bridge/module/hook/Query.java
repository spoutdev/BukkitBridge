package org.spout.bridge.module.hook;

/**
 * A Query is a Hook with a result. Queries are typically used
 * to get information about the state of the game whereas Hooks
 * are typically used for modifying the game's state. Note that
 * a Query can only be sent to the MainModule, whereas a Hook
 * can be sent to any Module. Note that because Query subclasses
 * Hook, it can be passed to the {@link org.spout.bridge.module.Module#processHook(GenericHook) processHook()}
 * method, normal Modules are not required to support it and it
 * will most likely be processed incorrectly.
 * 
 * @author Pamelloes
 * @version 1.2
 * 
 * @param <T> The return type of the Query.
 * @see Hook
 * @see NodeHook
 * @see NodeQuery
 */
public interface Query<T> extends Hook {
	
	/**
	 * Set the Query's result.
	 * 
	 * return The new result.
	 */
	public void setResult(T result);
	
	/**
	 * Gets the Query's result.
	 * 
	 * @return The result of the Query. Can be null.
	 */
	public T getResult();

}
