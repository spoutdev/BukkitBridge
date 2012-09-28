package org.spout.bridge.workbench.handlers;

import org.spout.bridge.module.hook.Hook;

public class WorkbenchHookHandler {

	WorkbenchBanHookHandler banHandler;
	
	public WorkbenchHookHandler(){
		banHandler=new WorkbenchBanHookHandler();
	}
	
	public void processHook(Hook h) {
		// TODO Auto-generated method stub
		
	}

}
