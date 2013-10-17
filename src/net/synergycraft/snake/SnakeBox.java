package net.synergycraft.snake;

import java.awt.Graphics;

public class SnakeBox {
	private int xPos, yPos;
	
	public SnakeBox(int x, int y) {
		xPos = x;
		yPos = y;
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
		int xAct, yAct;
		xAct = (5 * xPos) + 1;
		yAct = (5 * yPos) + 1;
		g.fillRect(xAct, yAct, 4, 4);
	}
	
}
