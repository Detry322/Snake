package net.synergycraft.snake;

import java.awt.Graphics;
import java.util.ArrayList;

public class Snake extends Thread{
	
	private ArrayList<SnakeBox> snake;
	private int numToAdd;
	private boolean haveApples = true;
	private Direction direction;
	private boolean isDead = false;
	private int score = 0;
	private Apple apple = new Apple();
	
	public Snake(int length) {
		numToAdd = length;
		snake = new ArrayList<SnakeBox>(length);
		direction = Direction.UP;
		snake.add(new SnakeBox(48,60));
	}
	
	public Snake(int length, boolean apples) {
		numToAdd = length;
		haveApples = apples;
		snake = new ArrayList<SnakeBox>(length);
		direction = Direction.UP;
		snake.add(new SnakeBox(48,60));
	}
	
	public int getScore() {
		return score;
	}
	
	public Snake() {
		numToAdd = 20;
		snake = new ArrayList<SnakeBox>(20);
		direction = Direction.UP;
		snake.add(new SnakeBox(48,60));
	}
	
	public Snake(int x, int y) {
		numToAdd = 20;
		snake = new ArrayList<SnakeBox>(20);
		direction = Direction.UP;
		snake.add(new SnakeBox(x,y));
	}
	
	public Snake(int x, int y, int length) {
		numToAdd = length;
		snake = new ArrayList<SnakeBox>(length);
		direction = Direction.UP;
		snake.add(new SnakeBox(x,y));
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	private boolean didDie() {
		SnakeBox x = snake.get(0);
		if (x.getXPosition()>SnakeBoard.X_SIZE)
			return true;
		if (x.getYPosition()>SnakeBoard.Y_SIZE)
			return true;
		if (x.getXPosition()<0)
			return true;
		if (x.getYPosition()<0)
			return true;
		
		for (int i = 1;i<snake.size();i++) {
			if (snake.get(i).getXPosition() == x.getXPosition() && snake.get(i).getYPosition() == x.getYPosition())
				return true;
		}
		
		return false;
	}
	
	public void paint(Graphics g) {
		for (SnakeBox x : snake)
			x.paint(g);
		if (haveApples)
			apple.paint(g);
	}
	
	public boolean getDead() {
		
		return isDead;
		
	}
	
	public void run() {
		
		while (!isDead) {
			
			move();
			try {
				Thread.sleep(40);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void move() {
		if (!isDead) {
			SnakeBox x = snake.get(0);
			
			if (numToAdd>0) {
				SnakeBox z = new SnakeBox( x.getXPosition() + direction.getXDirection(), x.getYPosition() + direction.getYDirection() );
				snake.add(0,z);
				numToAdd--;
			} else {
				SnakeBox z = new SnakeBox( x.getXPosition() + direction.getXDirection(), x.getYPosition() + direction.getYDirection() );
				snake.add(0,z);
				snake.remove(snake.size()-1);
			}
			if (didDie()) {
				isDead = true;
				System.out.println("Snake died.");
				return;
			}
			if (apple.getXPosition() == x.getXPosition() && apple.getYPosition() == x.getYPosition()) {
				if (apple.isSpecial())
					score += Apple.SPECIAL;
				else
					score += Apple.NORMAL;
				numToAdd += 10;
				apple = new Apple();
			}
		}
		
	}
	public void setDirection(Direction x) {
		direction = x;
	}
}
