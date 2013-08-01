/*
 * This file is part of BukkitBridge.
 *
 * Copyright (c) 2012 Spout LLC <http://www.spout.org/>
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

import java.awt.Image;

import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapCursorCollection;
import org.bukkit.map.MapFont;
import org.bukkit.map.MapView;

public class BridgeMapCanvas implements MapCanvas {
	@Override
	public MapView getMapView() {
		throw new UnsupportedOperationException();
	}

	@Override
	public MapCursorCollection getCursors() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setCursors(MapCursorCollection mapCursorCollection) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setPixel(int i, int i1, byte b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public byte getPixel(int i, int i1) {
		throw new UnsupportedOperationException();
	}

	@Override
	public byte getBasePixel(int i, int i1) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void drawImage(int i, int i1, Image image) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void drawText(int i, int i1, MapFont mapFont, String s) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
