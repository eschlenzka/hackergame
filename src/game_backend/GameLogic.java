package game_backend;

//import java.awt.KeyEventDispatcher;
//import java.awt.KeyboardFocusManager;
//import java.awt.event.KeyEvent;
import java.util.*;

public class GameLogic {
	Player player;
	List<Enemy> enemies = new ArrayList<Enemy>();
	Board gameBoard;
	public static void main(String[] args) {
		GameLogic test = new GameLogic();
	}
	GameLogic(Board board) {
		player = new Player(10, 10);
		gameBoard = board;
		mainloop();
	}
	public void spawnEnemy(int x_pos, int y_pos, EnemyTypes enemyType){
		Enemy e = new Enemy(x_pos,y_pos,enemyType);
		enemies.add(e);
	}
	
	private void mainloop() {
		while (true) {
			int pl_x = player.getX();
			int pl_y = player.getY();
			// Test if enemy should be spawned (Proxy)
			
			// Get pressed keys (Graphics)
//			String pressedKeys = keys.getPressedButtons();
//			if (pressedKeys.contains('w'){}
				
			
				
			// Change position depending on pressed keys
			// Be aware of boundaries!
			// 
			
//			if (pl_x >= 0)
//				pl_x = 0;
//			if (pl_x <= WIDTH)
//				pl_x = WIDTH;
//			if (pl_y >= HEIGHT)
//				pl_y = HEIGHT;
//			if (pl_y <= 0)
//				pl_y = 0;
			// Submit new positions (Graphics)
			player.updatePosition(pl_x, pl_y);
		}
	}
}
