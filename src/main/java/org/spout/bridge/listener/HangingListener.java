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
package org.spout.bridge.listener;

import org.spout.api.event.EventHandler;

import org.spout.bridge.VanillaBridgePlugin;

public class HangingListener extends AbstractListener {
	public HangingListener(VanillaBridgePlugin plugin) {
		super(plugin);
	}

	@EventHandler
	public void onHangingBreakByEntity() {
		//todo implement onHangingBreakByEntity
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onHangingBreak() {
		//todo implement onHangingBreak
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onHanging() {
		//todo implement onHanging
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onHangingPlace() {
		//todo implement onHangingPlace
		throw new UnsupportedOperationException();
	}
}
