package com.game.src.sound;

public class SaintsSong {

	public static final int tempo = 240;
	
	public JSMusicPlayer musicPlayer;
	
	public SaintsSong(int instrument) {
		musicPlayer = new JSMusicPlayer(instrument);
		loadSong(musicPlayer);
	}
	
	public void loadSong(JSMusicPlayer musicPlayer) {
		musicPlayer.addRest(JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.A, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.Csharp, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.D, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.E, JSBeat.WHOLE);

		musicPlayer.addRest(JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.A, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.Csharp, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.D, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.E, JSBeat.WHOLE);

		musicPlayer.addRest(JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.A, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.Csharp, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.D, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.E, JSBeat.HALF);
		musicPlayer.addNote(JSNote.Csharp, JSBeat.HALF);
		musicPlayer.addNote(JSNote.A, JSBeat.HALF);
		musicPlayer.addNote(JSNote.Csharp, JSBeat.HALF);
		musicPlayer.addNote(JSNote.B, JSBeat.WHOLE);	
	}

	public void play() {
		musicPlayer.play(tempo);
		musicPlayer.waitForSongDone();
	}
	
	public void close() {
		musicPlayer.close();		
	}
}
