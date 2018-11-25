package game_backend;

public class Player{
	private int x_pos;
	private int y_pos;

	Player(int x_spawn,int y_spawn){
	x_pos = x_spawn;
	y_pos = y_spawn;
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
