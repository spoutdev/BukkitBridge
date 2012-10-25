package org.spout.bridge.bukkit.entity;

import java.util.Set;

import org.bukkit.entity.ComplexEntityPart;
import org.bukkit.entity.ComplexLivingEntity;
import org.bukkit.entity.EntityType;
import org.spout.api.entity.Entity;

public class BridgeComplexLivingEntity extends BridgeLivingEntity implements ComplexLivingEntity {
	protected BridgeComplexLivingEntity(Entity handle) {
		super(handle);
	}

	@Override
	public Set<ComplexEntityPart> getParts() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EntityType getType() {
		return EntityType.COMPLEX_PART;
	}
}
