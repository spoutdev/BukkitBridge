package org.spout.bridge.bukkit.entity;

import org.bukkit.Art;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Painting;

public class BridgePainting extends BridgeEntity implements Painting {
	@Override
	public Art getArt() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean setArt(Art art) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean setArt(Art art, boolean b) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean setFacingDirection(BlockFace blockFace, boolean b) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public BlockFace getAttachedFace() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setFacingDirection(BlockFace blockFace) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public BlockFace getFacing() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
