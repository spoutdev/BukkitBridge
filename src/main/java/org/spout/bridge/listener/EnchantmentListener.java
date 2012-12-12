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
import org.bukkit.Location;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.spout.api.event.EventHandler;
import org.spout.api.event.Order;
import org.spout.api.event.entity.EntityTeleportEvent;
import org.spout.bridge.BukkitUtil;
import org.spout.bridge.VanillaBridgePlugin;
import org.spout.bridge.bukkit.entity.BridgeEntity;
import org.spout.bridge.bukkit.entity.BridgePlayer;
import org.spout.bridge.bukkit.entity.EntityFactory;
import org.spout.vanilla.event.entity.EntityDamageEvent;

public class EnchantmentListener extends AbstractListener {
	public EnchantmentListener(VanillaBridgePlugin plugin) {
		super(plugin);
	}

    @EventHandler
    public void onEnchantItem(){
        //todo implement onEnchantItem
        throw new UnsupportedOperationException();
    }

    @EventHandler
    public void onPrepareItemEnchant(){
        //todo implement onPrepareItemEnchant
        throw new UnsupportedOperationException();
    }

}
