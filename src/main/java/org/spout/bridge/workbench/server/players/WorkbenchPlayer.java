package org.spout.bridge.workbench.server.players;

import java.util.UUID;

import org.spout.api.component.components.EntityComponent;
import org.spout.bridge.workbench.server.entities.WorkbenchEntityController;
import net.minecraft.workbench.server.players.Player;

public class WorkbenchPlayer extends WorkbenchEntityController implements Player {

	private org.spout.api.entity.Player player;
	
	public WorkbenchPlayer(EntityComponent controller) {
		super(controller);
		player=(org.spout.api.entity.Player) controller.getHolder();
	}

	@Override
	public UUID getUUID() {
		return player.getUID();
	}

	@Override
	public String getUsername() {
		return player.getName();
	}

	@Override
	public String getDisplayName() {
		return player.getDisplayName();
	}

}
