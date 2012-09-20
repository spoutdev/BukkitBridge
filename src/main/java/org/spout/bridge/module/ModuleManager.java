package org.spout.bridge.module;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
	private static List<Module> modules;
	private static MainModule main = null;
	
	public static void init() {
		modules = new ArrayList<Module>();
	}
	
	public static void load() {
		List<Class<? extends Module>> classes = getClasses();
		for (Class<? extends Module> clazz : classes) {
			Module m = null;
			try {
				m = clazz.newInstance();
			} catch (Exception e) {
				System.err.println("Module " + clazz.getName() + " could not be instantiated!");
				e.printStackTrace();
			}
			if (m == null) continue;
			
			if(m instanceof MainModule) {
				if(main == null) {
					main = (MainModule) m;
				} else {
					System.err.println("There can not be multiple MainModules. Skipping MainModule " + clazz.getName() + "!");
					continue;
				}
			}
			
			m.onLoad();
		}
		if(main == null) throw new IllegalStateException("There must be a MainModule!");
	}
	
	public static void start() {
		for(Module m : modules) m.onEnable();
	}
	
	public static void stop() {
		for(Module m : modules) m.onDisable();
	}
	
	public static MainModule getMainModule() {
		return main;
	}
	
	public static List<Module> getModules() {
		return modules;
	}
	
	private static List<Class<? extends Module>> getClasses() {
		@SuppressWarnings("serial")
		//TODO Get a list of the module names. A configuration that contains these needs to be written.
		List<String> classnames = new ArrayList<String>() {{ add("org.spout.bridge.bukkit.BukkitModule"); add("org.spout.bridge.vanilla.VanillaModule");}};
		
		List<Class<? extends Module>> classes = new ArrayList<Class<? extends Module>>();
		for(String s : classnames) {
			Class<?> clazz = null;
			try {
				clazz = Class.forName(s);
			} catch (Exception e) {
				System.err.println("Could not load class " + s + "! Skipping module!");
				e.printStackTrace();
			}
			if(clazz == null) continue;
			
			if(!Module.class.isAssignableFrom(clazz)) {
				System.err.println("The specified class " + s + " is not a module! Skipping module!");
				continue;
			}
			classes.add(clazz.asSubclass(Module.class));
		}
		return classes;
	}
}
