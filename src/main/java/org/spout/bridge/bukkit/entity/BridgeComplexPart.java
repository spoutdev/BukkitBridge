package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.ComplexEntityPart;
import org.bukkit.entity.ComplexLivingEntity;
import org.bukkit.entity.EntityType;
import org.spout.api.entity.Entity;

public class BridgeComplexPart extends BridgeEntity implements ComplexEntityPart {
	protected BridgeComplexPart(Entity handle) {
		super(handle);
	}

	@Override
	public ComplexLivingEntity getParent() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public EntityType getType() {
		return EntityType.COMPLEX_PART;
	}
}
