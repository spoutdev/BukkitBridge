package org.spout.bridge.bukkit.entity;

import org.bukkit.entity.Monster;
import org.spout.api.entity.Entity;

public abstract class BridgeMonster extends BridgeCreature implements Monster {

	protected BridgeMonster(Entity handle) {
		super(handle);
	}
}
