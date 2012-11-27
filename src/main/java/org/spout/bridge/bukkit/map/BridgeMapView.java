/*
 * This file is part of BukkitBridge.
 *
 * Copyright (c) 2012, VanillaDev <http://www.spout.org/>
 * BukkitBridge is licensed under the GNU General Public License.
 *
 * BukkitBridge is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BukkitBridge is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
