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

import org.bukkit.entity.Ageable;
import org.spout.api.entity.Entity;

public abstract class BridgeAgeable extends BridgeCreature implements Ageable {
	protected BridgeAgeable(Entity handle) {
		super(handle);
	}

	@Override
	public int getAge() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setAge(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setAgeLock(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean getAgeLock() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBaby() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setAdult() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isAdult() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean canBreed() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBreed(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
