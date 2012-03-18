package org.spout.bukkit.event.player;

import org.bukkit.entity.Player;
import org.spout.bukkit.entity.BridgePlayer;

public class PlayerJoinEvent extends org.bukkit.event.player.PlayerJoinEvent {
	private org.spout.api.event.player.PlayerJoinEvent spoutEvent;
	
	private PlayerJoinEvent(Player playerJoined, String joinMessage) {
		super(playerJoined, joinMessage);
	}
	
	/**
	 * Wrapper Spout -> Bukkit
	 * @param event
	 */
	public PlayerJoinEvent(org.spout.api.event.player.PlayerJoinEvent event) {
		super(new BridgePlayer(event.getPlayer()), event.getMessage());
		spoutEvent = event;
	}
	
	@Override
	public void setJoinMessage(String joinMessage) {
        super.setJoinMessage(joinMessage);
        spoutEvent.setMessage(joinMessage);
    }
}
