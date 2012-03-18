package org.spout.bukkit;

import org.bukkit.Location;
import org.spout.api.geo.discrete.Point;

public class BridgeLocation {
	/**
	 * Convert a point to a bukkit location
	 * @param point The spout point
	 * @return
	 */
	public static Location getLocation(Point point) {
		return new Location(new BridgeWorld(point.getWorld()), point.getX(), point.getY(), point.getZ());
	}

	/**
	 * Converts a bukkit location to a point
	 * @param to The bukkit location
	 * @return
	 */
	public static Point getPoint(Location to) {
		return new Point(((BridgeWorld) to.getWorld()).getHandle(), (float) to.getX(), (float) to.getY(), (float) to.getZ());
	}
}
