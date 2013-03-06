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
package org.spout.bridge.bukkit;

import org.bukkit.Location;
import org.bukkit.TravelAgent;

import org.spout.api.geo.World;

import org.spout.bridge.VanillaBridgePlugin;
import org.spout.vanilla.material.VanillaMaterials;
import org.spout.vanilla.world.generator.object.VanillaObjects;

public class PortalTravelAgent implements TravelAgent {
	private int searchRadius = 20, creationRadius = 20;
	private boolean createPortal = true;

	@Override
	public TravelAgent setSearchRadius(int searchRadius) {
		this.searchRadius = searchRadius;
		return this;
	}

	@Override
	public int getSearchRadius() {
		return searchRadius;
	}

	@Override
	public TravelAgent setCreationRadius(int creationRadius) {
		this.creationRadius = creationRadius;
		return this;
	}

	@Override
	public int getCreationRadius() {
		return creationRadius;
	}

	@Override
	public boolean getCanCreatePortal() {
		return createPortal;
	}

	@Override
	public void setCanCreatePortal(boolean createPortal) {
		this.createPortal = createPortal;
	}

	@Override
	public Location findOrCreate(Location location) {
		Location searchResult = findPortal(location);
		if (searchResult != null) {
			return searchResult;
		}

		final int centerX = location.getBlockX();
		final int centerY = location.getBlockY();
		final int centerZ = location.getBlockZ();

		// Create portal
		for (int x = centerX; x < creationRadius; x++) {
			for (int y = centerY; y < creationRadius; y++) {
				for (int z = centerZ; z < creationRadius; z++) {
					Location loc = new Location(location.getWorld(), x, y, z);
					if (createPortal(loc)) {
						return loc;
					}
				}
			}
		}

		return null;
	}

	@Override
	public Location findPortal(Location location) {
		String name = location.getWorld().getName();
		World world = VanillaBridgePlugin.getInstance().getEngine().getWorld(name);
		if (world == null) {
			throw new IllegalArgumentException("World '" + name + "' not found.");
		}

		final int centerX = location.getBlockX();
		final int centerY = location.getBlockY();
		final int centerZ = location.getBlockZ();

		// Look for portal
		for (int x = centerX; x < searchRadius; x++) {
			for (int y = centerY; y < searchRadius; y++) {
				for (int z = centerZ; z < searchRadius; z++) {
					if (world.getBlock(x, y, z).getMaterial() == VanillaMaterials.PORTAL) {
						return new Location(location.getWorld(), x, y, z);
					}
				}
			}
		}

		return null;
	}

	@Override
	public boolean createPortal(Location location) {
		String name = location.getWorld().getName();
		World world = VanillaBridgePlugin.getInstance().getEngine().getWorld(name); //TODO Bad design again, figure out a better way to do these.
		if (world == null) {
			throw new IllegalArgumentException("World '" + name + "' not found.");
		}
		final int x = location.getBlockX();
		final int y = location.getBlockY();
		final int z = location.getBlockZ();
		if (VanillaObjects.NETHER_PORTAL.canPlaceObject(world, x, y, z)) {
			VanillaObjects.NETHER_PORTAL.placeObject(world, x, y, z, true);
			return true;
		}
		return false;
	}
}
