/*
 * This file is part of BukkitBridge.
 *
 * Copyright (c) 2012 Spout LLC <http://www.spout.org/>
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
package org.spout.bridge.bukkit.plugin;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import com.avaje.ebean.EbeanServer;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;

import org.spout.api.Spout;

/**
 * A wrapper around Spout plugins for Bukkit plugins.
 */
public final class SpoutPlugin implements Plugin {
	private final org.spout.api.plugin.Plugin plugin;

	public SpoutPlugin(org.spout.api.plugin.Plugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		throw new UnsupportedOperationException();
	}

	@Override
	public FileConfiguration getConfig() {
		throw new UnsupportedOperationException();
	}

	@Override
	public File getDataFolder() {
		return plugin.getDataFolder();
	}

	@Override
	public EbeanServer getDatabase() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ChunkGenerator getDefaultWorldGenerator(String arg0, String arg1) {
		throw new UnsupportedOperationException();
	}

	@Override
	public PluginDescriptionFile getDescription() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Logger getLogger() {
		return plugin.getLogger();
	}

	@Override
	public String getName() {
		return plugin.getName();
	}

	@Override
	public PluginLoader getPluginLoader() {
		throw new UnsupportedOperationException();
	}

	@Override
	public InputStream getResource(String path) {
		return Spout.getFileSystem().getResourceStream(path);
	}

	@Override
	public Server getServer() {
		return Bukkit.getServer();
	}

	@Override
	public boolean isEnabled() {
		return plugin.isEnabled();
	}

	@Override
	public boolean isNaggable() {
		return false;
	}

	@Override
	public void onDisable() {
		plugin.onDisable();
	}

	@Override
	public void onEnable() {
		plugin.onEnable();
	}

	@Override
	public void onLoad() {
		plugin.onLoad();
	}

	@Override
	public void reloadConfig() {
		plugin.onReload();
	}

	@Override
	public void saveConfig() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void saveDefaultConfig() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void saveResource(String arg0, boolean arg1) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setNaggable(boolean nag) {
		// Left blank intentionally
	}

	@Override
	public int hashCode() {
		return plugin.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SpoutPlugin) {
			SpoutPlugin other = (SpoutPlugin) obj;
			return other.plugin.equals(plugin);
		}
		return false;
	}

	@Override
	public String toString() {
		return "SpoutPlugin: { " + plugin.toString() + " }";
	}
}
