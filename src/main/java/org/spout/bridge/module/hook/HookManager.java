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
		hooks.put(hook.getName().toUpperCase(), list);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> void callHook(String name, T parameter) {
		List<Hook<?>> call = hooks.get(name.toUpperCase());
		for(Hook<?> h : call) ((Hook<T>) h).invoke(parameter);//Generics trickery ftw. May cause a ClassCastException at runtime, though...
	}
}
