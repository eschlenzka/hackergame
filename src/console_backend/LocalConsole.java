package console_backend;

import javax.swing.JTextArea; //TODO abstrahieren
import java.util.*;

public class LocalConsole {
	public final static String ERROR = " is no valid input";
	
	private JTextArea textout;
	private List<Integer> checksums = new LinkedList<Integer>(); //das letzte ist das neueste
	
	public LocalConsole(JTextArea textout) {
		this.textout = textout;
	}
	
	/*======================================
	 * 			LOG output
	 *======================================*/
	public void log(Command command, int checksum) {
		textout.append("\n[Command] " + command.toString());
		appendChecksum(checksum);
	}
	
	public void requestChecksum(int index) {
		textout.append("\n[Checksum of " + index + "] " + checksums.get(index));
	}

	public void logError(String errorCode) {
		textout.append("\n[Error] " + errorCode + ERROR);
	}
	
	/*======================================
	 * 			Internal
	 *======================================*/
	private void appendChecksum(int checksum) {
		checksums.add(checksum);
		
		if(checksums.size() > 10) {
			checksums.remove(0); //stelle 0, da int (nicht Integer!)
		}
	}
}
