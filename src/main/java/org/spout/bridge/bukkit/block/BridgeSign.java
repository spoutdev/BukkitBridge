package org.spout.bridge.bukkit.block;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;

public class BridgeSign extends BridgeBlockState implements Sign {
	public BridgeSign(Block b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String[] getLines() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getLine(int paramInt) throws IndexOutOfBoundsException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setLine(int paramInt, String paramString) throws IndexOutOfBoundsException {
		throw new UnsupportedOperationException();
	}
}
