package org.spout.bukkit.event.player;

import org.bukkit.entity.Player;
import org.spout.bukkit.entity.BridgePlayer;

public class PlayerLoginEvent extends org.bukkit.event.player.PlayerLoginEvent {
	private org.spout.api.event.player.PlayerLoginEvent spoutEvent;
	
	//TODO: Implement hostname stuff
	private PlayerLoginEvent(Player player) {
		super(player);
	}
	
	/**
	 * Wrapper Spout -> Bukkit
	 * @param event
	 */
	public PlayerLoginEvent(org.spout.api.event.player.PlayerLoginEvent event) {
		super(new BridgePlayer(event.getPlayer()));
		spoutEvent = event;
	}
	
	@Override
	public void setKickMessage(final String message) {
        super.setKickMessage(message);
        spoutEvent.setMessage(message);
    }

	public void setResult(final Result result) {
        super.setResult(result);
        if(result == Result.ALLOWED) {
        	spoutEvent.setAllowed(true);
        }else{
        	spoutEvent.setAllowed(false);
        }
    }
}
