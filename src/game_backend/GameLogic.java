package game_backend;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.*;
import java.util.*;
import frontend.*;
import java.util.concurrent.ThreadLocalRandom;
public class GameLogic {
	Player player;
	List<Enemy> enemies = new ArrayList<Enemy>();
	Board gameBoard;
	KeyAdapter listener;
	int playerVelocity = 3; //currently hard-coded!
	boolean isKeyPressed[];
	
	public GameLogic(Board board) {
		player = new Player(100, 100);
		gameBoard = board;
		isKeyPressed = new boolean[4];
		KeyListener k = new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				char pressed = arg0.getKeyChar();
				if(pressed == 'w') 
					isKeyPressed[0] = true; 	
				if(pressed == 'a')
					isKeyPressed[1] = true; 
				if(pressed == 's')
					isKeyPressed[2] = true; 
				if(pressed == 'd')
					isKeyPressed[3] = true; 
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				char released = arg0.getKeyChar();
				if(released == 'w') 
					isKeyPressed[0] = false; 	
				if(released == 'a')
					isKeyPressed[1] = false; 
				if(released == 's')
					isKeyPressed[2] = false; 
				if(released == 'd')
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
		}, 0, 20);
	}
	
	public void spawn(){
		int randomY = ThreadLocalRandom.current().nextInt(100,Board.HEIGHT-10);
		int randomX = ThreadLocalRandom.current().nextInt(100,Board.WIDTH-10);
		randomY = (randomY + player.getY() - 50) % Board.HEIGHT-10;
		randomX = (randomX + player.getX() - 50) % Board.WIDTH-10;
		Enemy e = new Enemy(randomX,randomY,EnemyTypes.DEFAULT);
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
		if (pl_x <= 0)
			pl_x = 0;
		if (pl_x >= Board.WIDTH-10)
			pl_x = Board.WIDTH-10;
		if (pl_y >= Board.HEIGHT-10)
			pl_y = Board.HEIGHT-10;
		if (pl_y <= 0)
			pl_y = 0;
		player.updatePosition(pl_x, pl_y);
		gameBoard.update(enemies, player);

	}
}
