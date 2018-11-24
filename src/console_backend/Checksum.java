package console_backend;

public class Checksum {
	private Checksum() {} //keine Objekte erstellen
	
	public static boolean check(int checksum, Command command) {
		return command != Command.REPORTME && checksum == 1; //TODO: just a dummy
	}
}
