package org.spout.bridge.bukkit.block;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.spout.bridge.VanillaBridgePlugin;

public class BridgeSign extends BridgeBlockState implements Sign {
	private final org.spout.vanilla.component.substance.material.Sign sign;
	public BridgeSign(Block b) {
		super(b);
		this.sign = (org.spout.vanilla.component.substance.material.Sign) getHandle();
	}

	@Override
	public String[] getLines() {
		return sign.getText();
	}

	@Override
	public String getLine(int line) throws IndexOutOfBoundsException {
		return getLines()[line];
	}

	@Override
	public void setLine(int line, String text) throws IndexOutOfBoundsException {
		String[] lines = sign.getText();
		lines[line] = text;
		sign.setText(lines, VanillaBridgePlugin.getCause());
	}
}
