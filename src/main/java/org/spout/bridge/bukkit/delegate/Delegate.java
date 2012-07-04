package org.spout.bridge.bukkit.delegate;

/**
 * A Delegate acts as the final stage in the delegation process. The delegate
 * handles the specifics of each actual method where appropriate. If another
 * delegate is more pat for a method call, then the method will be delegated
 * to it.
 *
 * @param <T> The type of object that this acts as delegate for.
 */
public class Delegate<T> {
	private T object;
	
	public void setDelegator(T delegator) {
		object = delegator;
	}
	
	public T getDelegator() {
		return object;
	}
}
