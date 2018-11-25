package console_backend;

import frontend.Board;
import game_backend.GameLogic;

public class LocalGameProxy extends GameProxy {
	private GameLogic gameLogic;
	
	public LocalGameProxy(Board board) {
		this.gameLogic = new GameLogic(board);
	}
	
	@Override
	public void execute(Command command, int checksum) {
		switch(command) {
		case SPAWNME:
			gameLogic.spawn();
		}
	}
}
