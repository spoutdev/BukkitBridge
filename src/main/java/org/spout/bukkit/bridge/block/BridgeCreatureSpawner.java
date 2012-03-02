package org.spout.bukkit.bridge.block;

import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;

public class BridgeCreatureSpawner extends BridgeBlockState implements CreatureSpawner {
    @Override
    public CreatureType getCreatureType() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public EntityType getSpawnedType() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setSpawnedType(EntityType entityType) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setCreatureType(CreatureType creatureType) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getCreatureTypeId() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setCreatureTypeByName(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getCreatureTypeName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setCreatureTypeId(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getDelay() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setDelay(int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
