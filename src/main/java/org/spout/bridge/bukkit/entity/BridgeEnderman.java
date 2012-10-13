package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.Enderman;
import org.bukkit.material.MaterialData;

public class BridgeEnderman extends BridgeMonster implements Enderman {
	@Override
	public MaterialData getCarriedMaterial() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setCarriedMaterial(MaterialData materialData) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
