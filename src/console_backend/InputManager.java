package console_backend;

import java.util.*;

public class InputManager {
	private ConsoleLog console;
	private List<GameProxy> proxies = new ArrayList<GameProxy>();
	
	public InputManager(ConsoleLog console) {
		this.console = console;
	}
	
	public void addProxy(GameProxy gp) {
		proxies.add(gp);
	}	
	
	public void manage(String input) {
		if(Command.isValid(input)) {
			String[] in = input.split(" ");
			
			String commandString = in[0];
			int checksum = Integer.parseInt(in[1]);
			
			Command command = Command.identifyCommand(commandString);
			
			console.runCommand(command, checksum, 0);
			
			for(GameProxy gp: proxies) {
				gp.execute(command, checksum);
			}
		} else {
			console.logError(input);
		}
	}
}
