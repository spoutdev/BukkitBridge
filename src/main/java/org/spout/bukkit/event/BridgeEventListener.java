package org.spout.bukkit.event;

import org.bukkit.Bukkit;
import org.spout.api.event.EventHandler;
import org.spout.api.event.Listener;
import org.spout.api.event.entity.EntitySpawnEvent;
import org.spout.api.event.entity.EntityTeleportEvent;
import org.spout.api.event.player.PlayerChatEvent;
import org.spout.api.event.player.PlayerJoinEvent;
import org.spout.api.event.player.PlayerKickEvent;
import org.spout.api.event.player.PlayerLeaveEvent;
import org.spout.api.event.player.PlayerLoginEvent;
import org.spout.api.event.player.PlayerPreLoginEvent;
import org.spout.vanilla.entity.LivingEntity;

public class BridgeEventListener implements Listener {
	
	@EventHandler
	public void onEntitySpawn(EntitySpawnEvent event) {
		if(!(event.getEntity().getController() instanceof LivingEntity)) return;
		org.spout.bukkit.event.entity.CreatureSpawnEvent handle = new org.spout.bukkit.event.entity.CreatureSpawnEvent(event);
		Bukkit.getServer().getPluginManager().callEvent(handle);
	}
	
	@EventHandler
	public void onPlayerLeave(PlayerLeaveEvent event) {
		if(event instanceof PlayerKickEvent) {
			org.spout.bukkit.event.player.PlayerKickEvent handle = new org.spout.bukkit.event.player.PlayerKickEvent((PlayerKickEvent) event);
			Bukkit.getServer().getPluginManager().callEvent(handle);
		}else{
			org.spout.bukkit.event.player.PlayerLeaveEvent handle = new org.spout.bukkit.event.player.PlayerLeaveEvent((PlayerLeaveEvent) event);
			Bukkit.getServer().getPluginManager().callEvent(handle);
		}
	}
	
	@EventHandler
	public void onPlayerChat(PlayerChatEvent event) {
		org.spout.bukkit.event.player.PlayerChatEvent handle = new org.spout.bukkit.event.player.PlayerChatEvent(event);
		Bukkit.getServer().getPluginManager().callEvent(handle);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		org.spout.bukkit.event.player.PlayerJoinEvent handle = new org.spout.bukkit.event.player.PlayerJoinEvent(event);
		Bukkit.getServer().getPluginManager().callEvent(handle);
	}
	
	@EventHandler
	public void onPlayerPreLogin(PlayerPreLoginEvent event) {
		org.spout.bukkit.event.player.PlayerPreLoginEvent handle = new org.spout.bukkit.event.player.PlayerPreLoginEvent(event);
		Bukkit.getServer().getPluginManager().callEvent(handle);
	}
	
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event) {
		org.spout.bukkit.event.player.PlayerLoginEvent handle = new org.spout.bukkit.event.player.PlayerLoginEvent(event);
		Bukkit.getServer().getPluginManager().callEvent(handle);
	}
	
	@EventHandler
	public void onEntityTeleport(EntityTeleportEvent event) {
		org.spout.bukkit.event.entity.EntityTeleportEvent handle = new org.spout.bukkit.event.entity.EntityTeleportEvent(event);
		Bukkit.getServer().getPluginManager().callEvent(handle);
	}
} 
