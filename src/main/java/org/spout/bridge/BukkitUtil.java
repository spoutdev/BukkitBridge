package org.spout.bridge;

import org.bukkit.Location;

import org.spout.api.geo.discrete.Point;
import org.spout.api.math.Vector3;

import org.spout.bridge.bukkit.BridgeWorld;

public class BukkitUtil {
	private BukkitUtil() {
	}

	public static Point pointFromLocation(Location loc) {
		return new Point(vector3FromLocation(loc), ((BridgeWorld) loc.getWorld()).getHandle());
	}

	public static Vector3 vector3FromLocation(Location loc) {
		return new Vector3(loc.getX(), loc.getY(), loc.getZ());
	}
}
