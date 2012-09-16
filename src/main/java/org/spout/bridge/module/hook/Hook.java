package org.spout.bridge.module.hook;

/**
 * A hook represents a cross-api event.
 * 
 * @param <T> The type of the object being passed.
 */
public abstract class Hook<T> {
	
	public abstract String getName();
	
	/**
	 * This method is called when the hook is executed. The parameter
	 * will be converted to the type specified by the hook's type parameter.
	 * If the parameter could not be converted, the argument will be null.
	 * <br />
	 * <br />
	 * The subclass is responsible for calling the appropriate method. For
	 * instance in the EventHook. When this method is called, it turns around
	 * and calls "onEvent(T arg)". Then, the subclass of EventHook would use
	 * the hook. Note that this subclass will be module specific (e.g. BukkitEventHook).
	 */
	public abstract void invoke(T arg);
}
