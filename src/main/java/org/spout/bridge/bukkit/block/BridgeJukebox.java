package org.spout.bridge.bukkit.block;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Jukebox;

public class BridgeJukebox extends BridgeBlockState implements Jukebox {
	public BridgeJukebox(Block b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Material getPlaying() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPlaying(Material paramMaterial) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isPlaying() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eject() {
		// TODO Auto-generated method stub
		return false;
	}
}
