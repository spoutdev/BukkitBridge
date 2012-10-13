package org.spout.bridge.bukkit.entity;

import org.bukkit.DyeColor;
import org.bukkit.entity.Sheep;

public class BridgeSheep extends BridgeAnimals implements Sheep {
	@Override
	public boolean isSheared() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setSheared(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public DyeColor getColor() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setColor(DyeColor dyeColor) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
