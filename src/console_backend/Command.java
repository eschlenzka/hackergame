package console_backend;

public enum Command {
	SPAWNME("spawnme",true, false), REPORTME("reportme", true, false), REPORTPARTY("reportparty", false, true);
	
	private String stringValue;
	boolean onMe;
	boolean onThem;
	
	Command(String stringValue, boolean onme, boolean onthem) {
		this.stringValue = stringValue;
		this.onMe = onme;
		this.onThem = onthem;
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
		return string.matches("(spawnme|reportme|reportparty) [0-9]+");
	}
}
