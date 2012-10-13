package org.spout.bridge.bukkit.entity;

import org.bukkit.Material;
import org.bukkit.entity.FallingSand;

public class BridgeFallingSand extends BridgeEntity implements FallingSand {
	@Override
	public Material getMaterial() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getBlockId() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public byte getBlockData() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean getDropItem() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setDropItem(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
