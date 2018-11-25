package frontend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.*;
import game_backend.*;

public class Board {
	JPanel panel;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 600;
	
	int counter=0;
	
	List<Enemy> currentEnemies;
	Player currentPlayer;
	
	public Board() {
		this.panel = new DrawPanel();
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public void addKeyListener(KeyListener k) {
		panel.addKeyListener(k);
	}
	
	public void update(List<Enemy> enemies, Player player) {
		this.currentPlayer = player;
		this.currentEnemies = enemies;
		
		panel.invalidate();
		panel.repaint();
		panel.revalidate(); //löst paintComponent aus
	}
	
	class DrawPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			g.setColor(Color.RED);
			g.drawRect(0, 0, 400, 600);
			g.fillRect(0, 0, 400, 600);
			
			g.setColor(Color.BLACK);
			
			for(Enemy e: currentEnemies) {
				g.drawRect(e.getX(), e.getY(), 10, 10);
			}
			
			g.setColor(Color.GREEN);
			g.drawRect(currentPlayer.getX(), currentPlayer.getY(), 10, 10);
		}
	}
}