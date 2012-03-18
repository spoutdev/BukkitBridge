package org.spout.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;
import org.spout.bukkit.entity.BridgePlayer;

public class PlayerLeaveEvent extends PlayerQuitEvent {
	private org.spout.api.event.player.PlayerLeaveEvent spoutEvent;
	
	private PlayerLeaveEvent(Player who, String quitMessage) {
		super(who, quitMessage);
	}
	
	/**
	 * Wrapper Spout -> Bukkit
	 * @param event
	 */
	public PlayerLeaveEvent(org.spout.api.event.player.PlayerLeaveEvent event) {
		super(new BridgePlayer(event.getPlayer()), event.getMessage());
		this.spoutEvent = event;
	}
	
	@Override
	public void setQuitMessage(String quitMessage) {
        super.setQuitMessage(quitMessage);
        spoutEvent.setMessage(quitMessage);
    }
}
