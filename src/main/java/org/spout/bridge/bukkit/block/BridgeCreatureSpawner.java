package org.spout.bridge.bukkit.block;

import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;
import org.spout.vanilla.component.substance.material.MonsterSpawner;

@SuppressWarnings("deprecation")
public class BridgeCreatureSpawner extends BridgeBlockState implements CreatureSpawner {
	private final MonsterSpawner spawner;
	public BridgeCreatureSpawner(Block b) {
		super(b);
		this.spawner = (MonsterSpawner) getHandle();
	}

	@Override
	public CreatureType getCreatureType() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EntityType getSpawnedType() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setSpawnedType(EntityType paramEntityType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setCreatureType(CreatureType paramCreatureType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getCreatureTypeId() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setCreatureTypeByName(String paramString) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getCreatureTypeName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setCreatureTypeId(String paramString) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getDelay() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setDelay(int paramInt) {
		throw new UnsupportedOperationException();
	}
}
