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
package org.spout.bridge.bukkit;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import org.bukkit.Server;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.UnknownDependencyException;

public class ForwardingPluginManager implements PluginManager {
	private final SimplePluginManager manager;
	private final Method fireEvent;

	ForwardingPluginManager(Server server) {
		manager = new SimplePluginManager(server, new SimpleCommandMap(server));
		try {
			fireEvent = SimplePluginManager.class.getDeclaredMethod("fireEvent", new Class[] {Event.class});
			fireEvent.setAccessible(true);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException("Unable to find SimplePluginManager.fireEvent(event)", e);
		} catch (SecurityException e) {
			throw new RuntimeException("Unable to access SimplePluginManager.fireEvent(event)", e);
		}
	}

	@Override
	public synchronized void addPermission(Permission perm) {
		manager.addPermission(perm);
	}

	@Override
	public void callEvent(Event event) throws IllegalStateException {
		if (event.getHandlers().getRegisteredListeners().length > 0) {
			callEventSafe(event);
		}
	}

	private synchronized void callEventSafe(Event event) throws IllegalStateException {
		// Can not forward to callEvent(event), it checks for Bukkit-esque thread-safety
		try {
			fireEvent.invoke(manager, event);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("Unable to access SimplePluginManager.fireEvent(event)", e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException("Unable to call SimplePluginManager.fireEvent(event) with " + event, e);
		} catch (InvocationTargetException e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	public synchronized void clearPlugins() {
		manager.clearPlugins();
	}

	@Override
	public synchronized void disablePlugin(Plugin plugin) {
		manager.disablePlugin(plugin);
	}

	@Override
	public synchronized void disablePlugins() {
		manager.disablePlugins();
	}

	@Override
	public synchronized void enablePlugin(Plugin plugin) {
		manager.enablePlugin(plugin);
	}

	@Override
	public synchronized Set<Permissible> getDefaultPermSubscriptions(boolean op) {
		return manager.getDefaultPermSubscriptions(op);
	}

	@Override
	public synchronized Set<Permission> getDefaultPermissions(boolean op) {
		return manager.getDefaultPermissions(op);
	}

	@Override
	public synchronized Permission getPermission(String name) {
		return manager.getPermission(name);
	}

	@Override
	public synchronized Set<Permissible> getPermissionSubscriptions(String permission) {
		return manager.getPermissionSubscriptions(permission);
	}

	@Override
	public synchronized Set<Permission> getPermissions() {
		return manager.getPermissions();
	}

	@Override
	public synchronized Plugin getPlugin(String name) {
		return manager.getPlugin(name);
	}

	@Override
	public synchronized Plugin[] getPlugins() {
		return manager.getPlugins();
	}

	@Override
	public synchronized boolean isPluginEnabled(String name) {
		return manager.isPluginEnabled(name);
	}

	@Override
	public synchronized boolean isPluginEnabled(Plugin plugin) {
		return manager.isPluginEnabled(plugin);
	}

	@Override
	public synchronized Plugin loadPlugin(File file) throws InvalidPluginException, InvalidDescriptionException, UnknownDependencyException {
		return manager.loadPlugin(file);
	}

	@Override
	public synchronized Plugin[] loadPlugins(File file) {
		return manager.loadPlugins(file);
	}

	@Override
	public synchronized void recalculatePermissionDefaults(Permission perm) {
		manager.recalculatePermissionDefaults(perm);
	}

	@Override
	public synchronized void registerEvent(Class<? extends Event> event, Listener listener, EventPriority priority, EventExecutor executor, Plugin plugin) {
		manager.registerEvent(event, listener, priority, executor, plugin);
	}

	@Override
	public synchronized void registerEvent(Class<? extends Event> event, Listener listener, EventPriority priority, EventExecutor executor, Plugin plugin, boolean ignoreCancelled) {
		manager.registerEvent(event, listener, priority, executor, plugin, ignoreCancelled);
	}

	@Override
	public synchronized void registerEvents(Listener listener, Plugin plugin) {
		manager.registerEvents(listener, plugin);
	}

	@Override
	public synchronized void registerInterface(Class<? extends PluginLoader> loader) throws IllegalArgumentException {
		manager.registerInterface(loader);
	}

	@Override
	public synchronized void removePermission(Permission perm) {
		manager.removePermission(perm);
	}

	@Override
	public synchronized void removePermission(String perm) {
		manager.removePermission(perm);
	}

	@Override
	public synchronized void subscribeToDefaultPerms(boolean op, Permissible permissible) {
		manager.subscribeToDefaultPerms(op, permissible);
	}

	@Override
	public synchronized void subscribeToPermission(String permission, Permissible permissible) {
		manager.subscribeToPermission(permission, permissible);
	}

	@Override
	public synchronized void unsubscribeFromDefaultPerms(boolean op, Permissible permissible) {
		manager.unsubscribeFromDefaultPerms(op, permissible);
	}

	@Override
	public synchronized void unsubscribeFromPermission(String permission, Permissible permissible) {
		manager.unsubscribeFromPermission(permission, permissible);
	}

	@Override
	public synchronized boolean useTimings() {
		return manager.useTimings();
	}
}
