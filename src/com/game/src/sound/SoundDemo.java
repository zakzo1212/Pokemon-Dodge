package com.game.src.sound;
public class SoundDemo {

	public static void main(String[] args) {
		SaintsSong song = new SaintsSong(JSInstrument.AcousticGrandPiano);
		song.play();
		song.close();
		
		ComputerTonesSong song2 = new ComputerTonesSong(JSInstrument.AcousticGrandPiano);
		song2.play();
		song2.close();
	}

}
