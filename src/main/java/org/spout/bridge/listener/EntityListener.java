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
package org.spout.bridge.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.spout.api.entity.Entity;
import org.spout.api.event.EventHandler;
import org.spout.api.event.Order;
import org.spout.api.event.entity.EntityEvent;
import org.spout.api.event.entity.EntityTeleportEvent;
import org.spout.api.geo.cuboid.Block;
import org.spout.bridge.BukkitUtil;
import org.spout.bridge.VanillaBridgePlugin;
import org.spout.bridge.bukkit.entity.BridgeEntity;
import org.spout.bridge.bukkit.entity.BridgePlayer;
import org.spout.bridge.bukkit.entity.EntityFactory;
import org.spout.vanilla.component.substance.Lightning;
import org.spout.vanilla.component.substance.Potion;
import org.spout.vanilla.component.substance.object.Tnt;
import org.spout.vanilla.event.entity.EntityDamageEvent;
import org.spout.vanilla.event.entity.EntityHealEvent;
import org.spout.vanilla.event.entity.EntityTameEvent;
import org.spout.vanilla.event.entity.EntityTargetEvent;
import org.spout.vanilla.event.player.PlayerFoodSaturationChangeEvent;
import org.spout.vanilla.material.block.liquid.Lava;

public class EntityListener extends AbstractListener {
	public EntityListener(VanillaBridgePlugin plugin) {
		super(plugin);
	}
	
	@EventHandler(order = Order.EARLIEST)
	public void onEntityHeal(EntityHealEvent event) {
		BridgeEntity entity = EntityFactory.createEntity(event.getEntity());
		EntityRegainHealthEvent bukkitEvent;
		
		RegainReason bukkitCause = null;
		switch(event.getHealCause()) {
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
				// TODO: Wither_Spawn is available in newer Bukkit Builds.
			default:
				bukkitCause = RegainReason.CUSTOM;
		}
		bukkitEvent = new EntityRegainHealthEvent(entity, event.getHealAmount(), bukkitCause);
		Bukkit.getPluginManager().callEvent(bukkitEvent);
		event.setCancelled(bukkitEvent.isCancelled());
		event.setHealAmount(bukkitEvent.getAmount());
	}
	
	@EventHandler(order = Order.EARLIEST)
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
			switch (event.getDamageCause().getType()) {
				case ATTACK:
					bukkitCause = DamageCause.ENTITY_ATTACK;
				case EXPLOSION:
					bukkitCause = DamageCause.ENTITY_EXPLOSION;
					if (event.getDamager() instanceof Tnt)
						bukkitCause = DamageCause.BLOCK_EXPLOSION;
				case FIREBALL:
				case PROJECTILE:
					bukkitCause = DamageCause.PROJECTILE;
					if (event.getDamager() instanceof Potion)
						bukkitCause = DamageCause.MAGIC;
				default:
					bukkitCause = DamageCause.CUSTOM;
					if (event.getDamager() instanceof Lightning)
						bukkitCause = DamageCause.LIGHTNING;
			}
			bukkitEvent = new EntityDamageByEntityEvent(EntityFactory.createEntity(entityCause), entity, bukkitCause, event.getDamage());
		} else if (blockCause != null) {
			switch (event.getDamageCause().getType()) {
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
					if (event.getDamager() instanceof Lava)
						bukkitCause = DamageCause.LAVA;
				case SUFFOCATION:
					bukkitCause = DamageCause.SUFFOCATION;
				default:
					bukkitCause = DamageCause.CUSTOM;
			}
			bukkitEvent = new EntityDamageByBlockEvent(BukkitUtil.fromBlock(blockCause), entity, bukkitCause, event.getDamage());
		} else {
			switch (event.getDamageCause().getType()) {
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
		event.setDamage(bukkitEvent.getDamage());
	}

	@EventHandler(order = Order.EARLIEST)
	public void onEntityTeleport(EntityTeleportEvent event) {
		BridgeEntity entity = EntityFactory.createEntity(event.getEntity());
		Location from = BukkitUtil.fromPoint(event.getFrom());
		Location to = BukkitUtil.fromPoint(event.getTo());
		if (entity instanceof BridgePlayer) {
			PlayerTeleportEvent bukkitEvent = new PlayerTeleportEvent((BridgePlayer)entity, from, to);
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
	public void onCreatureSpawn(){
		//todo implement onCreatureSpawn
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onCreeperPower(){
		//todo implement onCreeperPower
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityBreakDoor(){
		//todo implement onEntityBreakDoor
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityChangeBlock(){
		//todo implement onEntityChangeBlock
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityCombustByBlock(){
		//todo implement onEntityCombustByBlock
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityCombustByEntity(){
		//todo implement onEntityCombustByEntity
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityCombust(){
		//todo implement onEntityCombust
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityCreatePortal(){
		//todo implement onEntityCreatePortal
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityDamageByBlock(){
		//todo implement onEntityDamageByBlock
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityDamageByEntity(){
		//todo implement onEntityDamageByEntity
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityDeath(EntityDeathEvent event){
		//todo implement onEntityDeath
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntity(EntityEvent event){
		//todo implement onEntity
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityExplode(){
		//todo implement onEntityExplode
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityInteract(){
		//todo implement onEntityInteract
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityPortalEnter(){
		//todo implement onEntityPortalEnter
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityRegainHealth(){
		//todo implement onEntityRegainHealth
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityShootBow(){
		//todo implement onEntityShootBow
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityTame(EntityTameEvent event){
		//todo implement onEntityTame
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityTarget(EntityTargetEvent event){
		//todo implement onEntityTarget
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onEntityTargetLivingEntity(){
		//todo implement onEntityTargetLivingEntity
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onExpBottle(){
		//todo implement onExpBottle
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onExplosionPrime(){
		//todo implement onExplosionPrime
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onFoodLevelChange(PlayerFoodSaturationChangeEvent event){
		BridgePlayer player = EntityFactory.createPlayer(event.getPlayer());
		int foodLevel = (int) event.getFoodSaturation();
		org.bukkit.event.entity.FoodLevelChangeEvent foodLevelChange = new org.bukkit.event.entity.FoodLevelChangeEvent(player, foodLevel);
		foodLevelChange.setCancelled(event.isCancelled());
		Bukkit.getPluginManager().callEvent(foodLevelChange);
		event.setCancelled(foodLevelChange.isCancelled());
		event.setFoodSaturation(foodLevelChange.getFoodLevel());
	}

	@EventHandler
	public void onItemDespawn(){
		//todo implement onItemDespawn
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onItemSpawn(){
		//todo implement onItemSpawn
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPigZap(){
		//todo implement onPigZap
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPlayerDeath(){
		//todo implement onPlayerDeath
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPotionSplash(){
		//todo implement onPotionSplash
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onProjectileHit(){
		//todo implement onProjectileHit
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onProjectileLaunch(){
		//todo implement onProjectileLaunch
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onSheepDyeWool(){
		//todo implement onSheepDyeWool
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onSheepRegrowWool(){
		//todo implement onSheepRegrowWool
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onSlimeSplit(){
		//todo implement onSlimeSplit
		throw new UnsupportedOperationException();
	}
}


