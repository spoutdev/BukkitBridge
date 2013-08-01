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

import org.bukkit.DyeColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;

import org.spout.api.entity.Entity;

public class BridgeSheep extends BridgeAnimals implements Sheep {
	protected BridgeSheep(Entity handle) {
		super(handle);
	}

	@Override
	public boolean isSheared() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setSheared(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public DyeColor getColor() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setColor(DyeColor dyeColor) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public EntityType getType() {
		return EntityType.SHEEP;
	}
}
