package org.spout.bridge.bukkit.entity;

import org.spout.api.entity.Entity;
import org.spout.api.entity.Player;

/**
 * Creates BridgeEntity and BridgePlayer objects upon request
 */
public final class EntityFactory {
	/**
	 * Creates a BridgeEntity from a SpoutAPI Entity. If the Entity is a Player,
	 * this method will return a BridgePlayer object instead of a plain
	 * BridgeEntity
	 * 
	 * @param entity The SpoutAPI Entity to create a BridgeEntity from
	 * @return The BridgeEntity that represents the SpoutAPI Entity
	 */
	public static BridgeEntity createEntity(Entity entity) {
		if (entity instanceof Player) {
			return createPlayer((Player) entity);
		}
		return null;
	}

	/**
	 * Creates a BridgePlayer from a SpoutAPI Player
	 * 
	 * @param player The SpoutAPI Player to create a BridgePlayer from
	 * @return The BridgePlayer that represents the SpoutAPI Player
	 */
	public static BridgePlayer createPlayer(Player player) {
		return new BridgePlayer(player);
	}
}
