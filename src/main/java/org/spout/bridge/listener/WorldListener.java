package org.spout.bridge.listener;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.spout.api.event.EventHandler;
import org.spout.api.event.Order;
import org.spout.api.event.world.WorldLoadEvent;
import org.spout.api.event.world.WorldUnloadEvent;
import org.spout.bridge.VanillaBridgePlugin;
import org.spout.bridge.bukkit.BridgeServer;
import org.spout.bridge.bukkit.BridgeWorld;

public class WorldListener extends AbstractListener{
	private final List<BridgeWorld> worlds = new ArrayList<BridgeWorld>();

	public WorldListener(VanillaBridgePlugin plugin) {
		super(plugin);
	}

	@EventHandler(order = Order.EARLIEST)
	public void onWorldLoad(WorldLoadEvent event) {
		BridgeWorld world = new BridgeWorld((BridgeServer)Bukkit.getServer(), event.getWorld());
		synchronized(worlds) {
			worlds.add(world);
		}
		Bukkit.getPluginManager().callEvent(new org.bukkit.event.world.WorldLoadEvent(world));
	}

	@EventHandler(order = Order.EARLIEST)
	public void onWorldUnload(WorldUnloadEvent event) {
		BridgeWorld found = null;
		synchronized(worlds) {
			for (int i = 0; i < worlds.size(); i++) {
				BridgeWorld world = worlds.get(i);
				if (world.getName().equals(event.getWorld().getName())) {
					found = worlds.remove(i);
					break;
				}
			}
		}
		if (found != null) {
			Bukkit.getPluginManager().callEvent(new org.bukkit.event.world.WorldUnloadEvent(found));
		}
	}
	
	public List<BridgeWorld> getWorlds() {
		synchronized(worlds) {
			return new ArrayList<BridgeWorld>(worlds);
		}
	}
}
