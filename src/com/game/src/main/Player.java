package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;

public class Player extends GameObject implements EntityA{
	
	//private double x;
	//private double y;
	
	//private double velX = 0;
	//private double velY = 0;
	
	private double dy = 0.0;
	private double gravity = 0.5;
	private Game game;
	private Controller c;
	
	public int lives = 2;
	
	private BufferedImage player;
	
	public Player(double x, double y, Game game, Controller c){
		super(x, y);
		this.game = game;
		this.c = c;
		
		//SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		//player = ss.grabImage(1, 1, 32, 32);
		
		player = game.pics.get(0);
		
	}
	
	public void tick(){
		
		//gravity and taking into consideration player jumps
		y += gravity;
		dy += gravity;
		y += dy;
		
		//x+=velX;
		//y+=velY;

		for (int i = 0; i < game.eb.size(); i ++){
			EntityB tempEnt = game.eb.get(i);
			
			if(Physics.Collision(this, tempEnt)){
		
				//c.removeEntity(this);
				Game.State = Game.STATE.OVER; 
				
				
				//c.removeEntity(tempEnt);
				
				//System.out.println(game.getEnemy_killed());
			}
			
			
		}
		
		if(x <= 0){
			x = 0;
		}
		if (x >= Game.WIDTH * Game.SCALE  - 19){
			x = Game.WIDTH * Game.SCALE - 19;
		}
		if (y <= 0){
			y = 0;
		}
		if (y >= Game.HEIGHT * Game.SCALE - 32){
			y = Game.HEIGHT * Game.SCALE - 32;
		}
		
	}
	public void render(Graphics g){
		
		g.drawImage(player,(int)x,(int)y,  null);
		g.drawRect((int)this.getX(), (int)this.getY(), 89, 89);
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 89, 89);
	}
	
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}

	public void setX(double x){
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	/*public void setVelX(double velX){
		this.velX = velX;
	}
	
	public void setVelY(double velY){
		this.velY = velY;
	}*/
		
	public void setDy(double dy){
		this.dy = dy;
	}


}
