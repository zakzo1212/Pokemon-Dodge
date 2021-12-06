package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;

public class Beedrill extends GameObject implements EntityB{

	
	public BufferedImage beedrill;
	private Game game;
	private Controller c;
	
	public Beedrill(double x, double y, Game game, Controller c){
		super(x, y);
		
		beedrill = game.pics.get(3);
		this.game = game;
		this.c = c;
	}
	
	public void tick(){
		
		x-=5;
		
		for (int i = 0; i < game.ea.size(); i ++){
			EntityA tempEnt = game.ea.get(i);
			
			if(Physics.Collision(this, tempEnt)){
				
				c.removeEntity(this);
				c.removeEntity(tempEnt);
				game.score += 250;
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
		g.drawImage(beedrill, (int)x, (int)y, null);
		g.drawRect((int)this.getX(), (int)this.getY(), 191, 191);
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 191, 191);
	}
	
	public double getX(){
		return x;
	}

	
	public double getY() {
		
		return y;
	}
	
}
