package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.ComplexEntityPart;
import org.bukkit.entity.ComplexLivingEntity;

public class BridgeComplexPart extends BridgeEntity implements ComplexEntityPart {
	@Override
	public ComplexLivingEntity getParent() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
