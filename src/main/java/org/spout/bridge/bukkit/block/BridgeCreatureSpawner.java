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
package org.spout.bridge.bukkit.block;

import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;

@SuppressWarnings("deprecation")
public class BridgeCreatureSpawner extends BridgeBlockState implements CreatureSpawner {
	public BridgeCreatureSpawner(Block b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CreatureType getCreatureType() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EntityType getSpawnedType() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setSpawnedType(EntityType paramEntityType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setCreatureType(CreatureType paramCreatureType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getCreatureTypeId() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setCreatureTypeByName(String paramString) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getCreatureTypeName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setCreatureTypeId(String paramString) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getDelay() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setDelay(int paramInt) {
		throw new UnsupportedOperationException();
	}
}
