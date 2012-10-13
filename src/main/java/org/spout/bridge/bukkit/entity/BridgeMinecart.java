/*
 * This file is part of Vanilla.
 *
 * Copyright (c) 2011-2012, VanillaDev <http://www.spout.org/>
 * Vanilla is licensed under the SpoutDev License Version 1.
 *
 * Vanilla is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * Vanilla is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.Minecart;
import org.bukkit.util.Vector;

public class BridgeMinecart extends BridgeVehicle implements Minecart {
	@Override
	public void setDamage(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getDamage() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public double getMaxSpeed() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setMaxSpeed(double v) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isSlowWhenEmpty() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setSlowWhenEmpty(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Vector getFlyingVelocityMod() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setFlyingVelocityMod(Vector vector) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Vector getDerailedVelocityMod() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setDerailedVelocityMod(Vector vector) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
