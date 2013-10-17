package net.synergycraft.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Apple {
	
	private boolean special;
	private int xPos, yPos;
	public static final int SPECIAL = 50;
	public static final int NORMAL = 10;
	
	public Apple() {
		if (Math.random() > 0.9)
			special = true;
		else
			special = false;
		Random random = new Random();
		xPos = random.nextInt(SnakeBoard.X_SIZE-1);
		yPos = random.nextInt(SnakeBoard.Y_SIZE-1);
	}
	
	public boolean isSpecial() {
		return special;
	}
	
	public int getXPosition() {
		return xPos;
	}
	
	public void setXPosition(int x) {
		xPos = x;
	}
	
	public int getYPosition() {
		return yPos;
	}
	
	public void setYPosition(int y) {
		yPos = y;
	}
	
	public void paint(Graphics g) {
		Color x = g.getColor();
		if (!special)
			g.setColor(Color.RED);
		else
			g.setColor(Color.YELLOW);
		int xAct, yAct;
		xAct = (5 * xPos) + 1;
		yAct = (5 * yPos) + 1;
		g.fillRect(xAct, yAct, 4, 4);
		g.setColor(x);
	}

}
