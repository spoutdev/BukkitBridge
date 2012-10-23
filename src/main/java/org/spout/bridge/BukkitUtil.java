package org.spout.bridge;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import org.spout.api.geo.discrete.Point;
import org.spout.api.geo.discrete.Transform;
import org.spout.api.inventory.ItemStack;
import org.spout.api.material.Material;
import org.spout.api.math.Vector3;

import org.spout.bridge.bukkit.BridgeWorld;
import org.spout.bridge.bukkit.inventory.BridgeItemStack;

import org.spout.vanilla.material.VanillaMaterial;
import org.spout.vanilla.material.VanillaMaterials;
import org.spout.vanilla.material.enchantment.ArmorEnchantment;
import org.spout.vanilla.material.enchantment.BowEnchantment;
import org.spout.vanilla.material.enchantment.Enchantments;
import org.spout.vanilla.material.enchantment.SwordEnchantment;
import org.spout.vanilla.material.enchantment.ToolEnchantment;

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
