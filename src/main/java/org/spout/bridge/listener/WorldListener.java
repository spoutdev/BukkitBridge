/*
 * This file is part of BukkitBridge.
 *
 * Copyright (c) 2012, VanillaDev <http://www.spout.org/>
 * BukkitBridge is licensed under the GNU General Public License.
 *
 * BukkitBridge is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BukkitBridge is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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

public class WorldListener extends AbstractListener {
	private final List<BridgeWorld> worlds = new ArrayList<BridgeWorld>();

	public WorldListener(VanillaBridgePlugin plugin) {
		super(plugin);
	}

	@EventHandler(order = Order.EARLIEST)
	public void onWorldLoad(WorldLoadEvent event) {
		BridgeWorld world = new BridgeWorld((BridgeServer) Bukkit.getServer(), event.getWorld());
		synchronized (worlds) {
			worlds.add(world);
		}
		Bukkit.getPluginManager().callEvent(new org.bukkit.event.world.WorldLoadEvent(world));
	}

	@EventHandler(order = Order.EARLIEST)
	public void onWorldUnload(WorldUnloadEvent event) {
		BridgeWorld found = null;
		synchronized (worlds) {
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
		synchronized (worlds) {
			return new ArrayList<BridgeWorld>(worlds);
		}
	}

	@EventHandler
	public void onChunk(){
		//todo implement onChunk
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onChunkLoad(){
		//todo implement onChunkLoad
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onChunkPopulate(){
		//todo implement onChunkPopulate
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onChunkOnload(){
		//todo implement onChunkOnload
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPortalCreate(){
		//todo implement onPortalCreate
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onSpawnChange(){
		//todo implement onSpawnChange
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onStructureGrow(){
		//todo implement onStructureGrow
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onWorld(){
		//todo implement onWorld
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onWorldInit(){
		//todo implement onWorldInit
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onWorldSave(){
		//todo implement onWorldSave
		throw new UnsupportedOperationException();
	}
}
