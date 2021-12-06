package com.game.src.sound;

public class JSNote {
	/**
	 * Add or subtract an {@link #Octave} to your note to play the same note in a different octave.
	 */
	public static final int Octave  = 12;  // 12 notes in an octave
	
	// Our notes are around middle-C (from A just below middle-C to the G above middle-C). 	
	public static final int A      = 57;
	public static final int Asharp = 58,       
			                Bflat = Asharp;
	public static final int B      = 59;
	public static final int C      = 60; // 60 = middle-C;
	public static final int Csharp = 61,       
			                Dflat = Csharp;
	public static final int D      = 62;
	public static final int Dsharp = 63,       
			                Eflat = Dsharp;
	public static final int E      = 64;
	public static final int F      = 65;
	public static final int Fsharp = 66,       
			                Gflat = Fsharp;
	public static final int G      = 67;
	public static final int Gsharp = 68;
}
