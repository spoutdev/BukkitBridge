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

import org.spout.bridge.BukkitBridgePlugin;

public class HangingListener extends AbstractListener {
	public HangingListener(BukkitBridgePlugin plugin) {
		super(plugin);
	}

	@EventHandler
	public void onHangingBreakByEntity() {
		// TODO: Implement onHangingBreakByEntity
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onHangingBreak() {
		// TODO: Implement onHangingBreak
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onHanging() {
		// TODO: Implement onHanging
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onHangingPlace() {
		// TODO: Implement onHangingPlace
		throw new UnsupportedOperationException();
	}
}
