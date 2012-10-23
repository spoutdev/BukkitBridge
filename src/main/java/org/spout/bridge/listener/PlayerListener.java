package org.spout.bridge.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.spout.api.event.EventHandler;
import org.spout.api.event.Order;
import org.spout.api.event.player.PlayerJoinEvent;
import org.spout.api.event.player.PlayerKickEvent;
import org.spout.api.event.player.PlayerLoginEvent;
import org.spout.bridge.VanillaBridgePlugin;
import org.spout.bridge.bukkit.entity.BridgePlayer;
import org.spout.bridge.bukkit.entity.EntityFactory;

public class PlayerListener extends AbstractListener{
	public PlayerListener(VanillaBridgePlugin plugin) {
		super(plugin);
	}

	@EventHandler(order = Order.EARLIEST)
	public void onPlayerLogin(PlayerLoginEvent event) {
		BridgePlayer player = EntityFactory.createPlayer(event.getPlayer());
		String hostname = event.getPlayer().getAddress().getHostName();
		org.bukkit.event.player.PlayerLoginEvent login = new org.bukkit.event.player.PlayerLoginEvent(player, hostname, event.getPlayer().getAddress());
		if (!event.isAllowed()) {
			login.disallow(Result.KICK_OTHER, event.getMessage().asString());
		}
		Bukkit.getPluginManager().callEvent(login);
		if (login.getResult() != Result.ALLOWED) {
			event.disallow(login.getKickMessage());
		}
	}

	@EventHandler(order = Order.EARLIEST)
	public void onPlayerJoin(PlayerJoinEvent event) {
		BridgePlayer player = EntityFactory.createPlayer(event.getPlayer());
		final String joinMessage = event.getMessage().asString();
		org.bukkit.event.player.PlayerJoinEvent join = new org.bukkit.event.player.PlayerJoinEvent(player, joinMessage);
		Bukkit.getPluginManager().callEvent(join);
		if (!joinMessage.equals(join.getJoinMessage())) {
			event.setMessage(join.getJoinMessage());
		}
	}

	@EventHandler(order = Order.EARLIEST)
	public void onPlayerKick(PlayerKickEvent event) {
		BridgePlayer player = EntityFactory.createPlayer(event.getPlayer());
		final String kickMessage = event.getKickReason().asString();
		final String leaveMessage = event.getMessage().asString();
		org.bukkit.event.player.PlayerKickEvent kick = new org.bukkit.event.player.PlayerKickEvent(player, kickMessage, leaveMessage);
		kick.setCancelled(event.isCancelled());
		Bukkit.getPluginManager().callEvent(kick);
		if (!kickMessage.equals(kick.getReason())) {
			event.setKickReason(kick.getReason());
		}
		if (!leaveMessage.equals(kick.getLeaveMessage())) {
			event.setMessage(kick.getLeaveMessage());
		}
		event.setCancelled(kick.isCancelled());
	}
}
