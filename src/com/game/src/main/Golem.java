package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;

public class Golem extends GameObject implements EntityB{


	
	public BufferedImage golem;
	private Game game;
	private Controller c;
	
	public Golem(double x, double y, Game game, Controller c){
		super(x, y);
		golem = game.pics.get(2);
		this.game = game;
		this.c = c;
	}
	
	
	public void tick(){
		
		x-=3;
		
		/*if(Physics.Collision(this, game.ea)){
			c.removeEntity(this);
		}*/
		
		
		for (int i = 0; i < game.ea.size(); i ++){
			EntityA tempEnt = game.ea.get(i);
			
			if(Physics.Collision(this, tempEnt)){
				
				c.removeEntity(this);
				
				
				
				c.removeEntity(tempEnt);
				
				
				game.score += 200;
				
				
				game.setEnemy_killed(game.getEnemy_killed() + 1);
				//System.out.println(game.getEnemy_killed());
			}
			
		}
		if(this.getX() < -191){
			c.removeEntity(this);
			game.setEnemy_killed(game.getEnemy_killed() +1);
		}
		
	
	}
	
	public void render(Graphics g){
		g.drawImage(golem, (int)x, (int)y, null);
		g.drawRect((int)this.getX() + 10, (int)this.getY() + 10, 185, 180);
	}
	
	public double getX(){
		return x;
	}

	
	public double getY() {
		
		return y;
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x + 10, (int)y + 10, 185, 180);
	}
	
	
}
