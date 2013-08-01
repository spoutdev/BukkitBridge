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

import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EnderDragonPart;
import org.bukkit.entity.EntityType;

import org.spout.api.entity.Entity;

public class BridgeEnderDragonPart extends BridgeComplexPart implements EnderDragonPart {
	protected BridgeEnderDragonPart(Entity handle) {
		super(handle);
	}

	public EnderDragon getParent() {
		return null;
	}

	@Override
	public EntityType getType() {
		return EntityType.ENDER_DRAGON;
	}

	@Override
	public void damage(double d) {
		throw new UnsupportedOperationException();
	}

    @Override
    public void _INVALID_damage(int i) {
        damage(i);
    }

    @Override
	public void damage(double d, org.bukkit.entity.Entity entity) {
		throw new UnsupportedOperationException();
	}

    @Override
    public void _INVALID_damage(int i, org.bukkit.entity.Entity entity) {
        damage(i, entity);
    }

    @Override
	public double getHealth() {
		throw new UnsupportedOperationException();
	}

    @Override
    public int _INVALID_getHealth() {
        return (int) getHealth();
    }

    @Override
	public void setHealth(double d) {
		throw new UnsupportedOperationException();
	}

    @Override
    public void _INVALID_setHealth(int i) {
        setHealth(i);
    }

    @Override
	public double getMaxHealth() {
        throw new UnsupportedOperationException();
	}

    @Override
    public int _INVALID_getMaxHealth() {
        return (int) getMaxHealth();
    }

    @Override
	public void setMaxHealth(double d) {
		throw new UnsupportedOperationException();
	}

    @Override
    public void _INVALID_setMaxHealth(int i) {
        setMaxHealth(i);
    }

    @Override
	public void resetMaxHealth() {
		throw new UnsupportedOperationException();
	}
}
