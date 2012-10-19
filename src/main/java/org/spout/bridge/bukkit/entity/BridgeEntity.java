package org.spout.bridge.bukkit.entity;

import java.util.List;
import java.util.UUID;

import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

/**
 * A BridgeEntity is Bridge's implementation of Entity. BridgeEntity delegates to EntityDelegate.
 */
public class BridgeEntity implements Entity {
	@Override
	public List<MetadataValue> getMetadata(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasMetadata(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeMetadata(String arg0, Plugin arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMetadata(String arg0, MetadataValue arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean eject() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getEntityId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getFallDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFireTicks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EntityDamageEvent getLastDamageCause() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxFireTicks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Entity> getNearbyEntities(double arg0, double arg1, double arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity getPassenger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Server getServer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTicksLived() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EntityType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID getUniqueId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity getVehicle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getVelocity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public World getWorld() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInsideVehicle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean leaveVehicle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void playEffect(EntityEffect arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFallDistance(float arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFireTicks(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLastDamageCause(EntityDamageEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean setPassenger(Entity arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setTicksLived(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setVelocity(Vector arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean teleport(Location arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean teleport(Entity arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean teleport(Location arg0, TeleportCause arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean teleport(Entity arg0, TeleportCause arg1) {
		// TODO Auto-generated method stub
		return false;
	}
}
