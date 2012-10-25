package org.spout.bridge.bukkit.entity;

import org.bukkit.DyeColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;
import org.spout.api.entity.Entity;

public class BridgeSheep extends BridgeAnimals implements Sheep {
	protected BridgeSheep(Entity handle) {
		super(handle);
	}

	@Override
	public boolean isSheared() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setSheared(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public DyeColor getColor() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setColor(DyeColor dyeColor) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public EntityType getType() {
		return EntityType.SHEEP;
	}
}
