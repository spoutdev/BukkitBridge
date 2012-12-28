/*
 * This file is part of BukkitBridge.
 *
 * Copyright (c) 2012, VanillaDev <http://www.spout.org/>
 * BukkitBridge is licensed under the GNU General Public License.
 *
 * BukkitBridge is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BukkitBridge is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.spout.bridge.bukkit.entity;

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

import org.spout.api.Spout;
import org.spout.api.component.impl.PhysicsComponent;
import org.spout.api.component.implementation.PhysicsComponent;
import org.spout.api.event.entity.EntityTeleportEvent;
import org.spout.api.geo.discrete.Point;
import org.spout.api.math.Vector3;

import org.spout.bridge.BukkitUtil;
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
		return (BridgeServer) Bukkit.getServer();
	}

	@Override
	public List<MetadataValue> getMetadata(String key) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasMetadata(String key) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeMetadata(String arg0, Plugin arg1) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setMetadata(String arg0, MetadataValue arg1) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean eject() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getEntityId() {
		return handle.getId();
	}

	@Override
	public float getFallDistance() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getFireTicks() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EntityDamageEvent getLastDamageCause() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Location getLocation() {
		Point pos = handle.getTransform().getPosition();
		World w = getServer().getWorld(handle.getWorld().getUID());
		return new Location(w, pos.getX(), pos.getY(), pos.getZ(), handle.getTransform().getYaw(), handle.getTransform().getPitch());
	}

	@Override
	public int getMaxFireTicks() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Entity> getNearbyEntities(double arg0, double arg1, double arg2) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Entity getPassenger() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getTicksLived() {
		throw new UnsupportedOperationException();
	}

	@Override
	public UUID getUniqueId() {
		return handle.getUID();
	}

	@Override
	public Entity getVehicle() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Vector getVelocity() {
		throw new UnsupportedOperationException();
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
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isInsideVehicle() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isValid() {
		return !handle.isRemoved() && handle.getId() != -1;
	}

	@Override
	public boolean leaveVehicle() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void playEffect(EntityEffect effect) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void remove() {
		handle.remove();
	}

	@Override
	public void setFallDistance(float dist) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setFireTicks(int ticks) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setLastDamageCause(EntityDamageEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean setPassenger(Entity entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setTicksLived(int ticks) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setVelocity(Vector vec) {
		PhysicsComponent physics = handle.get(PhysicsComponent.class);
		if (physics != null) {
			physics.applyForce(new Vector3(vec.getX(), vec.getY(), vec.getZ()));
		}
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
		Location prev = getLocation();
		//Call Spout EntityTeleportEvent; later mapped to Bukkit EntityTeleportEvent via the EntityListener
		EntityTeleportEvent event = new EntityTeleportEvent(handle, BukkitUtil.toPoint(prev), BukkitUtil.toPoint(loc));
		Spout.getEventManager().callEvent(event);
		if (!event.isCancelled()) {
			loc = BukkitUtil.fromPoint(event.getTo());
			prev = BukkitUtil.fromPoint(event.getFrom());
			handle.getTransform().setPosition(new Point(handle.getWorld(), (float) loc.getX(), (float) loc.getY(), (float) loc.getZ()));
			handle.getTransform().setPitch(loc.getPitch());
			handle.getTransform().setYaw(loc.getYaw());
			return true;
		}
		return false;
	}

	@Override
	public boolean teleport(Entity loc, TeleportCause cause) {
		return teleport(loc.getLocation(), cause);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BridgeEntity)) {
			return false;
		}
		BridgeEntity other = (BridgeEntity) obj;
		return other.getEntityId() == this.getEntityId();
	}

	@Override
	public int hashCode() {
		return getEntityId();
	}

	@Override
	public String toString() {
		return "{ " + getClass().getSimpleName() + " : " + handle.toString() + " }";
	}
}