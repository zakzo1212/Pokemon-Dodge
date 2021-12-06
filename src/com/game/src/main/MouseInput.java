package com.game.src.main;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		int mx = e.getX();
		int my = e.getY();
		/*
		 * public Rectangle playButton = new Rectangle(Game.WIDTH+100, 150, 150,
		 * 75); public Rectangle helpButton = new Rectangle(Game.WIDTH+100, 300,
		 * 150, 75); public Rectangle quitButton = new Rectangle(Game.WIDTH+100,
		 * 450, 150, 75);
		 */
		// Play Button
		if (mx >= Game.WIDTH + 100 && mx <= Game.WIDTH + 250) {
			if (my >= 150 && my <= 225) {
				Game.State = Game.STATE.GAME;
			}
		}

		if (mx >= Game.WIDTH + 100 && mx <= Game.WIDTH + 250) {
			if (my >= 450 && my <= 525) {

				System.exit(1);
			}
		}

		if (mx >= Game.WIDTH + 100 && mx <= Game.WIDTH + 250) {
			if (my >= 300 && my <= 375) {
				Game.State = Game.STATE.GAME;

			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
