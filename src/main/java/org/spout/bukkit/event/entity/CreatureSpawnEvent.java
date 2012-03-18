package org.spout.bukkit.event.entity;

import org.spout.bukkit.entity.BridgeLivingEntity;
import org.spout.vanilla.entity.LivingEntity;


public class CreatureSpawnEvent extends org.bukkit.event.entity.CreatureSpawnEvent {
	private org.spout.api.event.entity.EntitySpawnEvent spoutEvent;
	
	private CreatureSpawnEvent(final org.bukkit.entity.LivingEntity spawnee, final SpawnReason spawnReason) {
        super(spawnee, spawnReason);
    }
	
	/**
	 * Wrapper Spout -> Bukkit
	 * @param event
	 */
	public CreatureSpawnEvent(org.spout.api.event.entity.EntitySpawnEvent event) {
		//TODO: Implement SpawnReason
		//TODO: Cast to right Bukkit Entity
		super(new BridgeLivingEntity((LivingEntity) event.getEntity().getController()), SpawnReason.CUSTOM);
		this.spoutEvent = event;
	}
	
	@Override
	public void setCancelled(boolean cancel) {
		super.setCancelled(cancel);
		spoutEvent.setCancelled(cancel);
	}

}
