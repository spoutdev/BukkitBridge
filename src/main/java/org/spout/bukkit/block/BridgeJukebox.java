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
package org.spout.bukkit.block;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Jukebox;
import org.bukkit.inventory.ItemStack;
import org.spout.bukkit.util.BridgeUtil;

public class BridgeJukebox extends BridgeBlockState implements Jukebox {
	private final org.spout.vanilla.controller.block.Jukebox jukebox;

	public BridgeJukebox(Block block, org.spout.vanilla.controller.block.Jukebox jukebox) {
		super(block);
		this.jukebox = jukebox;
	}

	@Override
	public Material getPlaying() {
		if (!isPlaying())
			return Material.AIR;
		return BridgeUtil.toMaterial(jukebox.getInventory().getMusicSlot().getMaterial());
	}

	@Override
	public void setPlaying(Material material) {
		if (material == null || material == Material.AIR){
			jukebox.stopMusic();
		} else {
			jukebox.getInventory().setMusicSlot(BridgeUtil.toSpoutItemStack(new ItemStack(material)));
			jukebox.update();
		}
	}

	@Override
	public boolean isPlaying() {
		return jukebox.getBlock().getData() == 1;
	}

	@Override
	public boolean eject() {
		boolean wasPlaying = isPlaying();
		jukebox.eject();
		return wasPlaying;
	}
}
