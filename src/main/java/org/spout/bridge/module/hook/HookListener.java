package org.spout.bridge.module.hook;

/**
 * A Hook Listener is notified when hooks are called.
 *
 * @param <T> The hook being listened to.
 */
public interface HookListener<T extends Hook> {
	
	/**
	 * Called when the given hook is called.
	 */
	public void onHook(T hook);
}
