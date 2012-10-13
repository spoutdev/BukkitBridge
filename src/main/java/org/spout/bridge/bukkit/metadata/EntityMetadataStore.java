package org.spout.bridge.bukkit.metadata;

import org.bukkit.entity.Entity;
import org.bukkit.metadata.MetadataStore;
import org.bukkit.metadata.MetadataStoreBase;

public class EntityMetadataStore extends MetadataStoreBase<Entity> implements MetadataStore<Entity> {
	@Override
	protected String disambiguate(Entity entity, String s) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
