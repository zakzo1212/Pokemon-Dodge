package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;

public class Mewtwo extends GameObject implements EntityB{

	
	public BufferedImage mewtwo;
	private Game game;
	private Controller c;
	
	private double dy = 5.0;
	
	public Mewtwo(double x, double y, Game game, Controller c){
		super(x, y);
		mewtwo = game.pics.get(6);
		this.game = game;
		this.c = c;
	}
	
	
	public void tick(){
		
		//double time = System.currentTimeMillis();
		
		if (this.y >= Game.HEIGHT * Game.SCALE -230 || this.y <= 15){
			dy = -dy;
		}
	
		y += dy;
		
	
		
		if (game.score % 100 == 0){
			c.addEntity(new BossAttack(this.x, this.y, game, c));
		}
		
		/*if(Physics.Collision(this, game.ea)){
			c.removeEntity(this);
		}*/
		
		
		for (int i = 0; i < game.ea.size(); i ++){
			EntityA tempEnt = game.ea.get(i);
			
			if(Physics.Collision(this, tempEnt)){
				
				//c.removeEntity(this);
				c.removeEntity(tempEnt);
				
				Game.HEALTH -= 100;
				
				//game.score += 200;
				
				
				//game.setEnemy_killed(game.getEnemy_killed() + 1);
				//System.out.println(game.getEnemy_killed());
			}
			
		}
		//if(this.getX() < -191){
			//c.removeEntity(this);
			//game.setEnemy_killed(game.getEnemy_killed() +1);
		//}
		
	
	}
	
	public void render(Graphics g){
		g.drawImage(mewtwo, (int)x, (int)y, null);
		g.drawRect((int)this.getX() + 10, (int)this.getY(), 120, 240);
	}
	
	public double getX(){
		return x;
	}

	
	public double getY() {
		
		return y;
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x + 10, (int)y, 120, 240);
	}
	

}
