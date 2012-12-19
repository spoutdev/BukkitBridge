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

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.spout.api.event.EventHandler;
import org.spout.api.event.server.plugin.PluginDisableEvent;
import org.spout.api.event.server.plugin.PluginEnableEvent;
import org.spout.api.event.server.service.ServiceRegisterEvent;
import org.spout.api.event.server.service.ServiceUnregisterEvent;
import org.spout.bridge.VanillaBridgePlugin;
import org.spout.bridge.bukkit.plugin.SpoutPlugin;

public class ServerListener extends AbstractListener {
	public ServerListener(VanillaBridgePlugin plugin) {
		super(plugin);
	}

	@EventHandler
	public void onMapInitialze(){
		//todo implement onMapInitialize
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPluginDisable(PluginDisableEvent event){
		Bukkit.getPluginManager().callEvent(new org.bukkit.event.server.PluginDisableEvent(new SpoutPlugin(event.getPlugin())));
	}

	@EventHandler
	public void onPluginEnable(PluginEnableEvent event){
		Bukkit.getPluginManager().callEvent(new org.bukkit.event.server.PluginEnableEvent(new SpoutPlugin(event.getPlugin())));
	}

	@EventHandler
	public void onRemoteServerCommand(){
		//todo implement onRemoteServerCommand
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onServerCommand(){
		//todo implement onServerCommand
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onServer(){
		//todo implement onServer
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onServerListPing(){
		//todo implement onServerListPing
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@EventHandler
	public void onServiceRegister(ServiceRegisterEvent event){
		Plugin plugin = new SpoutPlugin(event.getProvider().getPlugin());
		RegisteredServiceProvider<Object> provider = new RegisteredServiceProvider(Object.class, event.getProvider().getService(), fromPriority(event.getPriority()), plugin);
		Bukkit.getPluginManager().callEvent(new org.bukkit.event.server.ServiceRegisterEvent(provider));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@EventHandler
	public void onServiceUnregister(ServiceUnregisterEvent event){
		Plugin plugin = new SpoutPlugin(event.getProvider().getPlugin());
		RegisteredServiceProvider<Object> provider = new RegisteredServiceProvider(Object.class, event.getProvider().getService(), org.bukkit.plugin.ServicePriority.Normal , plugin);
		Bukkit.getPluginManager().callEvent(new org.bukkit.event.server.ServiceUnregisterEvent(provider));
	}

	private org.bukkit.plugin.ServicePriority fromPriority(org.spout.api.plugin.ServiceManager.ServicePriority priority) {
		switch(priority) {
			case High:
				return org.bukkit.plugin.ServicePriority.High;
			case Highest:
				return org.bukkit.plugin.ServicePriority.Highest;
			case Low:
				return org.bukkit.plugin.ServicePriority.Low;
			case Lowest:
				return org.bukkit.plugin.ServicePriority.Lowest;
			case Normal:
				return org.bukkit.plugin.ServicePriority.Normal;
			default:
				throw new IllegalArgumentException("Unknown priority: " + priority);
			
		}
	}
}
