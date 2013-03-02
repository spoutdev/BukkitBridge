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
package org.spout.bridge;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginLoadOrder;

import org.spout.api.Server;
import org.spout.api.Spout;
import org.spout.api.data.DataProvider;
import org.spout.api.event.Cause;
import org.spout.api.event.cause.PluginCause;
import org.spout.api.plugin.CommonPlugin;
import org.spout.api.plugin.Plugin;
import org.spout.api.scheduler.TaskPriority;

import org.spout.bridge.bukkit.BridgeServer;
import org.spout.bridge.listener.BlockListener;
import org.spout.bridge.listener.EntityListener;
import org.spout.bridge.listener.PlayerListener;
import org.spout.bridge.listener.WorldListener;

/**
 * Bridge redirects Bukkit method calls to the Spout API, allowing Bukkit plugins to run on Spout
 */
public class VanillaBridgePlugin extends CommonPlugin {
	private static VanillaBridgePlugin instance;
	private static Cause<Plugin> pluginCause;
	private WorldListener worldListener;
	private PlayerListener playerListener;
	private EntityListener entityListener;
	private BlockListener blockListener;
	private final DataProvider dataProvider = new DataProvider();

	public VanillaBridgePlugin() {
		instance = this;
	}

	@Override
	public void onEnable() {
		worldListener = new WorldListener(this);
		playerListener = new PlayerListener(this);
		entityListener = new EntityListener(this);
		blockListener = new BlockListener(this);
		BridgeServer server = new BridgeServer((Server) Spout.getEngine(), this);
		getLogger().info("enabled. Version: (" + server.getVersion() + " | Bukkit: " + server.getBukkitVersion() + ")");
		pluginCause = new PluginCause(this);
		Spout.getEventManager().registerEvents(dataProvider, this);
		this.getEngine().getScheduler().scheduleSyncDelayedTask(this, new LoadPluginsTask(), 2, TaskPriority.NORMAL);
	}

	@Override
	public void onDisable() {
		getLogger().info("disabled.");
	}

	public WorldListener getWorldListener() {
		return worldListener;
	}

	public PlayerListener getPlayerListener() {
		return playerListener;
	}

	public EntityListener getEntityListener() {
		return entityListener;
	}

	public BlockListener getBlockListener() {
		return blockListener;
	}

	public DataProvider getDataProvider() {
		return dataProvider;
	}

	public static VanillaBridgePlugin getInstance() {
		return instance;
	}

	public static Cause<Plugin> getCause() {
		return pluginCause;
	}

	private static class LoadPluginsTask implements Runnable {
		@Override
		public void run() {
			Spout.getLogger().info("Loading post-world bukkit plugins");
			((BridgeServer) Bukkit.getServer()).enablePlugins(PluginLoadOrder.POSTWORLD);
		}
	}
}
