package game_backend;

public class Player{
	int x_pos;
	int y_pos;
	Player(int x_spawn,int y_spawn){
	x_pos = x_spawn;
	y_pos = y_spawn;
	System.out.println("("+Integer.toString(x_pos)+","+Integer.toString(y_pos)+")");
	}
	public void updatePosition(int new_x,int new_y) {
		x_pos = new_x;
		y_pos = new_y;
	}
}
