package org.spout.bukkit.event.player;

import org.bukkit.entity.Player;
import org.spout.bukkit.entity.BridgePlayer;

public class PlayerChatEvent extends org.bukkit.event.player.PlayerChatEvent {
	private org.spout.api.event.player.PlayerChatEvent spoutEvent;
	
	private PlayerChatEvent(Player player, String message) {
		super(player, message);
	}

	/**
	 * Wrapper Spout -> Bukkit
	 * @param event
	 */
	public PlayerChatEvent(org.spout.api.event.player.PlayerChatEvent event) {
		super(new BridgePlayer(event.getPlayer()), event.getMessage());
		this.spoutEvent = event;
	}
	
	@Override
	public void setCancelled(boolean cancel) {
        super.setCancelled(true);
        spoutEvent.setCancelled(cancel);
    }
	
	@Override
	public void setMessage(String message) {
        super.setMessage(message);
        spoutEvent.setMessage(message);
    }
	
	@Override
	public void setPlayer(final Player player) {
        super.setPlayer(player);
        //TODO: Implement into API
    }
	
	@Override
	public void setFormat(final String format) {
		super.setFormat(format);
		spoutEvent.setFormat(format);
	}
}
