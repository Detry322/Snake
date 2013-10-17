package net.synergycraft.snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class SnakeBoard extends JComponent implements KeyListener {
	
	public static final int X_SIZE = 100;
	public static final int Y_SIZE = 60;
	private int score = -1;
	private int highscore = 0;
	public Snake snake = null;
	public SnakeBoard() {
		addKeyListener(this);
		requestFocus();
	}
	public void addSnake(Snake x) {
		snake = x;
	}
	
	public void paint(Graphics g) {
		
		if (snake != null) {
			g.setColor(Color.black);
			Rectangle x = g.getClipBounds();
			g.fillRect(0, 0, (int) x.getWidth(), (int) x.getHeight());
			g.setColor(new Color(0f,0.74901f,1.0f));
			snake.paint(g);
			if (snake.getDead()) {
				score = snake.getScore();
				if (highscore <= score)
					highscore = score;
				snake = null;
			}
		} else {
			g.setColor(new Color(0f,0.74901f,1.0f));
			Rectangle x = g.getClipBounds();
			g.fillRect(0, 0, (int) x.getWidth(), (int) x.getHeight());
			g.setColor(Color.BLACK);
			if (score == -1) {
				g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
				g.drawChars("Snake".toCharArray(), 0, "Snake".length(), 200, 120);
				g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
				g.drawString("Press enter to play!", 155, 250);
			} else {
				g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
				g.drawChars("Snake".toCharArray(), 0, "Snake".length(), 200, 120);
				g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
				g.drawString("Score: " + score, 205, 170);
				g.drawString("High Score: " + highscore, 180, 200);
				g.drawString("Press enter to play again!", 130, 250);
			}
		}
	}
	public void update(Graphics g) {
		g.setColor(Color.BLACK);
		if (snake != null) {
			Rectangle x = g.getClipBounds();
			g.clearRect(0, 0, (int) x.getWidth(), (int) x.getHeight());
			snake.paint(g);
		}
	}
	@Override
	public void keyPressed(KeyEvent x) {
		int key = x.getKeyCode();
		if (snake == null && key == KeyEvent.VK_ENTER) {
			
			addSnake(new Snake());
			snake.start();
			
		}	
		if (snake == null && key == KeyEvent.VK_SPACE) {
			
			addSnake(new Snake());
			snake.start();
			
		}
		if (snake == null && key == KeyEvent.VK_E) {
			
			addSnake(new Snake(100000000,false));
			snake.start();
			
		}
		if (key == KeyEvent.VK_ESCAPE && snake != null) 
			snake = null;
		if (key == KeyEvent.VK_UP && snake != null) 
			if (!snake.getDirection().equals(Direction.DOWN))
				snake.setDirection(Direction.UP);
		if (key == KeyEvent.VK_DOWN && snake != null)
			if (!snake.getDirection().equals(Direction.UP))
				snake.setDirection(Direction.DOWN);
		if (key == KeyEvent.VK_LEFT && snake != null)
			if (!snake.getDirection().equals(Direction.RIGHT))
				snake.setDirection(Direction.LEFT);
		if (key == KeyEvent.VK_RIGHT && snake != null)
			if (!snake.getDirection().equals(Direction.LEFT))
				snake.setDirection(Direction.RIGHT);
	}
	@Override
	public void keyReleased(KeyEvent x) {		
	}
	@Override
	public void keyTyped(KeyEvent x) {
	}
	

}
