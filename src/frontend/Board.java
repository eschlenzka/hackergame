package frontend;

import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.*;
import game_backend.*;


public class Board {
	JPanel panel;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 600;
	
	public Board(JPanel panel) {
		this.panel = panel;
	}
	
	public void addKeyListener(KeyListener k) {
		panel.addKeyListener(k);
	}
	
	public void update(List<Enemy> enemies, Player player) {
		
	}
}