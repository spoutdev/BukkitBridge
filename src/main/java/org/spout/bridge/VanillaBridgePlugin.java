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
import org.spout.api.Server;
import org.spout.api.Spout;
import org.spout.api.plugin.CommonPlugin;
import org.spout.bridge.bukkit.BridgeServer;
import org.spout.bridge.listener.WorldListener;

public class VanillaBridgePlugin extends CommonPlugin {
	private static VanillaBridgePlugin instance;
	private WorldListener worldListener;

	public VanillaBridgePlugin() {
		instance = this;
	}

	@Override
	public void onEnable() {
		worldListener = new WorldListener(this);
		
		
		BridgeServer server = new BridgeServer((Server)Spout.getEngine(), this);
		Bukkit.setServer(server);
		
	}

	@Override
	public void onDisable() {
		
	}

	public WorldListener getWorldListener() {
		return worldListener;
	}

	public static VanillaBridgePlugin getInstance() {
		return instance;
	}
}
