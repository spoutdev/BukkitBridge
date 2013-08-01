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
package org.spout.bridge.listener;

import org.spout.api.event.EventHandler;

import org.spout.bridge.VanillaBridgePlugin;

public class PaintingListener extends AbstractListener {
	public PaintingListener(VanillaBridgePlugin plugin) {
		super(plugin);
	}

	@EventHandler
	public void onPaintingBreakByEntity() {
		//todo implement onPaintingBreakByEntity
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPaintingBreak() {
		//todo implement onPaintingBreak
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPainting() {
		//todo implement onPainting
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onPaintingPlace() {
		//todo implement onPaintingPlace
		throw new UnsupportedOperationException();
	}
}
