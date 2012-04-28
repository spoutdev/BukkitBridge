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

import org.spout.bukkit.BridgeUtil;
import org.spout.bukkit.BridgeWorld;
import org.spout.vanilla.controller.VanillaActionController;

public class BridgeEntity implements Entity {
	private final VanillaActionController spoutController;

	public BridgeEntity(VanillaActionController spoutController) {
		this.spoutController = spoutController;
	}

	public VanillaActionController getSpoutController() {
		return spoutController;
	}

	@Override
	public Location getLocation() {
		return BridgeUtil.toLocation(spoutController.getParent().getTransform());
	}

	@Override
	public void setVelocity(Vector vector) {
		spoutController.setVelocity(BridgeUtil.toVector(vector));
	}

	@Override
	public Vector getVelocity() {
		//TODO VanillaController no longer sets velocity and instead simply moves...need a new way to figure this out.
		return null;
	}

	@Override
	public World getWorld() {
		return new BridgeWorld(spoutController.getParent().getWorld());
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
		return spoutController.getParent().getId();
	}

	@Override
	public int getFireTicks() {
		return spoutController.getFireTicks();
	}

	@Override
	public int getMaxFireTicks() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setFireTicks(int fireTicks) {
		spoutController.setFireTicks(fireTicks);
	}

	@Override
	public void remove() {
		spoutController.getParent().kill();
	}

	@Override
	public boolean isDead() {
		return spoutController.getParent().isDead();
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
