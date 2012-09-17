package org.spout.bridge.vanilla.hook;

import org.spout.bridge.module.hook.ChangeConfigurationHook;

public class VanillaChangeConfigurationHook<T> extends ChangeConfigurationHook<T> {
	private VanillaHookHandler handler;
	
	public VanillaChangeConfigurationHook(VanillaHookHandler handler, String node) {
		super(node);
		this.handler = handler;
	}

	@Override
	public void invoke(T arg) {
		handler.handleHook(getNode(), arg);
	}

}
