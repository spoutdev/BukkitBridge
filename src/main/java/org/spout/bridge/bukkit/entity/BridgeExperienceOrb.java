package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.spout.api.entity.Entity;

public class BridgeExperienceOrb extends BridgeEntity implements ExperienceOrb {
	protected BridgeExperienceOrb(Entity handle) {
		super(handle);
	}

	@Override
	public int getExperience() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setExperience(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public EntityType getType() {
		return EntityType.EXPERIENCE_ORB;
	}
}
