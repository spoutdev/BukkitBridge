package org.spout.bridge.module.hook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HookManager {
	private static Map<String, List<Hook<?>>> hooks;
	
	public static void init() {
		hooks = new HashMap<String, List<Hook<?>>>();
	}
	
	public static void addHook(Hook<?> hook) {
		List<Hook<?>> list = hooks.get(hook.getName());
		if(list == null) list = new ArrayList<Hook<?>>();
		list.add(hook);
		hooks.put(hook.getName(), list);
	}
	
	public static void callHook(String name, Object parameter) {
		List<Hook<?>> call = hooks.get(name);
		for(Hook<?> h : call) h.invoke(parameter);
	}
}
