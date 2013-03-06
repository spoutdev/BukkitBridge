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
package org.spout.bridge.player;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

import org.spout.api.component.type.EntityComponent;
import org.spout.api.geo.discrete.Transform;

import org.spout.bridge.BukkitUtil;
import org.spout.bridge.bukkit.entity.EntityFactory;

public class PlayerMoveComponent extends EntityComponent {
	private Transform prev;
	private Player player;

	@Override
	public void onAttached() {
		player = EntityFactory.createPlayer((org.spout.api.entity.Player) getOwner());
	}

	@Override
	public boolean canTick() {
		return true;
	}

	@Override
	public void onTick(float dt) {
		if (prev != null && !prev.equals(getOwner().getScene().getTransform())) {
			Location from = BukkitUtil.fromTransform(prev);
			Location to = BukkitUtil.fromTransform(getOwner().getScene().getTransform());
			PlayerMoveEvent event = new PlayerMoveEvent(player, from, to);
			Bukkit.getPluginManager().callEvent(event);
			if (event.isCancelled()) {
				getOwner().getScene().setTransform(prev);
			} else if (!event.getTo().equals(to)) {
				getOwner().getScene().setPosition(BukkitUtil.toPoint(to));
			}
		}

		prev = getOwner().getScene().getTransform();
	}
}
