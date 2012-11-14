package org.spout.bridge;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import org.spout.api.geo.discrete.Point;
import org.spout.api.geo.discrete.Transform;
import org.spout.api.inventory.ItemStack;
import org.spout.api.material.Material;
import org.spout.api.material.block.BlockFace;
import org.spout.api.math.Vector3;

import org.spout.bridge.bukkit.BridgeServer;
import org.spout.bridge.bukkit.BridgeWorld;
import org.spout.bridge.bukkit.inventory.BridgeItemStack;

import org.spout.vanilla.material.VanillaMaterial;
import org.spout.vanilla.material.VanillaMaterials;
import org.spout.vanilla.material.enchantment.ArmorEnchantment;
import org.spout.vanilla.material.enchantment.BowEnchantment;
import org.spout.vanilla.material.enchantment.Enchantments;
import org.spout.vanilla.material.enchantment.SwordEnchantment;
import org.spout.vanilla.material.enchantment.ToolEnchantment;

/**
 * Various utilities for converting Bukkit --> Spout objects and vice versa
 */
public class BukkitUtil {
	private BukkitUtil() {
	}
	
	private static BridgeServer getServer() {
		return (BridgeServer) Bukkit.getServer();
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
	 * Creates a Bukkit block from a SpoutAPI block
	 *
	 * @param block The SpoutAPI block to convert to a Bukkit block
	 * @return The corresponding Bukkit block
	 */
	public static Block fromBlock(org.spout.api.geo.cuboid.Block block) {
		BridgeWorld world = getServer().getWorld(block.getWorld().getUID());
		return world.getBlockAt(block.getX(), block.getY(), block.getZ());
	}
	
	/**
	 * Creates a SpoutAPI block from a Bukkit block
	 *
	 * @param point The Bukkit block to convert to a SpoutAPI block
	 * @return The corresponding SpoutAPI block
	 */
	public static org.spout.api.geo.cuboid.Block toBlock(Block block) {
		Point point = toPoint(block.getLocation());
		return point.getWorld().getBlock(point);
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
		if (item == null){
			return null;
		}
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
		if (item == null){
			return null;
		}
		Material mat = VanillaMaterials.getMaterial((short) item.getTypeId());
		int data = item.getDurability();
		int amount = item.getAmount();
		return new ItemStack(mat, data, amount);
	}

	public static DamageCause getBukkitDamageCause(org.spout.vanilla.source.DamageCause damageCause) {
		// TODO: Vanilla doesn't have all the causes Bukkit does, not sure what to do about that
		switch (damageCause) {
			case ATTACK:
				return DamageCause.ENTITY_ATTACK;
			case FALL:
				return DamageCause.FALL;
			case DROWN:
				return DamageCause.DROWNING;
			case EXPLOSION:
				return DamageCause.BLOCK_EXPLOSION;
			case COMMAND:
				return DamageCause.CUSTOM;
			case FIREBALL:
				return DamageCause.ENTITY_EXPLOSION;
			case UNKNOWN:
				return DamageCause.CUSTOM;
			case WITHERED:
				return DamageCause.ENTITY_ATTACK;
			case CACTUS:
				return DamageCause.CONTACT;
			case BURN:
				return DamageCause.FIRE_TICK;
			case FIRE_SOURCE:
				return DamageCause.FIRE;
			case PROJECTILE:
				return DamageCause.PROJECTILE;
			case STARVATION:
				return DamageCause.STARVATION;
			case SUFFOCATION:
				return DamageCause.SUFFOCATION;
			case VOID:
				return DamageCause.VOID;
			default:
				return DamageCause.CUSTOM;
		}
	}

	public static org.bukkit.block.BlockFace toBukkitBlockFace(BlockFace face) {
		switch(face) {
			case TOP: return org.bukkit.block.BlockFace.UP;
			case BOTTOM: return org.bukkit.block.BlockFace.DOWN;
			case NORTH: return org.bukkit.block.BlockFace.NORTH;
			case SOUTH: return org.bukkit.block.BlockFace.SOUTH;
			case EAST: return org.bukkit.block.BlockFace.EAST;
			case WEST: return org.bukkit.block.BlockFace.WEST;
			case THIS: return org.bukkit.block.BlockFace.SELF;
			default: throw new IllegalArgumentException("Unknown face type");
		}
	}

	public static VanillaMaterial getVanillaMaterial(org.bukkit.inventory.ItemStack is) {
		return (VanillaMaterial) VanillaMaterials.getMaterial((short) is.getTypeId());
	}

	public static org.spout.vanilla.material.enchantment.Enchantment getVanillaEnchantment(Enchantment enchant) {
		return Enchantments.getById(enchant.getId());
	}

	public static EnchantmentTarget getEnchantmentTargetFromEnchantment(org.spout.vanilla.material.enchantment.Enchantment enchant) {
		if (enchant instanceof ArmorEnchantment) {
			return EnchantmentTarget.ARMOR;
		} else if (enchant instanceof SwordEnchantment) {
			return EnchantmentTarget.WEAPON;
		} else if (enchant instanceof BowEnchantment) {
			return EnchantmentTarget.BOW;
		} else if (enchant instanceof ToolEnchantment) {
			return EnchantmentTarget.TOOL;
		}

		return EnchantmentTarget.ALL;
	}
}
