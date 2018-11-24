package console_backend;

public enum Command {
	SPAWNME("spawnme");
	
	private String stringValue;
	
	Command(String stringValue) {
		this.stringValue = stringValue;
	}
	
	@Override
	public String toString() {
		return stringValue;
	}
	
	
	
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
