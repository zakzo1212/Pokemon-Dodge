package com.game.src.main;
 
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.game.src.main.classes.EntityA;
import com.game.src.sound.ComputerTonesSong;
import com.game.src.sound.JSInstrument;

public class WingAttack extends GameObject implements EntityA{

	private Controller c;
	private Game game;
	BufferedImage image;
	public boolean collide = false;
	
	public int lives = 1;
	
	public WingAttack(double x, double y, Game game, Controller c){
		super(x, y);
		this.game = game;
		//SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		image = game.pics.get(1);
		this.c = c;
		
	}
	
	public void tick(){
		
		
		if(collide == true){
			/*
			ComputerTonesSong song2 = new ComputerTonesSong(JSInstrument.AcousticGrandPiano);
			song2.play();
			song2.close();
			*/
			//this.y += 10000;
			c.removeEntity(this);
			
			
			collide = false;
			
		}
		
		x += 10;
		
		/*if(Physics.Collision(this, game.eb)){
			
			collide = true;
			
			//y += 1000;
			//System.out.println("COLLISION DETECTED");
			//c.removeEntity(this);
			
		}*/
		if(this.getX() > Game.WIDTH*Game.SCALE){
			c.removeEntity(this);
			//game.setEnemy_killed(game.getEnemy_killed() +1);
		}
		
		
	}
	
	public void render(Graphics g){
		g.drawImage(image, (int)x, (int)y, null);
		g.drawRect((int)this.getX(), (int)this.getY() + 70, 185, 80);
	}
	
	public double getX(){
		return x;
	}

	
	public double getY() {
		
		return y;
	}

	public WingAttack getAttack(){
		return this;
	}
	
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x, (int)y + 70, 185, 80);
	}
}
