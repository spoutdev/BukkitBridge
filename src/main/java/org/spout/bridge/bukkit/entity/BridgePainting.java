package org.spout.bridge.bukkit.entity;

import org.bukkit.Art;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Painting;
import org.spout.api.entity.Entity;

public class BridgePainting extends BridgeEntity implements Painting {
	protected BridgePainting(Entity handle) {
		super(handle);
	}

	@Override
	public Art getArt() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean setArt(Art art) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean setArt(Art art, boolean b) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean setFacingDirection(BlockFace blockFace, boolean b) {
		throw new UnsupportedOperationException();
	}

	@Override
	public BlockFace getAttachedFace() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setFacingDirection(BlockFace blockFace) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public BlockFace getFacing() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EntityType getType() {
		return EntityType.PAINTING;
	}
}
