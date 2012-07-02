package org.spout.bridge.bukkit.block;

import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;

@SuppressWarnings("deprecation")
public class BridgeCreatureSpawner extends BridgeBlockState implements CreatureSpawner {

	public BridgeCreatureSpawner(Block b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CreatureType getCreatureType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityType getSpawnedType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSpawnedType(EntityType paramEntityType) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCreatureType(CreatureType paramCreatureType) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getCreatureTypeId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCreatureTypeByName(String paramString) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getCreatureTypeName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCreatureTypeId(String paramString) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getDelay() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setDelay(int paramInt) {
		// TODO Auto-generated method stub

	}

}
