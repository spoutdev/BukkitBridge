/*
 * This file is part of BukkitBridge.
 *
 * Copyright (c) 2012 Spout LLC <http://www.spout.org/>
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
package org.spout.bridge.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Snowman;
import org.bukkit.entity.Tameable;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityCombustByBlockEvent;
import org.bukkit.event.entity.EntityCombustByEntityEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import org.spout.api.entity.Entity;
import org.spout.api.event.EventHandler;
import org.spout.api.event.Order;
import org.spout.api.event.entity.EntityDespawnEvent;
import org.spout.api.event.entity.EntityEvent;
import org.spout.api.event.entity.EntitySpawnEvent;
import org.spout.api.event.entity.EntityTeleportEvent;
import org.spout.api.geo.cuboid.Block;

import org.spout.bridge.BukkitBridgePlugin;
import org.spout.bridge.BukkitUtil;
import org.spout.bridge.bukkit.entity.BridgeEntity;
import org.spout.bridge.bukkit.entity.BridgePlayer;
import org.spout.bridge.bukkit.entity.EntityFactory;

import org.spout.vanilla.component.entity.substance.Item;
import org.spout.vanilla.component.entity.substance.Lightning;
import org.spout.vanilla.component.entity.substance.Tnt;
import org.spout.vanilla.component.entity.substance.projectile.Potion;
import org.spout.vanilla.event.entity.EntityCombustEvent;
import org.spout.vanilla.event.entity.EntityDamageEvent;
import org.spout.vanilla.event.entity.EntityExplodeEvent;
import org.spout.vanilla.event.entity.EntityHealEvent;
import org.spout.vanilla.event.entity.EntityTameEvent;
import org.spout.vanilla.event.entity.EntityTargetEvent;
import org.spout.vanilla.event.entity.LivingSpawnEvent;
import org.spout.vanilla.event.entity.PotionSplashEvent;
import org.spout.vanilla.event.entity.ProjectileHitEvent;
import org.spout.vanilla.event.entity.SlimeSplitEvent;
import org.spout.vanilla.event.player.PlayerFoodSaturationChangeEvent;
import org.spout.vanilla.material.block.liquid.Lava;

public class EntityListener extends AbstractListener {
	public EntityListener(BukkitBridgePlugin plugin) {
		super(plugin);
	}

	@EventHandler
	public void onCreeperPower() {
		// TODO: Implement onCreeperPower
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntity(EntityEvent event) {
		// TODO: Implement onEntity
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityBreakDoor() {
		// TODO: Implement onEntityBreakDoor
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityChangeBlock() {
		// TODO: Implement onEntityChangeBlock
		throw new UnsupportedOperationException();
	}

	@EventHandler (order = Order.EARLIEST)
	public void onEntityCombust(EntityCombustEvent event) {
		BridgeEntity entity = EntityFactory.createEntity(event.getEntity());
		org.bukkit.event.entity.EntityCombustEvent bukkitEvent;

		if (event.getCombustCause().getSource() instanceof Entity) {
			bukkitEvent = new EntityCombustByEntityEvent(entity,
					EntityFactory.createEntity((Entity) event.getCombustCause().getSource()), event.getDuration());
		} else if (event.getCombustCause().getSource() instanceof Block) {
			bukkitEvent = new EntityCombustByBlockEvent(BukkitUtil.fromBlock((Block) event.getCombustCause().getSource()),
					entity, event.getDuration());
		} else {
			bukkitEvent = new org.bukkit.event.entity.EntityCombustEvent(entity, event.getDuration());
		}

		Bukkit.getPluginManager().callEvent(bukkitEvent);
		event.setCancelled(bukkitEvent.isCancelled());
		event.setDuration(bukkitEvent.getDuration());
	}

	@EventHandler
	public void onEntityCreatePortal() {
		// TODO: Implement onEntityCreatePortal
		throw new UnsupportedOperationException();
	}

	@EventHandler (order = Order.EARLIEST)
	public void onEntityDamage(EntityDamageEvent event) {
		// TODO: Poison and Melting (Snowman), Bukkit damage causes.
		BridgeEntity entity = EntityFactory.createEntity(event.getEntity());
		org.bukkit.event.entity.EntityDamageEvent bukkitEvent;

		Entity entityCause = null;
		Block blockCause = null;
		if (event.getDamageCause().getSource() instanceof Entity) {
			entityCause = (Entity) event.getDamageCause().getSource();
		} else if (event.getDamageCause().getSource() instanceof Block) {
			blockCause = (Block) event.getDamageCause().getSource();
		}

		DamageCause bukkitCause = null;
		if (entityCause != null) {
			switch (event.getDamageType()) {
				case ATTACK:
					bukkitCause = DamageCause.ENTITY_ATTACK;
				case EXPLOSION:
					bukkitCause = DamageCause.ENTITY_EXPLOSION;
					if (event.getDamager() instanceof Tnt) {
						bukkitCause = DamageCause.BLOCK_EXPLOSION;
					}
				case FIREBALL:
				case PROJECTILE:
					bukkitCause = DamageCause.PROJECTILE;
					if (event.getDamager() instanceof Potion) {
						bukkitCause = DamageCause.MAGIC;
					}
				default:
					bukkitCause = DamageCause.CUSTOM;
					if (event.getDamager() instanceof Lightning) {
						bukkitCause = DamageCause.LIGHTNING;
					}
			}
			bukkitEvent = new EntityDamageByEntityEvent(EntityFactory.createEntity(entityCause), entity, bukkitCause, event.getDamage());
		} else if (blockCause != null) {
			switch (event.getDamageType()) {
				case CACTUS:
					bukkitCause = DamageCause.CONTACT;
				case DROWN:
					bukkitCause = DamageCause.DROWNING;
				case EXPLOSION:
					bukkitCause = DamageCause.BLOCK_EXPLOSION;
				case FALL:
					bukkitCause = DamageCause.FALL;
				case FIRE_SOURCE:
					bukkitCause = DamageCause.FIRE;
					if (event.getDamager() instanceof Lava) {
						bukkitCause = DamageCause.LAVA;
					}
				case SUFFOCATION:
					bukkitCause = DamageCause.SUFFOCATION;
				default:
					bukkitCause = DamageCause.CUSTOM;
			}
			bukkitEvent = new EntityDamageByBlockEvent(BukkitUtil.fromBlock(blockCause), entity, bukkitCause, event.getDamage());
		} else {
			switch (event.getDamageType()) {
				case BURN:
					bukkitCause = DamageCause.FIRE_TICK;
				case STARVATION:
					bukkitCause = DamageCause.STARVATION;
				case VOID:
					bukkitCause = DamageCause.VOID;
				case WITHERED:
					// TODO: Withered has its own DamageCause in newer Bukkit builds.
					bukkitCause = DamageCause.ENTITY_ATTACK;
				case COMMAND:
				case UNKNOWN:
				default:
					bukkitCause = DamageCause.CUSTOM;
			}
			bukkitEvent = new org.bukkit.event.entity.EntityDamageEvent(entity, bukkitCause, event.getDamage());
		}

		Bukkit.getPluginManager().callEvent(bukkitEvent);
		event.setCancelled(bukkitEvent.isCancelled());
		event.setDamage((float) bukkitEvent.getDamage());
	}

	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
		// TODO: Implement onEntityDeath
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityDespawn(EntityDespawnEvent event) {
		if (event.getEntity().get(Item.class) != null) {
			onItemDespawn(event);
		}
	}

	@EventHandler
	public void onEntityExplode(EntityExplodeEvent event) {
		BridgeEntity entity = EntityFactory.createEntity(event.getEntity());
		org.bukkit.event.entity.EntityExplodeEvent bukkitEvent;

		ArrayList<org.bukkit.block.Block> bukkitBlocks = new ArrayList<org.bukkit.block.Block>();
		for (Block b : event.getBlocks()) {
			bukkitBlocks.add(BukkitUtil.fromBlock(b));
		}

		bukkitEvent = new org.bukkit.event.entity.EntityExplodeEvent(entity, BukkitUtil.fromPoint(event.getEpicenter()), bukkitBlocks, event.getYield());
		Bukkit.getPluginManager().callEvent(bukkitEvent);
		event.setCancelled(bukkitEvent.isCancelled());
		event.setYield(bukkitEvent.getYield());
	}

	@EventHandler (order = Order.EARLIEST)
	public void onEntityHeal(EntityHealEvent event) {
		BridgeEntity entity = EntityFactory.createEntity(event.getEntity());
		EntityRegainHealthEvent bukkitEvent;

		RegainReason bukkitCause = null;
		switch (event.getHealCause()) {
			case CONSUMABLE:
				bukkitCause = RegainReason.EATING;
			case ENDER_CRYSTAL:
				bukkitCause = RegainReason.ENDER_CRYSTAL;
			case MAGIC:
				bukkitCause = RegainReason.MAGIC;
			case MAGIC_REGEN:
				bukkitCause = RegainReason.MAGIC_REGEN;
			case REGENERATION:
				bukkitCause = RegainReason.REGEN;
			case SATIATED:
				bukkitCause = RegainReason.SATIATED;
			case WITHER_SPAWN:
				// TODO: Wither_Spawn is available in newer Bukkit builds.
			default:
				bukkitCause = RegainReason.CUSTOM;
		}
		bukkitEvent = new EntityRegainHealthEvent(entity, event.getHealAmount(), bukkitCause);
		Bukkit.getPluginManager().callEvent(bukkitEvent);
		event.setCancelled(bukkitEvent.isCancelled());
		event.setHealAmount((float) bukkitEvent.getAmount());
	}

	@EventHandler
	public void onEntityInteract() {
		// TODO: Implement onEntityInteract
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityPortalEnter() {
		// TODO: Implement onEntityPortalEnter
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityShootBow() {
		// TODO: Implement onEntityShootBow
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntitySpawn(EntitySpawnEvent event) {
		if (event instanceof LivingSpawnEvent) {
			onLivingSpawn((LivingSpawnEvent) event);
		}

		if (event.getEntity().get(Item.class) != null) {
			onItemSpawn(event);
		}
	}

	@EventHandler
	public void onEntityTame(EntityTameEvent event) {
		BridgeEntity entity = EntityFactory.createEntity(event.getEntity());
		BridgeEntity tamer = EntityFactory.createEntity(event.getOwner());

		org.bukkit.event.entity.EntityTameEvent bukkitEvent = new org.bukkit.event.entity.EntityTameEvent(
				(LivingEntity) entity, (org.bukkit.entity.AnimalTamer) tamer);

		Bukkit.getPluginManager().callEvent(bukkitEvent);
		event.setCancelled(bukkitEvent.isCancelled());
	}

	@EventHandler
	public void onEntityTarget(EntityTargetEvent event) {
		BridgeEntity entity = EntityFactory.createEntity(event.getEntity());
		BridgeEntity target = EntityFactory.createEntity(event.getTarget());
		org.bukkit.event.entity.EntityTargetEvent bukkitEvent;

		TargetReason bukkitCause = null;
		switch (event.getCause()) {
			case CLOSEST_PLAYER:
				bukkitCause = TargetReason.CLOSEST_PLAYER;
			case FORGOT_TARGET:
				bukkitCause = TargetReason.FORGOT_TARGET;
			case OWNER_ATTACKED:
				bukkitCause = TargetReason.OWNER_ATTACKED_TARGET;
			case PIG_ZOMBIE_MASSACRE:
				bukkitCause = TargetReason.PIG_ZOMBIE_TARGET;
			case RANDOM_TARGET:
				bukkitCause = TargetReason.RANDOM_TARGET;
			case TARGET_ATTACKED_ENTITY:
				bukkitCause = TargetReason.TARGET_ATTACKED_ENTITY;
				if (entity instanceof Tameable) {
					bukkitCause = TargetReason.TARGET_ATTACKED_OWNER;
				}
				if (entity instanceof IronGolem) {
					bukkitCause = TargetReason.DEFEND_VILLAGE;
				}
			case TARGET_DIED:
				bukkitCause = TargetReason.TARGET_DIED;
			case CUSTOM_TARGET:
			case CUSTOM_UNTARGET:
			default:
				bukkitCause = TargetReason.CUSTOM;
		}

		if (target instanceof LivingEntity) {
			bukkitEvent = new EntityTargetLivingEntityEvent(entity, (LivingEntity) target, bukkitCause);
		} else {
			bukkitEvent = new org.bukkit.event.entity.EntityTargetEvent(entity, target, bukkitCause);
		}

		Bukkit.getPluginManager().callEvent(bukkitEvent);
		event.setCancelled(bukkitEvent.isCancelled());
		event.setTarget(((BridgeEntity) bukkitEvent.getTarget()).getHandle());
	}

	@EventHandler (order = Order.EARLIEST)
	public void onEntityTeleport(EntityTeleportEvent event) {
		BridgeEntity entity = EntityFactory.createEntity(event.getEntity());
		Location from = BukkitUtil.fromPoint(event.getFrom());
		Location to = BukkitUtil.fromPoint(event.getTo());
		if (entity instanceof BridgePlayer) {
			PlayerTeleportEvent bukkitEvent = new PlayerTeleportEvent((BridgePlayer) entity, from, to);
			Bukkit.getPluginManager().callEvent(bukkitEvent);
			event.setCancelled(bukkitEvent.isCancelled());
			event.setTo(BukkitUtil.toPoint(bukkitEvent.getTo()));
		} else {
			org.bukkit.event.entity.EntityTeleportEvent bukkitEvent = new org.bukkit.event.entity.EntityTeleportEvent(entity, from, from);
			Bukkit.getPluginManager().callEvent(bukkitEvent);
			event.setCancelled(bukkitEvent.isCancelled());
			event.setTo(BukkitUtil.toPoint(bukkitEvent.getTo()));
		}
	}

	@EventHandler
	public void onExpBottle() {
		// TODO: Implement onExpBottle
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onExplosionPrime() {
		// TODO: Implement onExplosionPrime
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onFoodLevelChange(PlayerFoodSaturationChangeEvent event) {
		BridgePlayer player = EntityFactory.createPlayer(event.getPlayer());
		int foodLevel = (int) event.getFoodSaturation();
		org.bukkit.event.entity.FoodLevelChangeEvent foodLevelChange = new org.bukkit.event.entity.FoodLevelChangeEvent(player, foodLevel);
		foodLevelChange.setCancelled(event.isCancelled());
		Bukkit.getPluginManager().callEvent(foodLevelChange);
		event.setCancelled(foodLevelChange.isCancelled());
		event.setFoodSaturation(foodLevelChange.getFoodLevel());
	}

	public void onItemDespawn(EntityDespawnEvent event) {
		BridgeEntity entity = EntityFactory.createEntity(event.getEntity());
		ItemDespawnEvent bukkitEvent = new ItemDespawnEvent((org.bukkit.entity.Item) entity, entity.getLocation());
		Bukkit.getPluginManager().callEvent(bukkitEvent);
		event.setCancelled(bukkitEvent.isCancelled());
	}

	@EventHandler
	public void onItemSpawn(EntitySpawnEvent event) {
		BridgeEntity entity = EntityFactory.createEntity(event.getEntity());
		ItemSpawnEvent bukkitEvent = new ItemSpawnEvent((org.bukkit.entity.Item) entity, BukkitUtil.fromPoint(event.getPoint()));

		Bukkit.getPluginManager().callEvent(bukkitEvent);
		event.setCancelled(bukkitEvent.isCancelled());
	}

	public void onLivingSpawn(LivingSpawnEvent event) {
		BridgeEntity entity = EntityFactory.createEntity(event.getEntity());
		CreatureSpawnEvent bukkitEvent;

		SpawnReason bukkitCause;
		switch (event.getSpawnCause()) {
			case BIRTH:
				bukkitCause = SpawnReason.BREEDING;
			case BUILT:
				if (entity instanceof IronGolem) {
					bukkitCause = SpawnReason.BUILD_IRONGOLEM;
				} else if (entity instanceof Snowman) {
					bukkitCause = SpawnReason.BUILD_SNOWMAN;
				}
			case CHUNK_GENERATION:
				bukkitCause = SpawnReason.CHUNK_GEN;
			case CUSTOM:
				bukkitCause = SpawnReason.CUSTOM;
			case EGG:
				bukkitCause = SpawnReason.SPAWNER_EGG;
			case LIGHTNING:
				bukkitCause = SpawnReason.LIGHTNING;
			case NATURAL:
				bukkitCause = SpawnReason.NATURAL;
			case SPAWNER:
				bukkitCause = SpawnReason.SPAWNER;
			case SPLIT:
				bukkitCause = SpawnReason.SLIME_SPLIT;
			case VILLAGE:
				if (entity instanceof IronGolem) {
					bukkitCause = SpawnReason.VILLAGE_DEFENSE;
				} else {
					bukkitCause = SpawnReason.VILLAGE_INVASION;
				}
			case UNKNOWN:
			default:
				bukkitCause = SpawnReason.DEFAULT;
		}

		bukkitEvent = new CreatureSpawnEvent((LivingEntity) entity, bukkitCause);
		Bukkit.getPluginManager().callEvent(bukkitEvent);
		event.setCancelled(bukkitEvent.isCancelled());
	}

	@EventHandler
	public void onPigZap() {
		// TODO: Implement onPigZap
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerDeath() {
		// TODO: Implement onPlayerDeath
		throw new UnsupportedOperationException();
	}

	public void onPotionSplash(PotionSplashEvent event) {
		BridgeEntity entity = EntityFactory.createEntity(event.getEntity());
		org.bukkit.event.entity.PotionSplashEvent bukkitEvent;

		Map<LivingEntity, Double> bukkitMap = new HashMap<LivingEntity, Double>();
		for (Entity e : ((PotionSplashEvent) event).getAffectedEntities()) {
			bukkitMap.put((LivingEntity) EntityFactory.createEntity(e), ((PotionSplashEvent) event).getIntensityFor(e));
		}

		bukkitEvent = new org.bukkit.event.entity.PotionSplashEvent((ThrownPotion) entity, bukkitMap);
		event.setCancelled(bukkitEvent.isCancelled());
		for (LivingEntity e : bukkitEvent.getAffectedEntities()) {
			event.setIntensityFor(((BridgeEntity) e).getHandle(), bukkitEvent.getIntensity(e));
		}
	}

	@EventHandler
	public void onProjectileHit(ProjectileHitEvent event) {
		if (event instanceof PotionSplashEvent) {
			onPotionSplash((PotionSplashEvent) event);
			return;
		}

		BridgeEntity entity = EntityFactory.createEntity(event.getEntity());
		org.bukkit.event.entity.ProjectileHitEvent bukkitEvent = new org.bukkit.event.entity.ProjectileHitEvent((Projectile) entity);
		Bukkit.getPluginManager().callEvent(bukkitEvent);
	}

	@EventHandler
	public void onProjectileLaunch() {
		// TODO: Implement onProjectileLaunch
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onSheepDyeWool() {
		// TODO: Implement onSheepDyeWool
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onSheepRegrowWool() {
		// TODO: Implement onSheepRegrowWool
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onSlimeSplit(SlimeSplitEvent event) {
		BridgeEntity entity = EntityFactory.createEntity(event.getEntity());
		org.bukkit.event.entity.SlimeSplitEvent bukkitEvent = new org.bukkit.event.entity.SlimeSplitEvent((Slime) entity, event.getSize());
		Bukkit.getPluginManager().callEvent(bukkitEvent);
		event.setCancelled(bukkitEvent.isCancelled());
		event.setAmount(bukkitEvent.getCount());
	}
}
