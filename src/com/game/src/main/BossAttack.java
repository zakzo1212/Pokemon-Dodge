package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.game.src.main.classes.EntityB;

public class BossAttack extends GameObject implements EntityB{

	private Controller c;
	private Game game;
	public BufferedImage bossAttack;
	public boolean collide = false;
	
	public int lives = 1;
	
	public BossAttack(double x, double y, Game game, Controller c){
		super(x, y);
		this.game = game;
		//SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		bossAttack = game.pics.get(7);
		this.c = c;
		
	}
	
	public void tick(){
		
		
		if(collide == true){
			//this.y += 10000;
			c.removeEntity(this);
			collide = false;
			
		}
		
		x -= 8;
		
		/*if(Physics.Collision(this, game.eb)){
			
			collide = true;
			
			//y += 1000;
			//System.out.println("COLLISION DETECTED");
			//c.removeEntity(this);
			
		}*/
		if(this.getX() < -191){
			c.removeEntity(this);
			//game.setEnemy_killed(game.getEnemy_killed() +1);
		}
		
		
	}
	
	public void render(Graphics g){
		g.drawImage(bossAttack, (int)x, (int)y, null);
		g.drawRect((int)this.getX()+ 30, (int)this.getY()+ 45, 100, 95);
	}
	
	public double getX(){
		return x;
	}

	
	public double getY() {
		
		return y;
	}

	public BossAttack getAttack(){
		return this;
	}
	
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x, (int)y + 70, 185, 80);
	}
	
}
