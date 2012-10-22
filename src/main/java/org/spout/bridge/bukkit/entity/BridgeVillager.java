package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.spout.api.entity.Entity;

public class BridgeVillager extends BridgeAgeable implements Villager {
	protected BridgeVillager(Entity handle) {
		super(handle);
	}

	@Override
	public Profession getProfession() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setProfession(Profession profession) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public EntityType getType() {
		return EntityType.VILLAGER;
	}
}
