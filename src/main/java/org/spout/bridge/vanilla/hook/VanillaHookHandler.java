package org.spout.bridge.vanilla.hook;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.spout.bridge.module.NodeHandler;
import org.spout.bridge.module.hook.HookManager;
import org.spout.bridge.module.hook.NodeHook;

public class VanillaHookHandler extends NodeHandler {

	public VanillaHookHandler(@SuppressWarnings("rawtypes") Class<? extends NodeHook> clazz) {
		super("hook");
		try {
			@SuppressWarnings("rawtypes")
			Constructor<? extends NodeHook> c = clazz.getConstructor(VanillaHookHandler.class, String.class);
			if(c == null) throw new IllegalArgumentException("Class " + clazz.getName() + " does not have a valid constructor: (VanillaHookHandler,String)");
			for(String hook : nodes.keySet()) {
				HookManager.addHook(c.newInstance(hook));
			}
		} catch(Exception e) {
			throw new RuntimeException("Could not load hooks", e);
		}
	}
	
	public <T> void handleHook(String node, T arg) {
		for(Method m : processNode(node)) {
			try {
				m.invoke(this, arg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
