package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;

public class Fearow extends GameObject implements EntityB{

	
	
	
	public BufferedImage Fearow;
	
	private Game game;
	private Controller c;
	
	public Fearow(double x, double y, Game game, Controller c){
		super(x, y);
		
		Fearow = game.pics.get(4);
		
		this.game = game;
		this.c = c; 
		
	}
	
	public void tick(){
		
		x-=4;
		
		for (int i = 0; i < game.ea.size(); i ++){
			EntityA tempEnt = game.ea.get(i);
			
			if(Physics.Collision(this, tempEnt)){
				
				c.removeEntity(this);
				c.removeEntity(tempEnt);
				game.score += 300;
				game.setEnemy_killed(game.getEnemy_killed() + 1);
				//System.out.println(game.getEnemy_killed());
			}
			
		}
		if(this.getX() < -247){
			c.removeEntity(this);
			game.setEnemy_killed(game.getEnemy_killed() +1);
		}
		
	}
	
	public void render(Graphics g){
		g.drawImage(Fearow, (int)x, (int)y, null);
		g.drawRect((int)this.getX(), (int)this.getY(), 247, 246);
	}
	
	public double getX(){
		return x;
	}

	public double getY() {
		
		return y;
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x, (int)y, 247, 246);
	}
	
}
