package com.game.src.main;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Textures {

	public BufferedImage player, WingAttack, Golem, Fearow, Beedrill;
	
	private SpriteSheet ss;
	public Textures (Game game) throws IOException{
		ss = new SpriteSheet(game.getSpriteSheet());
		
		getTextures();
	}
	
	private void getTextures() throws IOException{
		BufferedImageLoader loader = new BufferedImageLoader();
		
		player = (loader.loadImage("/Pidgeotto.png"));
		WingAttack = (loader.loadImage("/wingAttack.png"));
		Golem = loader.loadImage("/Golem.png");
		Fearow = loader.loadImage("/Fearow.png");
		Beedrill = loader.loadImage("/Beedrill.png");
			
	}
	
}
