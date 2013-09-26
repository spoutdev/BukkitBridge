/*
 * This file is part of BukkitBridge.
 *
 * Copyright (c) 2012 Spout LLC <http://www.spout.org/>
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
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import org.spout.api.component.entity.EntityComponent;
import org.spout.api.event.entity.EntityTeleportEvent;
import org.spout.api.geo.discrete.Point;
import org.spout.api.map.DefaultedKey;
import org.spout.api.map.DefaultedKeyImpl;
import org.spout.math.imaginary.Quaternion;
import org.spout.math.vector.Vector3;

import org.spout.bridge.BukkitUtil;
import org.spout.bridge.bukkit.BridgeServer;

import org.spout.vanilla.component.entity.misc.Burn;
import org.spout.vanilla.component.entity.misc.Health;
import org.spout.vanilla.data.VanillaData;

public abstract class BridgeEntity implements Entity {
	protected static final DefaultedKey<Integer> TICKS_LIVED = new DefaultedKeyImpl<Integer>("ticks_lived", 0);
	private final org.spout.api.entity.Entity handle;
	private final BridgeComponent component;

	protected BridgeEntity(org.spout.api.entity.Entity handle) {
		this.handle = handle;
		this.component = this.handle.add(BridgeComponent.class);
	}

	public org.spout.api.entity.Entity getHandle() {
		return handle;
	}

	public final BridgeComponent getComponent() {
		return component;
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
		return getHandle().getData().containsKey(key);
	}

	@Override
	public void removeMetadata(String arg0, Plugin arg1) {
		getHandle().getData().remove(arg0);
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
		Burn burn = handle.get(Burn.class);
		if (burn == null) {
			return 0;
		}
		return (int) burn.getFireTick();
	}

	@Override
	public EntityDamageEvent getLastDamageCause() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Location getLocation() {
		Point pos = handle.getPhysics().getPosition();
		World w = getServer().getWorld(handle.getWorld().getUID());
		Quaternion rotation = handle.getPhysics().getRotation();
		Vector3 rot = rotation.getAxesAnglesRad();
		return new Location(w, pos.getX(), pos.getY(), pos.getZ(), rot.getY(), rot.getZ());
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
	public UUID getUniqueId() {
		return handle.getUID();
	}

	@Override
	public Entity getVehicle() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Vector getVelocity() {
		Vector3 velocity = getHandle().getPhysics().getMovementVelocity();
		return new Vector(velocity.getX(), velocity.getY(), velocity.getZ());
	}

	@Override
	public World getWorld() {
		return getServer().getWorld(handle.getWorld().getUID());
	}

	@Override
	public boolean isDead() {
		Health health = getHandle().get(Health.class);
		return health != null ? health.isDead() : handle.isRemoved();
	}

	@Override
	public boolean isEmpty() {
		return getPassenger() == null;
	}

	@Override
	public boolean isInsideVehicle() {
		return getVehicle() != null;
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
	public EntityType getType() {
		return null;
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
		Burn burn = handle.get(Burn.class);
		if (burn != null) {
			burn.setOnFire(ticks / 20, true);
		}
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
	public int getTicksLived() {
		return handle.getData().get(TICKS_LIVED);
	}

	@Override
	public void setTicksLived(int ticks) {
		handle.getData().put(TICKS_LIVED, ticks);
	}

	@Override
	public void setVelocity(Vector vec) {
		if (handle.getPhysics().isActivated()) {
			handle.getPhysics().force(new Vector3(vec.getX(), vec.getY(), vec.getZ()));
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
		// Call Spout EntityTeleportEvent; later mapped to Bukkit EntityTeleportEvent via the EntityListener
		EntityTeleportEvent event = new EntityTeleportEvent(handle, BukkitUtil.toPoint(prev), BukkitUtil.toPoint(loc));
		handle.getEngine().getEventManager().callEvent(event);
		if (!event.isCancelled()) {
			loc = BukkitUtil.fromPoint(event.getTo());
			prev = BukkitUtil.fromPoint(event.getFrom());
			handle.getPhysics().setPosition(new Point(handle.getWorld(), (float) loc.getX(), (float) loc.getY(), (float) loc.getZ()));
			handle.getPhysics().setRotation(new Quaternion(loc.getPitch(), loc.getYaw(), 0, 0));
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

	@Override
	public Location getLocation(Location loc) {
		if (loc != null) {
			Point pos = handle.getPhysics().getPosition();
			Quaternion rotation = handle.getPhysics().getRotation();
			Vector3 rot = rotation.getAxesAnglesRad();
			loc.setWorld(getWorld());
			loc.setX(pos.getX());
			loc.setY(pos.getY());
			loc.setZ(loc.getZ());
			loc.setYaw(rot.getY());
			loc.setPitch(rot.getZ());
		}
		return loc;
	}

	@Override
	public boolean isOnGround() {
		return getComponent().getData().get(VanillaData.IS_ON_GROUND);
	}
}

class BridgeComponent extends EntityComponent {
	private final org.spout.api.entity.Entity handle;

	public BridgeComponent(org.spout.api.entity.Entity entity) {
		this.handle = entity;
	}

	@Override
	public boolean canTick() {
		return true;
	}

	@Override
	public void onTick(float dt) {
		handle.getData().put(BridgeEntity.TICKS_LIVED, handle.getData().get(BridgeEntity.TICKS_LIVED) + 1);
	}
}
