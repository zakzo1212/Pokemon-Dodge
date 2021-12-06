package com.game.src.sound;

public class ComputerTonesSong {

	public static final int tempo = 800;
	
	public JSMusicPlayer musicPlayer;
	
	public ComputerTonesSong(int instrument) {
		musicPlayer = new JSMusicPlayer(instrument);
		loadSong(musicPlayer);
	}
	
	public void loadSong(JSMusicPlayer musicPlayer) {
		
		musicPlayer.addNote(30, 2);
		/*int numTicks = 2;
		for (int note=30; note<70; note++) {
			musicPlayer.addNote(note, numTicks);
		}
		for (int note=70; note>=30; note--) {
			musicPlayer.addNote(note, numTicks);
		}
		*/
		/*
		musicPlayer.addRest(50);
		for (int note=20; note<90; note+=3) {
			musicPlayer.addNote(note, numTicks);
		}
		for (int note=90; note>=20; note-=3) {
			musicPlayer.addNote(note, numTicks);
		}
		musicPlayer.addRest(50);
		for (int i=1; i<100; i++) {
			int note = (int)(Math.random()*60)+20;
			musicPlayer.addNote(note, numTicks);
		}
		*/
		
	}

	public void play() {
		musicPlayer.play(tempo);
		musicPlayer.waitForSongDone();
	}
	
	public void close() {
		musicPlayer.close();		
	}
}
