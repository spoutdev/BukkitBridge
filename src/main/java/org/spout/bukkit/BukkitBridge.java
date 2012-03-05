/*
 * This file is part of BukkitBridge (http://www.spout.org/).
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
package org.spout.bukkit;

import java.io.File;
import java.util.logging.Level;

import org.spout.api.Spout;
import org.spout.api.plugin.CommonPlugin;

import org.bukkit.Bukkit;
import org.bukkit.Server;

public class BukkitBridge extends CommonPlugin {
	private final BridgeServer bridgeServer = new BridgeServer(this);
	private File pluginFolder;

	@Override
	public void onEnable() {
		this.pluginFolder = new File(this.getGame().getDataFolder().getParentFile() + File.separator + "plugins");
		if (!(Spout.getGame() instanceof org.spout.api.Server)) {
			this.getPluginLoader().disablePlugin(this);
			this.getLogger().log(Level.SEVERE, "Unable to load BukkitBridge. Could not detect a Spout server!");
		}
		bridgeServer.init((org.spout.api.Server) Spout.getGame());
		Bukkit.setServer(bridgeServer);
	}

	@Override
	public void onDisable() {
		//TODO: Adjust for usage with Spout!
	}

	public Server getServer() {
		return bridgeServer;
	}

	public File getPluginFolder() {
		return pluginFolder;
	}
}
