package frontend;

import console_backend.Command;
import javax.swing.*;

public class LocalConsole {
	JTextArea textout;
	
	public LocalConsole(JTextArea textout) {
		this.textout = textout;
	}

	public void log(Command command) {
		textout.append("\n[Command] " + command.toString());
	}

	public void logChecksum(int index, int checksum) {
		textout.append("\n[Checksum] für Befehl " + index + ": " + checksum); 
	}

	public void logError(String wrongInput) {
		textout.append("\n[Error] Fehlerhafte eingabe: " + wrongInput);
	}

}
