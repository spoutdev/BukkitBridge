package org.spout.bridge.listener;

import org.spout.api.event.EventHandler;
import org.spout.api.event.Order;
import org.spout.api.event.entity.EntityTeleportEvent;

import org.spout.bridge.BukkitUtil;
import org.spout.bridge.VanillaBridgePlugin;
import org.spout.bridge.bukkit.entity.BridgeEntity;
import org.spout.bridge.bukkit.entity.BridgePlayer;
import org.spout.bridge.bukkit.entity.EntityFactory;

import org.spout.vanilla.event.entity.EntityDamageEvent;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class EntityListener extends AbstractListener {
	public EntityListener(VanillaBridgePlugin plugin) {
		super(plugin);
	}

	@EventHandler(order = Order.EARLIEST)
	public void onEntityDamage(EntityDamageEvent event) {
		BridgeEntity entity = EntityFactory.createEntity(event.getEntity());
		org.bukkit.event.entity.EntityDamageEvent bukkitEvent;
		switch (event.getDamageCause()) {
			case ATTACK:
				bukkitEvent = new EntityDamageByEntityEvent(EntityFactory.createEntity(event.getDamager()), entity, org.bukkit.event.entity.EntityDamageEvent.DamageCause.ENTITY_ATTACK, event.getDamage());
			case CACTUS:
				// TODO: There is currently no way to get the block (cactus) that damaged the entity from the vanilla event
				bukkitEvent = new EntityDamageByBlockEvent(/* Placeholder null value for above comment */null, entity, org.bukkit.event.entity.EntityDamageEvent.DamageCause.CONTACT, event.getDamage());
			default:
				bukkitEvent = new org.bukkit.event.entity.EntityDamageEvent(entity, BukkitUtil.getBukkitDamageCause(event.getDamageCause()), event.getDamage());
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
}
