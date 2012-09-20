package org.spout.bridge;

import java.util.Arrays;

import org.spout.bridge.module.Module;
import org.spout.bridge.module.ModuleManager;
import org.spout.bridge.module.hook.Hook;
import org.spout.bridge.module.hook.Query;

/**
 * Static utility class used for various high-level Bridge functions.
 */
public class Bridge {
	/**
	 * Starts Bridge. Called by a plugin.
	 */
	public static void start() {
		//Setup managers.
		ModuleManager.init();
		
		//Load the modules. This provides conversions and hooks for the respective managers.
		ModuleManager.load();
		
		//Enable the modules.
		ModuleManager.start();
	}
	
	/**
	 * Stops the bridge. Called by a plugin.
	 */
	public static void stop() {
		ModuleManager.stop();
	}
	
	/**
	 * Executes the given query.
	 * 
	 * @param q The query to be executed.
	 */
	public static <T> T callQuery(Query<T> q) {
		ModuleManager.getMainModule().processQuery(q);
		return q.getResult();
	}
	
	/**
	 * Executes the given hook. Note that this calls
	 * the hook on all modules, if you only want to
	 * call the hook on certain modules, see {@link #callHook(Hook, boolean, Module[]) callHook()}.
	 * 
	 * @param the hook to invoke
	 * @see #callHook(Hook, boolean, Module...)
	 */
	public static void callHook(Hook h) {
		Bridge.callHook(h, false, (Module[]) null);
	}
	
	/**
	 * Executes the given hook.
	 * 
	 * @param h The hook to call.
	 * @param exclude true to invoke on all modules except the ones
	 * specified, false to invoke only on the ones specified.
	 * @see #callHook(Hook)
	 */
	public static void callHook(Hook h, boolean exclude, Module... affect) {
		if(h instanceof Query) callQuery((Query<?>) h);
		else {
			for(Module m : ModuleManager.getModules()) {
				if(exclude ^ Arrays.asList(affect).contains(m)) m.processHook(h);
			}
		}
	}
}
