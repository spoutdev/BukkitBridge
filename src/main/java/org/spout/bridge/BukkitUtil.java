package org.spout.bridge;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import org.spout.api.geo.discrete.Point;
import org.spout.api.geo.discrete.Transform;
import org.spout.api.inventory.ItemStack;
import org.spout.api.material.Material;
import org.spout.api.math.Vector3;

import org.spout.bridge.bukkit.BridgeWorld;
import org.spout.bridge.bukkit.inventory.BridgeItemStack;

import org.spout.vanilla.material.VanillaMaterial;
import org.spout.vanilla.material.VanillaMaterials;

public class BukkitUtil {
	private BukkitUtil() {
	}

	public static Location fromTransform(Transform transform) {
		Location loc = fromPoint(transform.getPosition());
		loc.setPitch(transform.getRotation().getPitch());
		loc.setYaw(transform.getRotation().getYaw());
		return loc;
	}

	public static Location fromPoint(Point point) {
		String name = point.getWorld().getName();
		World world = Bukkit.getWorld(name);
		if (world == null) {
			throw new IllegalArgumentException("World '" + name + "' not found.");
		}
		return new Location(world, point.getX(), point.getY(), point.getZ());
	}

	public static Point toPoint(Location loc) {
		return new Point(toVector3(loc), ((BridgeWorld) loc.getWorld()).getHandle());
	}

	public static Vector3 toVector3(Location loc) {
		return new Vector3(loc.getX(), loc.getY(), loc.getZ());
	}

	public static BridgeItemStack fromItemStack(ItemStack item) {
		Material material = item.getMaterial();
		org.bukkit.Material mat = null;
		if (material instanceof VanillaMaterial) {
			mat = org.bukkit.Material.getMaterial(((VanillaMaterial) material).getMinecraftId());
		}

		if (mat == null) {
			throw new IllegalArgumentException("Tried to create a BridgeItemStack with a non-vanilla Material.");
		}

		int amount = item.getAmount();
		byte data = (byte) item.getData();
		return new BridgeItemStack(mat, amount, data, data);
	}

	public static ItemStack toItemStack(org.bukkit.inventory.ItemStack item) {
		Material mat = VanillaMaterials.getMaterial((short) item.getTypeId());
		int data = item.getDurability();
		int amount = item.getAmount();
		return new ItemStack(mat, data, amount);
	}
}
