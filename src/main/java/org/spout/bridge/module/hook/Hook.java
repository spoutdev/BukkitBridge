package org.spout.bridge.module.hook;

/**
 * A hook represents a cross-api event. Note that a hook can be sent from a
 * Module instead of being recieved from within one.
 */
public abstract class Hook {
	public abstract String getName();
}
