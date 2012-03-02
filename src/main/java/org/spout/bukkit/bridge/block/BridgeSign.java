package org.spout.bukkit.bridge.block;

import org.bukkit.block.Sign;

public class BridgeSign extends BridgeBlockState implements Sign {

    @Override
    public String[] getLines() {
        return new String[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getLine(int i) throws IndexOutOfBoundsException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setLine(int i, String s) throws IndexOutOfBoundsException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}
