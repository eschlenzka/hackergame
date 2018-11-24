package game_backend;

public class Enemy {
	private int x_pos;
	private int y_pos;
	private EnemyTypes enemyType;
	Enemy(int x_spawn,int y_spawn, EnemyTypes enemyType){
	x_pos = x_spawn;
	y_pos = y_spawn;
	this.enemyType = enemyType;
	}
	public void updatePosition(int new_x,int new_y) {
		x_pos = new_x;
		y_pos = new_y;	
	}
	public int getX() {
		return x_pos;
	}
	public int getY() {
		return y_pos;
	}
}
