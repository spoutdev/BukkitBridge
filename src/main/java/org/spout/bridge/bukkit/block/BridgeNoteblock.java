package org.spout.bridge.bukkit.block;

import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.block.Block;
import org.bukkit.block.NoteBlock;

public class BridgeNoteblock extends BridgeBlockState implements NoteBlock {
	public BridgeNoteblock(Block b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Note getNote() {
		throw new UnsupportedOperationException();
	}

	@Override
	public byte getRawNote() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setNote(Note paramNote) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setRawNote(byte paramByte) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean play() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean play(byte paramByte1, byte paramByte2) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean play(Instrument paramInstrument, Note paramNote) {
		throw new UnsupportedOperationException();
	}
}
