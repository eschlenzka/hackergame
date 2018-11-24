// Client.java

// import java.net.Socket;
package communicate;
import console_backend.*;

import java.io.*;

public class Client{
    public void write(java.net.Socket socket, Command command, int checksum) throws IOException {
        PrintWriter printWriter =
                new PrintWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream()));
        printWriter.print(command.toString());
        printWriter.flush();
    }
}