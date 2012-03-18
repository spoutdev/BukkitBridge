package org.spout.bukkit.event.player;

import java.net.InetAddress;

public class PlayerPreLoginEvent extends org.bukkit.event.player.PlayerPreLoginEvent {
	private org.spout.api.event.player.PlayerPreLoginEvent spoutEvent;
	
	private PlayerPreLoginEvent(String name, InetAddress ipAddress) {
		super(name, ipAddress);	
	}

	/**
	 * Wrapper Spout -> Bukkit
	 * TODO: Implement this kicking stuff
	 * @param event
	 */
	public PlayerPreLoginEvent(org.spout.api.event.player.PlayerPreLoginEvent event) {
		super(event.getName(), event.getAddress());
		spoutEvent = event;
	}
}
