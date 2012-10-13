package org.spout.bridge.listener;

import org.spout.api.Spout;
import org.spout.api.event.Listener;
import org.spout.bridge.VanillaBridgePlugin;

public abstract class AbstractListener implements Listener{
	protected final VanillaBridgePlugin plugin;
	public AbstractListener(VanillaBridgePlugin plugin) {
		this.plugin = plugin;
		Spout.getEngine().getEventManager().registerEvents(this, plugin);
	}

}
