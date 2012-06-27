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
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.block.Block;
import org.bukkit.block.NoteBlock;
import org.spout.vanilla.util.VanillaNetworkUtil;

public class BridgeNoteBlock extends BridgeBlockState implements NoteBlock {
	private final org.spout.vanilla.controller.block.NoteBlock noteBlock;

	public BridgeNoteBlock(Block block, org.spout.vanilla.controller.block.NoteBlock noteBlock) {
		super(block);
		this.noteBlock = noteBlock;
	}

	@Override
	public Note getNote() {
		return new Note(noteBlock.getNote());
	}

	@Override
	public byte getRawNote() {
		return (byte) noteBlock.getNote();
	}

	@Override
	public void setNote(Note note) {
		noteBlock.setNote(note.getId());
	}

	@Override
	public void setRawNote(byte b) {
		noteBlock.setNote(b);
	}

	@Override
	public boolean play() {
		if (getBlock().getType() == Material.NOTE_BLOCK) {
			noteBlock.play();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean play(byte instrumentType, byte noteId) {
		if (getBlock().getType() == Material.NOTE_BLOCK) {
			VanillaNetworkUtil.playBlockAction(noteBlock.getBlock(), instrumentType, noteId);  // NoteBlock doesn't offer something like this
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean play(Instrument instrument, Note note) {
		return play(instrument.getType(), note.getId());
	}
}
