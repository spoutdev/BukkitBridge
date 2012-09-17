package org.spout.bridge.module.hook;

public abstract class ChangeConfigurationHook<T> extends NodeHook<T> {
	
	public static <T> void callChangeConfigurationHook(String node, T newValue) {
		HookManager.callHook("Configuration: " + node, newValue);
	}
	
	public ChangeConfigurationHook(String node) {
		super("Configuration", node);
	}
}
