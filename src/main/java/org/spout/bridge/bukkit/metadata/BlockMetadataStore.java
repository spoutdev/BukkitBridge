package org.spout.bridge.bukkit.metadata;

import org.bukkit.block.Block;
import org.bukkit.metadata.MetadataStore;
import org.bukkit.metadata.MetadataStoreBase;

public class BlockMetadataStore extends MetadataStoreBase<Block> implements MetadataStore<Block> {
	@Override
	protected String disambiguate(Block block, String s) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
