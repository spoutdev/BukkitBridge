package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Weather;
import org.spout.api.entity.Entity;

public class BridgeWeather extends BridgeEntity implements Weather {
	protected BridgeWeather(Entity handle) {
		super(handle);
	}

	@Override
	public EntityType getType() {
		return EntityType.WEATHER;
	}
}
