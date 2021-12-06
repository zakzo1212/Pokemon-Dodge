package com.game.src.sound;
import javax.sound.midi.*;

public class JSMusicPlayer {
	public static final int defaultInstrument = 1;
	
	int instrument;
	Sequence sequence;
	Track track;
	int time;
	Sequencer sequencer;

	public JSMusicPlayer() {
		this(defaultInstrument);
	}

	public JSMusicPlayer(int instrumentId) {
		instrument = instrumentId;
		sequence = JSMusic2.initialize();
		track = JSMusic2.createTrack(sequence, instrument);
		time = 70;  // Wait some time so instruments don't skip.
	}

	public void addRest(int numTicks) {
		time += numTicks;
	}
	
	public void addNote(int note, int numTicks) {
		JSMusic2.addNote(track, note, time, time+numTicks-1);
		time += numTicks;
	}	

	public void play(int tempo) {
		sequencer = JSMusic2.play(sequence, tempo);
	}
	
	public void waitForSongDone() {
		JSMusic2.waitForSongDone(sequencer);
	}
	
	public void close() {
		JSMusic2.close(sequencer);
	}
}
