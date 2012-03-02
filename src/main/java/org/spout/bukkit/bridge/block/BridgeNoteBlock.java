package org.spout.bukkit.bridge.block;

import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.block.NoteBlock;

public class BridgeNoteBlock extends BridgeBlockState implements NoteBlock {

    @Override
    public Note getNote() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public byte getRawNote() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setNote(Note note) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setRawNote(byte b) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean play() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean play(byte b, byte b1) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean play(Instrument instrument, Note note) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
