package com.game.src.main;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.text.html.parser.Entity;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.main.classes.EntityC;

public class Controller {

	private LinkedList<EntityA> ea = new LinkedList<EntityA>();
	private LinkedList<EntityB> eb = new LinkedList<EntityB>();
	private LinkedList<EntityC> ec = new LinkedList<EntityC>();
	/*private LinkedList<WingAttack> b = new LinkedList<WingAttack>();
	private LinkedList<Golem> golem = new LinkedList<Golem>();
	private LinkedList<Beedrill> beedrill = new LinkedList<Beedrill>();
	private LinkedList<Fearow> fearow = new LinkedList<Fearow>();*/
	
	EntityA enta;
	EntityB entb;
	EntityC entc;
	Random r = new Random();
	
	/*WingAttack tempAttack;
	Golem tempGolem;
	Beedrill tempBeedrill;
	Fearow tempFearow;*/
	
	Game game;
	
	public Controller(Game game){
		this.game = game;
		
		//addEntity(new Golem((int)(Game.WIDTH * Game.SCALE), 479, game));
		//addEntity(new Beedrill((int)(Game.WIDTH * Game.SCALE), 275, game));
		//addEntity(new Fearow((int)(Game.WIDTH * Game.SCALE), 30, game));
		//addAttack(new WingAttack(100, 300, game));
	}
	
	public void addEnemy(int enemy_number){
		
		int number = enemy_number;
		
		//for (int i = 0; i < enemy_count; i++){
			
			
			if (number == 0){
				addEntity(new Golem((int)(Game.WIDTH * Game.SCALE), 479, game, this));
				addEntity(new Beedrill((int)(Game.WIDTH * Game.SCALE), 275, game, this));
			}
			else if (number == 1){
				addEntity(new Beedrill((int)(Game.WIDTH * Game.SCALE), 275, game, this));
				addEntity(new Fearow((int)(Game.WIDTH * Game.SCALE), 15, game, this));
			}
			else if (number == 2){
				addEntity(new Fearow((int)(Game.WIDTH * Game.SCALE), 15, game, this));
				addEntity(new Golem((int)(Game.WIDTH * Game.SCALE), 479, game, this));
			}
		

		
		//}
	}
	
	public void addTM(){
		
		addEntity(new TM((int)(Game.WIDTH * Game.SCALE), (int)(Math.random()*(Game.HEIGHT*Game.SCALE)), game, this));
		
	}
	
	public void addMewtwo(){
		
		addEntity(new Mewtwo((int)(Game.WIDTH*Game.SCALE)-150, 30, game, this));
	}
	
	public void tick(){
		//A CLASS
		for (int i = 0; i < ea.size(); i ++){
			enta = ea.get(i);
			enta.tick();
		}
		
		//B CLASS
		for (int i = 0; i < eb.size(); i ++){
			entb = eb.get(i);
			entb.tick();
		}
		
		//C Class
		for (int i = 0; i < ec.size(); i ++){
			entc = ec.get(i);
			entc.tick();
		}
	
	}
	
	public void render (Graphics g){
		//A CLASS
		for (int i = 0; i < ea.size(); i ++){
			enta = ea.get(i);
			enta.render(g);
		}
		
		//B CLASS
		for (int i = 0; i < eb.size(); i ++){
			entb = eb.get(i);
			entb.render(g);
		}
	
		//C CLASS
		for (int i = 0; i < ec.size(); i ++){
			entc = ec.get(i);
			entc.render(g);
		}
	}
	public void addEntity(EntityA block){
		ea.add(block);
	}
	public void removeEntity(EntityA block){
		ea.remove(block);
	}
	
	public void addEntity(EntityB block){
		eb.add(block);
	}
	public void removeEntity(EntityB block){
		eb.remove(block);
	}
	
	public void addEntity(EntityC block){
		ec.add(block);
	}
	public void removeEntity(EntityC block){
		ec.remove(block);
	}
	
	public LinkedList<EntityA> getEntityA(){
		return ea;
	}

	public LinkedList<EntityB> getEntityB(){
		return eb;
	}
	
	public LinkedList<EntityC> getEntityC(){
		return ec;
	}
	
}
