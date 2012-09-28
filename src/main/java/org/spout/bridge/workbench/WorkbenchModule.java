package org.spout.bridge.workbench;

import net.minecraft.workbench.Workbench;

import org.spout.api.Spout;
import org.spout.bridge.module.Module;
import org.spout.bridge.module.hook.Hook;
import org.spout.bridge.workbench.handlers.WorkbenchHookHandler;

public class WorkbenchModule implements Module {

	private WorkbenchBridgeImpl implementation;
	private WorkbenchHookHandler hookHandler;
	
	@Override
	public void onLoad() {
		implementation = new WorkbenchBridgeImpl();
		hookHandler=new WorkbenchHookHandler();
	}

	@Override
	public void onEnable() {
		Spout.getLogger().info("Workbench bridge enabled");
		Workbench.setInstance(implementation);
	}

	@Override
	public void onDisable() {
		Spout.getLogger().info("Workbench bridge disabled");
	}

	@Override
	public void processHook(Hook h) {
		hookHandler.processHook(h);
	}

}
