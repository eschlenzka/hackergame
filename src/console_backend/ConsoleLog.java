package console_backend;

import java.util.*;

import frontend.LocalConsole;

public class ConsoleLog {
	private List<Command> commands = new ArrayList<Command>();
	private List<Integer> checksums = new ArrayList<Integer>();
	private List<Integer> byPlayer = new ArrayList<Integer>();
	
	private GameProxy me;
	private LocalConsole localConsole;
	private List<GameProxy> party = new ArrayList<GameProxy>();
	
	public ConsoleLog(GameProxy localProxy, LocalConsole localConsole) {
		me = localProxy;
		this.localConsole = localConsole;
	}
	
	public void addPartyMember(GameProxy proxy) {
		party.add(proxy);
	}
	
	public void runCommand(Command command, int checksum, int playerID) {
		commands.add(command);
		checksums.add(checksum);
		byPlayer.add(playerID);
		
		if(command.onMe && playerID == 0) {
			me.execute(command, checksum);
		}
		if(command.onThem && playerID == 0) {
			for(GameProxy gp: party) {
				gp.execute(command, checksum);
			}
		}
		if(command.onThem && playerID != 0) {
			me.execute(command, checksum);
		}
		
		localConsole.log(command);
	}

	
	public void logChecksum(int index) {
		localConsole.logChecksum(index, checksums.get(indexByUserIndex(index)));
	}
	
	public int getChecksum(int index) {
		return checksums.get(indexByUserIndex(index));
	}
	
	public Command getCommand(int index) {
		return commands.get(indexByUserIndex(index));
	}
	
	public void logError(String wrongInput) {
		localConsole.logError(wrongInput);
	}
	
	private int indexByUserIndex(int userIndex) {
		return checksums.size()-1-userIndex;
	}
}
