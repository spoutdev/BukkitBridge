package org.spout.bridge.workbench.server.entities;

import net.minecraft.workbench.server.entities.Entity;
import net.minecraft.workbench.server.entities.EntityController;

public class WorkbenchEntity implements Entity {

	private org.spout.api.entity.Entity entity;
	private EntityController controller;
	
	public WorkbenchEntity(org.spout.api.entity.Entity entity, EntityController controller){
		this.entity=entity;
		this.controller=controller;
	}
	@Override
	public EntityController getController() {
		return controller;
	}

}
