package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.material.MaterialData;
import org.spout.api.entity.Entity;

public class BridgeEnderman extends BridgeMonster implements Enderman {
	protected BridgeEnderman(Entity handle) {
		super(handle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public MaterialData getCarriedMaterial() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setCarriedMaterial(MaterialData materialData) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public EntityType getType() {
		return EntityType.ENDERMAN;
	}
}
