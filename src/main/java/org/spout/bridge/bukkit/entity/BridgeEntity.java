package org.spout.bridge.bukkit.entity;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.spout.api.geo.discrete.Point;
import org.spout.bridge.bukkit.BridgeServer;

public abstract class BridgeEntity implements Entity {
	private final org.spout.api.entity.Entity handle;
	protected BridgeEntity(org.spout.api.entity.Entity handle) {
		this.handle = handle;
	}

	public org.spout.api.entity.Entity getHandle() {
		return handle;
	}

	@Override
	public BridgeServer getServer() {
		return (BridgeServer)Bukkit.getServer();
	}

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
		return handle.getId();
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
		Point pos = handle.getTransform().getPosition();
		World w = getServer().getWorld(handle.getWorld().getUID());
		return new Location(w, pos.getX(), pos.getY(), pos.getZ(), handle.getTransform().getYaw(), handle.getTransform().getPitch());
	}

	@Override
	public int getMaxFireTicks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Entity> getNearbyEntities(double arg0, double arg1, double arg2) {
		// TODO Auto-generated method stub
		return Collections.emptyList();
	}

	@Override
	public Entity getPassenger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTicksLived() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UUID getUniqueId() {
		return handle.getUID();
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
		return getServer().getWorld(handle.getWorld().getUID());
	}

	@Override
	public boolean isDead() {
		return handle.isRemoved();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isInsideVehicle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValid() {
		return handle.isRemoved() || handle.getId() == -1;
	}

	@Override
	public boolean leaveVehicle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void playEffect(EntityEffect effect) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove() {
		handle.remove();
	}

	@Override
	public void setFallDistance(float dist) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFireTicks(int ticks) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLastDamageCause(EntityDamageEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean setPassenger(Entity entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setTicksLived(int ticks) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setVelocity(Vector vec) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean teleport(Location loc) {
		return teleport(loc, TeleportCause.PLUGIN);
	}

	@Override
	public boolean teleport(Entity entity) {
		return teleport(entity.getLocation());
	}

	@Override
	public boolean teleport(Location loc, TeleportCause cause) {
		handle.getTransform().setPosition(new Point(handle.getWorld(), (float)loc.getX(), (float)loc.getY(), (float)loc.getZ()));
		handle.getTransform().setPitch(loc.getPitch());
		handle.getTransform().setYaw(loc.getYaw());
		//TODO: event?
		return true;
	}

	@Override
	public boolean teleport(Entity loc, TeleportCause cause) {
		return teleport(loc.getLocation(), cause);
	}
}
