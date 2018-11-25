package console_backend;

import game_backend.GameLogic;

public class LocalGameProxy extends GameProxy {
	private GameLogic gameLogic;
	
	public LocalGameProxy(GameLogic gameLogic) {
		this.gameLogic = gameLogic;
	}
	
	@Override
	public void execute(Command command, int checksum) {
		switch(command) {
		case SPAWNME:
			gameLogic.spawn();
		}
	}
}
