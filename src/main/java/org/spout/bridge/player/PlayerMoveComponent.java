package org.spout.bridge.player;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.spout.api.component.components.EntityComponent;
import org.spout.api.geo.discrete.Transform;
import org.spout.bridge.BukkitUtil;
import org.spout.bridge.bukkit.entity.EntityFactory;

public class PlayerMoveComponent extends EntityComponent{
	Transform prev;
	Player player;

	@Override
	public void onAttached() {
		player = EntityFactory.createPlayer((org.spout.api.entity.Player)getOwner());
	}

	@Override
	public void onTick(float dt) {
		if (prev != null && !prev.equals(getOwner().getTransform().getTransform())) {
			Location from = BukkitUtil.fromTransform(prev);
			Location to = BukkitUtil.fromTransform(getOwner().getTransform().getTransform());
			PlayerMoveEvent event = new PlayerMoveEvent(player, from, to);
			Bukkit.getPluginManager().callEvent(event);
			if (event.isCancelled()) {
				getOwner().getTransform().setTransform(prev);
			}
			else if (!event.getTo().equals(to)) {
				getOwner().getTransform().setPosition(BukkitUtil.toPoint(to));
			}
		}
	}

}
