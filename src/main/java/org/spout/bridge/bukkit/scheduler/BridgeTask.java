package org.spout.bridge.bukkit.scheduler;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public class BridgeTask implements BukkitTask, Runnable {
	@Override
	public int getTaskId() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Plugin getOwner() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isSync() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void run() {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
