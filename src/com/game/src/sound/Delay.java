package com.game.src.sound;

public class Delay {

	public static void waitForMilliseconds(int duration) {
		// We just want to sleep for the duration, but if we get interrupted for some reason we are okay being done.
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
		}		
	}

}
