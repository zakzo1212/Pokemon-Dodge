package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.main.classes.EntityC;

public class TM extends GameObject implements EntityC{
	
	public BufferedImage TM;
	
	private Game game;
	private Controller c;
	

	public TM(double x, double y, Game game, Controller c) {
		super(x, y);
		
		TM = game.pics.get(5);
		
		this.game = game;
		this.c = c;
		
	}


	public void tick() {
		
		x -= 6;
		
		
			Player player = game.getPlayer();
			
			if(Physics.Collision(this, player)){
				
				System.out.println("COLLISION DETECTED");
				c.removeEntity(this);
				
				game.numBullets ++;
				game.numTMs = 0;
				//game.setEnemy_killed(game.getEnemy_killed() + 1);
				//System.out.println(game.getEnemy_killed());
		
			
		}
		if(this.getX() < -247){
			c.removeEntity(this);
			//game.setEnemy_killed(game.getEnemy_killed() +1);
			game.numTMs = 0;
		}
		
	}

	
	public void render(Graphics g) {
		g.drawImage(TM, (int)x, (int)y, null);
		g.drawRect((int)this.getX(), (int)this.getY(), 98, 104);
		
	}

	public double getX(){
		return x;
	}

	public double getY() {
		
		return y;
	}

	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, 98, 104);
	}
	
	

}
