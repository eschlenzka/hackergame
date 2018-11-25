package game_backend;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.*;
import java.util.*;
import frontend.*;
public class GameLogic {
	Player player;
	List<Enemy> enemies = new ArrayList<Enemy>();
	Board gameBoard;
	KeyAdapter listener;
	int playerVelocity = 3; //currently hard-coded!
	boolean isKeyPressed[];
	
	public GameLogic(Board board) {
		player = new Player(10, 10);
		gameBoard = board;
		isKeyPressed = new boolean[4];
		KeyListener k = new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				char pressed = arg0.getKeyChar();
				if(pressed == 'W') 
					isKeyPressed[0] = true; 	
				if(pressed == 'A')
					isKeyPressed[1] = true; 
				if(pressed == 'S')
					isKeyPressed[2] = true; 
				if(pressed == 'D')
					isKeyPressed[3] = true; 
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				char released = arg0.getKeyChar();
				if(released == 'W') 
					isKeyPressed[0] = false; 	
				if(released == 'A')
					isKeyPressed[1] = false; 
				if(released == 'S')
					isKeyPressed[2] = false; 
				if(released == 'D')
					isKeyPressed[3] = false;  
			}

			@Override
			public void keyTyped(KeyEvent arg0) {	
				
			}
				
		};
		gameBoard.addKeyListener(k);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				mainloop();
			}
		}, 0, 1000);
	}
	
	public void spawn(){
		// TODO: random values, not at player
		Enemy e = new Enemy();
		enemies.add(e);
	}
	
	private void mainloop() {
		int pl_x = player.getX();
		int pl_y = player.getY();
		if(isKeyPressed[0] == true)
			pl_y -= playerVelocity;
		if(isKeyPressed[1] == true)
			pl_x -= playerVelocity;
		if(isKeyPressed[2] == true)
			pl_y += playerVelocity;
		if(isKeyPressed[3] == true)
			pl_x += playerVelocity;
		if (pl_x >= 0)
			pl_x = 0;
		if (pl_x <= WIDTH)
			pl_x = WIDTH;
		if (pl_y >= HEIGHT)
			pl_y = HEIGHT;
		if (pl_y <= 0)
			pl_y = 0;
		player.updatePosition(pl_x, pl_y);
		//TODO: Submit new positions 
		
		// Test if enemy should be spawned (Proxy)


			
			
		
	}
}
