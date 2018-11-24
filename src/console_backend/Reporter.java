package console_backend;

public class Reporter {
	private ConsoleLog console;
	
	public Reporter(ConsoleLog console) {
		this.console = console;
	}
	
	public void report(int index) {
		if(Checksum.check(console.getChecksum(index), console.getCommand(index))) {
			//checksum war richtig -> alle anderen bestrafen
			console.runCommand(Command.REPORTME, 0, 0);
		} else {
			console.runCommand(Command.REPORTPARTY, 0, 0);
		}
	}
}
