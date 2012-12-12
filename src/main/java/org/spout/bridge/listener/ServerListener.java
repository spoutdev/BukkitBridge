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

import org.spout.api.event.EventHandler;
import org.spout.api.event.server.plugin.PluginDisableEvent;
import org.spout.api.event.server.plugin.PluginEnableEvent;
import org.spout.api.event.server.plugin.PluginEvent;
import org.spout.bridge.VanillaBridgePlugin;

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
        //todo implement onPluginDisable
        throw new UnsupportedOperationException();
    }

    @EventHandler
    public void onPluginEnable(PluginEnableEvent event){
        //todo implement onPluginEnable
        throw new UnsupportedOperationException();
    }

    @EventHandler
    public void onPlugin(PluginEvent event){
        //todo implement onPlugin
        throw new UnsupportedOperationException();
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

    @EventHandler
    public void onService(){
        //todo implement onService
        throw new UnsupportedOperationException();
    }

    @EventHandler
    public void onServiceRegister(){
        //todo implement onServiceRegister
        throw new UnsupportedOperationException();
    }

    @EventHandler
    public void onServiceUnregister(){
        //todo implement onServiceUnregister
        throw new UnsupportedOperationException();
    }

}
