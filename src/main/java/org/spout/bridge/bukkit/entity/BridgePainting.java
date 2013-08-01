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
package org.spout.bridge.bukkit.entity;

import org.bukkit.Art;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Painting;

import org.spout.api.entity.Entity;

public class BridgePainting extends BridgeEntity implements Painting {
	protected BridgePainting(Entity handle) {
		super(handle);
	}

	@Override
	public Art getArt() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean setArt(Art art) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean setArt(Art art, boolean b) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean setFacingDirection(BlockFace blockFace, boolean b) {
		throw new UnsupportedOperationException();
	}

	@Override
	public BlockFace getAttachedFace() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setFacingDirection(BlockFace blockFace) {
	}

	@Override
	public BlockFace getFacing() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EntityType getType() {
		return EntityType.PAINTING;
	}
}
