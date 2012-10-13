package org.spout.bridge.bukkit.map;

import java.util.List;

import org.bukkit.World;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

public class BridgeMapView implements MapView {
	@Override
	public short getId() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isVirtual() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Scale getScale() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setScale(Scale scale) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getCenterX() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getCenterZ() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setCenterX(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setCenterZ(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public World getWorld() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setWorld(World world) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public List<MapRenderer> getRenderers() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void addRenderer(MapRenderer mapRenderer) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean removeRenderer(MapRenderer mapRenderer) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
