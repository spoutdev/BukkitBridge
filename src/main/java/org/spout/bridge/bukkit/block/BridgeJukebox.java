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
		throw new UnsupportedOperationException();
	}

	@Override
	public void setPlaying(Material paramMaterial) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isPlaying() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean eject() {
		throw new UnsupportedOperationException();
	}
}
