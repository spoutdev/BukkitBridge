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
package org.spout.bridge.bukkit.entity;

import org.spout.api.entity.Entity;
import org.spout.api.entity.Player;

import org.spout.vanilla.component.living.hostile.Zombie;

/**
 * Creates BridgeEntity and BridgePlayer objects upon request
 */
public final class EntityFactory {
	/**
	 * Creates a BridgeEntity from a SpoutAPI Entity. If the Entity is a Player,
	 * this method will return a BridgePlayer object instead of a plain
	 * BridgeEntity
	 * @param entity The SpoutAPI Entity to create a BridgeEntity from
	 * @return The BridgeEntity that represents the SpoutAPI Entity
	 */
	public static BridgeEntity createEntity(Entity entity) {
		if (entity instanceof Player) {
			return createPlayer((Player) entity);
		}
		if (entity.has(Zombie.class)) {
			return new BridgeZombie(entity);
		}
		return null;
	}

	/**
	 * Creates a BridgePlayer from a SpoutAPI Player
	 * @param player The SpoutAPI Player to create a BridgePlayer from
	 * @return The BridgePlayer that represents the SpoutAPI Player
	 */
	public static BridgePlayer createPlayer(Player player) {
		return new BridgePlayer(player);
	}
}
