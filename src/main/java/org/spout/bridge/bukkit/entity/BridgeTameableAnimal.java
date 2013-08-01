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
package org.spout.bridge.bukkit.entity;

import org.bukkit.Bukkit;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Tameable;

import org.spout.api.entity.Entity;

import org.spout.vanilla.data.VanillaData;

public abstract class BridgeTameableAnimal extends BridgeAnimals implements Tameable, Creature {
	protected BridgeTameableAnimal(Entity handle) {
		super(handle);
	}

	@Override
	public boolean isTamed() {
		return getHandle().getData().get(VanillaData.TAMED);
	}

	@Override
	public void setTamed(boolean b) {
		getHandle().getData().put(VanillaData.TAMED, b);
	}

	@Override
	public AnimalTamer getOwner() {
		return Bukkit.getPlayer(getHandle().getData().get(VanillaData.OWNER));
	}

	@Override
	public void setOwner(AnimalTamer animalTamer) {
		getHandle().getData().put(VanillaData.OWNER, animalTamer.getName());
	}
}
