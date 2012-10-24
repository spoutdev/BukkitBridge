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

/**
 * Various utilities for converting Bukkit --> Spout objects and vice versa
 */
public class BukkitUtil {
	private BukkitUtil() {
	}

	/**
	 * Creates a Bukkit Location from a SpoutAPI Transform
	 *
	 * @param transform The SpoutAPI Transform to convert to a Location
	 * @return A Location with the same values as given Transform
	 */
	public static Location fromTransform(Transform transform) {
		Location loc = fromPoint(transform.getPosition());
		loc.setPitch(transform.getRotation().getPitch());
		loc.setYaw(transform.getRotation().getYaw());
		return loc;
	}

	/**
	 * Creates a Bukkit Location from a SpoutAPI Point
	 *
	 * @param point The SpoutAPI Point to convert to a Location
	 * @return A Location with the same values as given Point
	 */
	public static Location fromPoint(Point point) {
		String name = point.getWorld().getName();
		World world = Bukkit.getWorld(name);
		if (world == null) {
			throw new IllegalArgumentException("World '" + name + "' not found.");
		}
		return new Location(world, point.getX(), point.getY(), point.getZ());
	}

	/**
	 * Creates a SpoutAPI Point from a Bukkit Location
	 *
	 * @param loc The Bukkit Location to convert to a Point
	 * @return A SpoutAPI Point with the same values as given Location
	 */
	public static Point toPoint(Location loc) {
		return new Point(toVector3(loc), ((BridgeWorld) loc.getWorld()).getHandle());
	}

	/**
	 * Creates a SpoutAPI Vector3 from a Bukkit Location
	 *
	 * @param loc The Bukkit Location to convert to a Vector3
	 * @return A SpoutAPI Vector3 with the same values as given Bukkit Location
	 */
	public static Vector3 toVector3(Location loc) {
		return new Vector3(loc.getX(), loc.getY(), loc.getZ());
	}

	/**
	 * Creates a BridgeItemStack from a SpoutAPI ItemStack
	 *
	 * @param item The SpoutAPI ItemStack to convert to a BridgeItemStack
	 * @return The BridgeItemStack with the same values and type as given Spout ItemStack
	 */
	public static BridgeItemStack fromItemStack(ItemStack item) {
		Material material = item.getMaterial();
		org.bukkit.Material mat = null;
		if (material instanceof VanillaMaterial) {
			mat = org.bukkit.Material.getMaterial(((VanillaMaterial) material).getMinecraftId());
		} else {
			throw new IllegalArgumentException("Tried to create a BridgeItemStack with a non-vanilla Material.");
		}

		int amount = item.getAmount();
		byte data = (byte) item.getData();
		return new BridgeItemStack(mat, amount, data, data);
	}

	/**
	 * Creates a SpoutAPI ItemStack from a Bukkit ItemStack
	 *
	 * @param item The Bukkit ItemStack to convert to a SpoutAPI ItemStack
	 * @return The converted SpoutAPI ItemStack
	 */
	public static ItemStack toItemStack(org.bukkit.inventory.ItemStack item) {
		Material mat = VanillaMaterials.getMaterial((short) item.getTypeId());
		int data = item.getDurability();
		int amount = item.getAmount();
		return new ItemStack(mat, data, amount);
	}
}
