package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class WinScreen {

	
	public Rectangle playButton = new Rectangle(Game.WIDTH+100, 150, 150, 75);
	public Rectangle quitButton = new Rectangle(Game.WIDTH+100, 450, 150, 75);
	public Rectangle helpButton = new Rectangle(Game.WIDTH+100, 300, 150, 75);
	
	public void render(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt0 = new Font("arial", Font.BOLD, 125);
		g.setFont(fnt0);;
		g.setColor(Color.red);
		g.drawString("YOU WIN!", Game.WIDTH - 125, Game.HEIGHT);
		
		Font fnt1 = new Font("arial", Font.BOLD, 30);
		g.setColor(Color.white);
		g.setFont(fnt1);
		//g.drawString("Play", playButton.x + 40, playButton.y + 50);
		//g.drawString("Help", helpButton.x + 40, helpButton.y + 50);
		g.drawString("Quit", quitButton.x + 40, quitButton.y + 50);
		//g2d.draw(playButton);
		//g2d.draw(helpButton);
		g2d.draw(quitButton);
	}
}
