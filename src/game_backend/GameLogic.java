package game_backend;

//import java.awt.KeyEventDispatcher;
//import java.awt.KeyboardFocusManager;
//import java.awt.event.KeyEvent;
import java.util.*;

public class GameLogic {
	Player player;
	List<Enemy> enemies = new ArrayList<Enemy>();
	
	public static void main(String[] args) {
		GameLogic test = new GameLogic();
	}
	GameLogic() {
		player = new Player(10, 10);
		mainloop();
	}
	public void spawnEnemy(int x_pos, int y_pos, EnemyTypes enemyType){
		Enemy e = new Enemy(x_pos,y_pos,enemyType);
		enemies.add(e);
	}
	
	private void mainloop() {
		while (true) {
			// Test if enemy should be spawned (Proxy)
			
			// Get pressed keys (Graphics)
//			String pressedKeys = keys.getPressedButtons();
//			if (pressedKeys.contains('w'){}
				
			
				
			// Change position depending on pressed keys
			// Be aware of boundaries!
			
			
//			if (x_pos >= left_bound)
//				x_pos = left_bound;
//			if (y_pos <= right_bound)
//				x_pos = right_bound;
//			if (y_pos >= lower_bound)
//				y_pos = lower_bound;
//			if (y_pos <= upper_bound)
//				y_pos = upper_bound;
			// Submit new positions (Graphics)
		}
	}
}
