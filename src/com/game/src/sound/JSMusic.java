package com.game.src.sound;
import javax.sound.midi.*;

public class JSMusic {

	public static final int DEFAULT_TEMPO_BPM = 120; // Beats per minute.
	public static final int ticksPerQuarterNote = 16; // Ticks per quarter note.
	public static final int velocity = 64; // How hard to press the key.

	
	public static Sequence initialize() throws InvalidMidiDataException {
		// PPQ means that the sequence is tempo based timing in ticks-per-quarter note.
		Sequence sequence = new Sequence(Sequence.PPQ, ticksPerQuarterNote);
		return sequence;
	}
	
	public static Track createTrack(Sequence sequence, int instrument) throws InvalidMidiDataException  {
		Track track = sequence.createTrack();

		// Use PROGRAM_CHANGE to select an instrument on Channel 0, starting at time 0.
		// https://en.wikipedia.org/wiki/General_MIDI#Program_change_events lists the instruments for a program change event.
		addMessage(track, ShortMessage.PROGRAM_CHANGE, 0, instrument, 0, 0);
		
		return track;
	}
	
	public static void addNote(Track track, int note, int startTime, int endTime) throws InvalidMidiDataException {
		// Press the note.
		addMessage(track, ShortMessage.NOTE_ON, 0, note, velocity, startTime);
		
		// Release the note.
		addMessage(track, ShortMessage.NOTE_OFF, 0, note, velocity, endTime);
		
		// Display the note we will play, along with the timing of the note.
		System.out.println("Note: "+note+"\tstart: "+startTime+"\tend:"+endTime);
	}

	public static void addMessage(Track track, int command, int channel, int data1, int data2, long time) throws InvalidMidiDataException {
		ShortMessage shortMessage = new ShortMessage();
		shortMessage.setMessage(command, channel, data1, data2);
		MidiEvent event = new MidiEvent(shortMessage, time);
		track.add(event);
	}
	
	public static Sequencer play(Sequence sequence, int tempo) throws InvalidMidiDataException, MidiUnavailableException {
		// Connect the sequencer to the synthesizer.
		Sequencer sequencer = MidiSystem.getSequencer();
		sequencer.open();
		Synthesizer synthesizer = MidiSystem.getSynthesizer();
		synthesizer.open();
		Receiver receiver = synthesizer.getReceiver();
		Transmitter transmitter = sequencer.getTransmitter(); 
		transmitter.setReceiver(receiver);
		
		// Sequence the music and play it.
		sequencer.setSequence(sequence);		
		sequencer.setTempoInBPM(tempo);		
		sequencer.start();
		
		return sequencer;
	}
	
	public static void waitForSongDone(Sequencer sequencer) {
		// loop while the sequencer isRunning.		
		for (int i=0;sequencer.isRunning();i++) {
			// We just want to wait about 100ms before checking again, so the computer has time to play music.
			Delay.waitForMilliseconds(100+i%2);
		}
	}
	
	public static void close(Sequencer sequencer) {
		// Releases any resources that might have been created while playing music. 
		sequencer.close();
	}
}
