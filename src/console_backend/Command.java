package console_backend;

public enum Command {
	SPAWNME;
	
	public static Command identifyCommand(String string) {
		switch(string) {
		case "spawnme":
			return SPAWNME;
		default:
			throw new IllegalArgumentException();
		}
	}
	
	public static boolean isValid(String string) {
		return string.matches("(spawnme) [0-9]+");
	}
}
