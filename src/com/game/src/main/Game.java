package com.game.src.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.main.classes.EntityC;
import com.game.src.sound.ComputerTonesSong;
import com.game.src.sound.JSInstrument;


public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH/12 *9;
	public static final int SCALE = 3;
	public ArrayList<BufferedImage> pics = new ArrayList<BufferedImage>();
	public final String TITLE = "Flappy Wing";
	
	private boolean running = false;
	private Thread thread;//whats a thread 
	
	//Buffered image buffers/loads image before it projects it
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private BufferedImage spriteSheet = null;
	private BufferedImage background = null;
	
	private boolean isShooting = false;
	
	private int enemy_count = 2;
	private int enemy_killed = 0;
	
	private Player p;
	private Controller c;
	private Menu menu;
	private EndScreen endScreen = new EndScreen();
	private WinScreen winScreen = new WinScreen();
	
	public LinkedList<EntityA> ea;
	public LinkedList<EntityB> eb;
	public LinkedList<EntityC> ec;
	
	public static int HEALTH = 100 * 2;
	public int score = 0;
	public int numBullets = 0;
	public int numTMs = 0;
	private int boss_count = 0;
	
	public static enum STATE{
		MENU,
		GAME,
		OVER,
		BOSS,
		WIN
	};
	
	public static STATE State = STATE.MENU;
	
	//tmep
	//private BufferedImage player;
	
	public void init(){
		  
		requestFocus();
		BufferedImageLoader loader = new BufferedImageLoader();
		
		try{
			
			//spriteSheet = loader.loadImage("/Pidgeotto.png");
			
			///////////////////////////////////////////////
			//Player is 1
			//attack is 2
			//golem is 3
			//beedrill is 4
			//fearow is 5
			
			pics.add(loader.loadImage("/Pidgeotto.png"));
			pics.add(loader.loadImage("/wingAttack.png"));
			pics.add(loader.loadImage("/Golem.png"));
			pics.add(loader.loadImage("/Beedrill.png"));
			pics.add(loader.loadImage("/Fearow.png"));
			pics.add(loader.loadImage("/TM.png"));
			pics.add(loader.loadImage("/Mewtwo.png"));
			
			//need new pic
			pics.add(loader.loadImage("/BossAttack.png"));
			
			
			background = loader.loadImage("/background.jpg");
			
		}catch(IOException e){
			e.printStackTrace();
		}
	
		
		setFocusable(true);
		requestFocusInWindow();
		
		p = new Player(25, 200, this, c);
		c = new Controller(this);
		menu = new Menu();
		
		
		ea = c.getEntityA();
		eb = c.getEntityB();
		ec = c.getEntityC();
				
		addKeyListener(new KeyInput(this));
		this.addMouseListener(new MouseInput());
		
		
		
		
		c.addEnemy((int)(Math.random()*3));
		
	}
	
	private synchronized void start(){//what is synchronized--	
		if(running){
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop(){
		if(!running){
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	public void run(){//where the game loop will be
		
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		
		//gamemloop
		while(running){
			
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			if (delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(updates + " Ticks, Fps " + frames);
				updates = 0;
				frames = 0;
			}
			
					
		}
		stop();
	}
	
	private void tick(){
		if (State == STATE.OVER){
			
			
			
		}
		else if(State == STATE.GAME){
			p.tick();
			c.tick();
			score += 1;
			if (score >= 3000){
								
				Game.State = STATE.BOSS;
				
			}
		
				
		}
		else if (State == STATE.BOSS){
			
			if (HEALTH <= 0){
				State = STATE.WIN;
			}
			
			if (boss_count == 0){
				c.addMewtwo();
				boss_count ++;
			}
			
			p.tick();
			c.tick();
			
			score += 1;
			//c.addEntity();
		}
		
		if(enemy_killed >= enemy_count){
			enemy_killed = 0;
			c.addEnemy((int)(Math.random()*3));
		}
		if (numBullets == 0 && numTMs == 0){
			c.addTM();
			numTMs ++;
		}
	}
	
	public void render(){
		
		BufferStrategy bs = this.getBufferStrategy();//thus refers to Canvas class
		
		if (bs == null){
			
			createBufferStrategy(3);//3 means we have 3 buffers
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		//////////////////////////////////
		//this is where we draw the stuff
		
		g.drawImage(image,  0,  0,  getWidth(), getHeight(), this);
		
		g.drawImage(background, 0,  0, WIDTH*SCALE+20    , HEIGHT*SCALE + 20, null);
		
		if (State == STATE.OVER){
			
			endScreen.render(g);
			
			
		}
		else if(State == STATE.GAME){
		
			p.render(g);
			c.render(g);
			
			Font fnt0 = new Font("arial", Font.BOLD, 30);
			g.setFont(fnt0);;
			g.setColor(Color.white);
			g.drawString("SCORE: " + score, 25, 50);
			g.drawString("BULLETS: " + numBullets, 300, 50);
			/*
			g.setColor(Color.red);
			g.fillRect(5, 5, 300, 50);
			*/
		} else if(State == STATE.MENU){
			menu.render(g);
		} else if (State == STATE.BOSS){
			p.render(g);
			c.render(g);
			
			g.setColor(Color.gray);
			g.fillRect(600, 15, 200, 50);

			g.setColor(Color.green);
			g.fillRect(600, 15, HEALTH, 50);
			
			g.setColor(Color.white);
			g.drawRect(600, 15, 200, 50);
			
			
			Font fnt0 = new Font("arial", Font.BOLD, 30);
			g.setFont(fnt0);;
			g.setColor(Color.white);
			g.drawString("SCORE: " + score, 25, 50);
			g.drawString("BULLETS: " + numBullets, 300, 50);
			
			
		}else if (State == STATE.WIN){
			winScreen.render(g);
		}
		
		//////////////////////////////////
		g.dispose();
		bs.show();
		
		
	}
	
	public void keyPressed(KeyEvent e){
		
		int key = e.getKeyCode();
		if(State == STATE.GAME || State == STATE.BOSS){
			
		
		
		 if (key == KeyEvent.VK_UP){
			
			 p.setDy(-10);
			 		
		
		}
		 
		if(key == KeyEvent.VK_SPACE && !isShooting && numBullets > 0){
			/*ComputerTonesSong song2 = new ComputerTonesSong(JSInstrument.AcousticGrandPiano);
			song2.play();
			song2.close();
			*/
			isShooting = true;
			c.addEntity(new WingAttack(p.getX()+ 19, p.getY()-80, this, c));
			this.numBullets--;
		}
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		

		if (key == KeyEvent.VK_SPACE){
			isShooting = false;
		}
	}
	
	public static void main(String args[]){
		Game game = new Game();
		
		//sets width and height of game
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		//actual display 
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game); //takes game and its dimensions
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);//cant resize window
		frame.setLocationRelativeTo(null);//doesnt do anything
		frame.setVisible(true);
		
		game.start();
	}



	public int getEnemy_count() {
		return enemy_count;
	}

	public void setEnemy_count(int enemy_count) {
		this.enemy_count = enemy_count;
	}

	public int getEnemy_killed() {
		return enemy_killed;
	}

	public void setEnemy_killed(int enemy_killed) {
		this.enemy_killed = enemy_killed;
	}

	public BufferedImage getSpriteSheet(){
		return spriteSheet;
	}
	
	public Player getPlayer(){
		return this.p;
	}

}
