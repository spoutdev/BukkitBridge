package org.spout.bukkit.event.entity;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.spout.bukkit.BridgeLocation;
import org.spout.bukkit.entity.BridgeEntity;
import org.spout.vanilla.entity.VanillaEntity;

public class EntityTeleportEvent extends org.bukkit.event.entity.EntityTeleportEvent {
	private org.spout.api.event.entity.EntityTeleportEvent spoutEvent;
	
	private EntityTeleportEvent(Entity what, Location from, Location to) {
		super(what, from, to);
	}
	
	/**
	 * Wrapper Spout -> Bukkit
	 * @param event
	 */
	public EntityTeleportEvent(org.spout.api.event.entity.EntityTeleportEvent event) {
		super(new BridgeEntity((VanillaEntity) event.getEntity().getController()), BridgeLocation.getLocation(event.getFrom()), BridgeLocation.getLocation(event.getTo()));
		spoutEvent = event;
	}
	
	public void setTo(Location to) {
        super.setTo(to);
        spoutEvent.setTo(BridgeLocation.getPoint(to));
    }
	
	public void setFrom(Location from) {
        super.setFrom(from);
        spoutEvent.setFrom(BridgeLocation.getPoint(from));
    }
	
	public void setCancelled(boolean cancel) {
	    super.setCancelled(cancel);
	    spoutEvent.setCancelled(cancel);
	}
}
