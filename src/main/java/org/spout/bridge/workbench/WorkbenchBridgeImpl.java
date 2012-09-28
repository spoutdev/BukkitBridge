package org.spout.bridge.workbench;

import org.spout.api.Spout;
import org.spout.bridge.workbench.server.WorkbenchServer;

import net.minecraft.workbench.WorkbenchImpl;
import net.minecraft.workbench.server.Server;

public class WorkbenchBridgeImpl extends WorkbenchImpl {

	@Override
	public String getImplementationName() {
		return "Spout";
	}

	@Override
	public String getImplementationVersion() {
		return "1.0";
	}

	@Override
	public Server getServer() {
		return new WorkbenchServer((org.spout.api.Server) Spout.getEngine());
	}

}
