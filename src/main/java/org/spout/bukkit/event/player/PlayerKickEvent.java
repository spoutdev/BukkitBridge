package org.spout.bukkit.event.player;

import org.bukkit.entity.Player;
import org.spout.bukkit.entity.BridgePlayer;

public class PlayerKickEvent extends org.bukkit.event.player.PlayerKickEvent {
	private org.spout.api.event.player.PlayerKickEvent spoutEvent;
	
	private PlayerKickEvent(Player playerKicked, String kickReason, String leaveMessage) {
		super(playerKicked, kickReason, leaveMessage);
	}
	
	/**
	 * Wrapper Spout -> Bukkit
	 * @param event
	 */
	public PlayerKickEvent(org.spout.api.event.player.PlayerKickEvent event) {
		this(new BridgePlayer(event.getPlayer()), event.getKickReason(), event.getMessage());
		spoutEvent = event;
	}
	
	@Override
	public void setCancelled(boolean cancel) {
        super.setCancelled(cancel);
        spoutEvent.setCancelled(cancel);
    }
	
	@Override
	public void setReason(String kickReason) {
        super.setReason(kickReason);
        spoutEvent.setKickReason(kickReason);
    }
	
	@Override
	public void setLeaveMessage(String leaveMessage) {
        super.setLeaveMessage(leaveMessage);
    }
}
