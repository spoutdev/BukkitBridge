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
import org.bukkit.event.block.BlockRedstoneEvent;
import org.spout.api.event.EventHandler;
import org.spout.bridge.BukkitUtil;
import org.spout.bridge.VanillaBridgePlugin;
import org.spout.vanilla.event.block.RedstoneChangeEvent;

public class BlockListener extends AbstractListener{
	public BlockListener(VanillaBridgePlugin plugin) {
		super(plugin);
	}

	@EventHandler
	public void onRedstoneChange(RedstoneChangeEvent event) {
		if (event.isCancelled()) {
			return;
		}

		BlockRedstoneEvent redstoneEvent = new BlockRedstoneEvent(BukkitUtil.fromBlock(event.getBlock()), event.getPreviousPower(), event.getNewPower());
		Bukkit.getPluginManager().callEvent(redstoneEvent);
		if (redstoneEvent.getNewCurrent() != event.getNewPower()) {
			event.setCancelled(true);
		}
	}
}
