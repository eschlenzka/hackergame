package console_backend;

import java.util.*;

public class InputManager {
	private LocalConsole localConsole;
	private List<GameProxy> proxies = new ArrayList<GameProxy>();
	
	public InputManager(LocalConsole localConsole) {
		this.localConsole = localConsole;
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
			
			localConsole.log(command, checksum);
			
			for(GameProxy gp: proxies) {
				gp.execute(command, checksum);
			}
		} else {
			localConsole.logError(input);
		}
	}
}
