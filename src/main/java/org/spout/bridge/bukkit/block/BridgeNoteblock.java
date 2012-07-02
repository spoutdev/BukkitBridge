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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte getRawNote() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setNote(Note paramNote) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRawNote(byte paramByte) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean play() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean play(byte paramByte1, byte paramByte2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean play(Instrument paramInstrument, Note paramNote) {
		// TODO Auto-generated method stub
		return false;
	}

}
