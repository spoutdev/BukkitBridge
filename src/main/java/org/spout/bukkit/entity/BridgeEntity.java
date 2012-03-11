/*
 * This file is part of BukkitBridge (http://www.spout.org/).
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
package org.spout.bukkit.entity;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
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

import org.spout.api.geo.discrete.Point;
import org.spout.api.math.Vector3;
import org.spout.api.math.Vector3m;
import org.spout.bukkit.BridgeWorld;
import org.spout.vanilla.entity.VanillaEntity;

public class BridgeEntity implements Entity {
	private final VanillaEntity spoutEntity;

	public BridgeEntity(VanillaEntity spoutEntity) {
		this.spoutEntity = spoutEntity;
	}

	@Override
	public Location getLocation() {
		Point pos = spoutEntity.getParent().getPosition();
		
		return new Location(this.getWorld(), pos.getX(), pos.getY(), pos.getZ(), spoutEntity.getParent().getYaw(), spoutEntity.getParent().getPitch());
	}

	@Override
	public void setVelocity(Vector vector) {
		((Vector3m) spoutEntity.getVelocity()).setX((float) vector.getX());
		((Vector3m) spoutEntity.getVelocity()).setY((float) vector.getY());
		((Vector3m) spoutEntity.getVelocity()).setZ((float) vector.getZ());
	}

	@Override
	public Vector getVelocity() {
		Vector3 v = spoutEntity.getVelocity();
		return new Vector(v.getX(), v.getY(), v.getZ());
	}

	@Override
	public World getWorld() {
		return new BridgeWorld(spoutEntity.getParent().getWorld());
	}

	@Override
	public boolean teleport(Location location) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean teleport(Location location, TeleportCause teleportCause) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean teleport(Entity entity) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean teleport(Entity entity, TeleportCause teleportCause) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public List<Entity> getNearbyEntities(double v, double v1, double v2) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public int getEntityId() {
		return spoutEntity.getParent().getId();
	}

	@Override
	public int getFireTicks() {
		return spoutEntity.getFireTicks();
	}

	@Override
	public int getMaxFireTicks() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setFireTicks(int fireTicks) {
		spoutEntity.setFireTicks(fireTicks);
	}

	@Override
	public void remove() {
		spoutEntity.kill();
	}

	@Override
	public boolean isDead() {
		return spoutEntity.getParent().isDead();
	}

	@Override
	public Server getServer() {
		return Bukkit.getServer();
	}

	@Override
	public Entity getPassenger() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean setPassenger(Entity entity) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isEmpty() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean eject() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public float getFallDistance() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setFallDistance(float v) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void setLastDamageCause(EntityDamageEvent entityDamageEvent) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public EntityDamageEvent getLastDamageCause() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public UUID getUniqueId() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public int getTicksLived() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setTicksLived(int i) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void playEffect(EntityEffect entityEffect) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public EntityType getType() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isInsideVehicle() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean leaveVehicle() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Entity getVehicle() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setMetadata(String s, MetadataValue metadataValue) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public List<MetadataValue> getMetadata(String s) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean hasMetadata(String s) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void removeMetadata(String s, Plugin plugin) {
		//TODO: Adjust for usage with Spout!
	}
}
