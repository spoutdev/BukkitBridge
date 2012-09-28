package org.spout.bridge.workbench.server.entities;

import org.spout.api.component.components.EntityComponent;
import org.spout.vanilla.component.living.VanillaEntity;

import net.minecraft.workbench.server.entities.Entity;
import net.minecraft.workbench.server.entities.EntityController;

public class WorkbenchEntityController implements EntityController {

	private EntityComponent controller;
	private WorkbenchEntity entity;
	
	public WorkbenchEntityController(EntityComponent controller){
		this.controller=controller;
		this.entity=new WorkbenchEntity(controller.getHolder(),this);
	}
	@Override
	public Entity getControlledEntity() {
		return entity;
	}

}
