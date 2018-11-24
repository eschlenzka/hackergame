// Client.java

// import java.net.Socket;
package communicate;
import console_backend.*;

import java.io.*;

public class Server{
    public Command read(java.net.Socket socket) throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));
        char[] buffer = new char[200];
        int anzahlZeichen = bufferedReader.read(buffer, 0, 200); // blockiert bis Nachricht empfangen
        String nachricht = new String(buffer, 0, anzahlZeichen);
        Command command = Command.identifyCommand(nachricht);
        return command;
    }
}