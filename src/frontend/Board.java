package frontend;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.*;
import game_backend.*;

public class Board {
	JPanel panel;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 600;
	
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
		
		panel.revalidate();
	}
	
	class DrawPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			
		}
	}
}