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
package org.spout.bukkit;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import org.spout.api.geo.discrete.Point;
import org.spout.api.geo.discrete.Transform;
import org.spout.api.math.Quaternion;
import org.spout.api.math.Vector3;

public class BridgeUtil {
	public static Location toLocation(Point p) {
		return new Location(new BridgeWorld(p.getWorld()), p.getX(), p.getY(), p.getZ());
	}

	public static Location toLocation(Transform t) {
		return toLocation(t.getPosition(), t.getRotation());
	}

	public static Location toLocation(Point p, Quaternion q) {
		return new Location(new BridgeWorld(p.getWorld()), p.getX(), p.getY(), p.getZ(), q.getYaw(), q.getPitch());
	}

	public static Point toPoint(Location loc) {
		return new Point(((BridgeWorld) loc.getWorld()).getSpoutWorld(), (float) loc.getX(), (float) loc.getY(), (float) loc.getZ());
	}

	public static Vector3 toVector(Vector vec) {
		return new Vector3(vec.getX(), vec.getY(), vec.getZ());
	}

	public static Vector toVector(Vector3 vec) {
		return new Vector(vec.getX(), vec.getY(), vec.getZ());
	}
}
