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

import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;

import org.spout.api.entity.Entity;

public class BridgeTNTPrimed extends BridgeEntity implements TNTPrimed {
	protected BridgeTNTPrimed(Entity handle) {
		super(handle);
	}

	@Override
	public void setFuseTicks(int i) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getFuseTicks() {
		throw new UnsupportedOperationException();
	}

	@Override
	public org.bukkit.entity.Entity getSource() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setYield(float v) {
		throw new UnsupportedOperationException();
	}

	@Override
	public float getYield() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsIncendiary(boolean b) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isIncendiary() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EntityType getType() {
		return EntityType.PRIMED_TNT;
	}
}
