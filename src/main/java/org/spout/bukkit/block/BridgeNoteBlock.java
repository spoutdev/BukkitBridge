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

import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.block.Block;
import org.bukkit.block.NoteBlock;

public class BridgeNoteBlock extends BridgeBlockState implements NoteBlock {
	public BridgeNoteBlock(Block block) {
		super(block);
	}

	@Override
	public Note getNote() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public byte getRawNote() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setNote(Note note) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void setRawNote(byte b) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean play() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean play(byte b, byte b1) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean play(Instrument instrument, Note note) {
		return false;  //TODO: Adjust for usage with Spout!
	}
}
