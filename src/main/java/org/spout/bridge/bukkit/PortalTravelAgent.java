package org.spout.bridge.bukkit;

import org.bukkit.Location;
import org.bukkit.TravelAgent;

import org.spout.api.Spout;
import org.spout.api.geo.World;

import org.spout.bridge.BukkitUtil;
import org.spout.bridge.VanillaBridgePlugin;

import org.spout.vanilla.material.VanillaMaterials;

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
					if (VanillaMaterials.PORTAL.createPortal(Spout.getEngine().getWorld(location.getWorld().getName()).getBlock(x, y, z, VanillaBridgePlugin.getInstance()))) {
						return new Location(location.getWorld(), x, y, z);
					}
				}
			}
		}

		return null;
	}

	@Override
	public Location findPortal(Location location) {
		String name = location.getWorld().getName();
		World world = Spout.getEngine().getWorld(name);
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
					if (world.getBlock(x, y, z, VanillaBridgePlugin.getInstance()).getMaterial() == VanillaMaterials.PORTAL) {
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
		World world = Spout.getEngine().getWorld(name);
		if (world == null) {
			throw new IllegalArgumentException("World '" + name + "' not found.");
		}
		return VanillaMaterials.PORTAL.createPortal(world.getBlock(BukkitUtil.toVector3(location), VanillaBridgePlugin.getInstance()));
	}
}
