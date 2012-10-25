package org.spout.bridge.bukkit.map;

import java.util.List;

import org.bukkit.World;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

public class BridgeMapView implements MapView {
	@Override
	public short getId() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isVirtual() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Scale getScale() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setScale(Scale scale) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getCenterX() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getCenterZ() {
		throw new UnsupportedOperationException();
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
		throw new UnsupportedOperationException();
	}

	@Override
	public void setWorld(World world) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public List<MapRenderer> getRenderers() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addRenderer(MapRenderer mapRenderer) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean removeRenderer(MapRenderer mapRenderer) {
		throw new UnsupportedOperationException();
	}
}
