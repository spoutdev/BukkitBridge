package org.spout.bridge.bukkit.entity;

import org.spout.api.entity.Entity;
import org.spout.api.entity.Player;

public final class EntityFactory {
	
	public static BridgeEntity createEntity(Entity entity) {
		if (entity instanceof Player) {
			return createPlayer((Player)entity);
		}
		return null;
	}

	public static BridgePlayer createPlayer(Player player) {
		return new BridgePlayer(player);
	}
}
