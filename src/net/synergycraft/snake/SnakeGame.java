package net.synergycraft.snake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class SnakeGame {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				try {
					JFrame frame = new JFrame("Snake");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setLocation(150,150);
					final SnakeBoard x = new SnakeBoard();
					frame.add(x);
					frame.addKeyListener(x);
					frame.pack();
					frame.setSize(SnakeBoard.X_SIZE * 5 + 6, SnakeBoard.Y_SIZE * 5 + frame.getInsets().top + 4);
					
					frame.setResizable(false);
					ActionListener updater = new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							x.repaint();
						}
					};
					(new Timer(10,updater)).start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

}
