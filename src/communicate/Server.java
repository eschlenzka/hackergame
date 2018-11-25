// Client.java

// import java.net.Socket;
package communicate;
import console_backend.*;
import java.net.InetAddress;
import java.io.*;
import java.util.regex.Pattern;

public class Server{
    public Server(ConsoleLog console){
        this.console = console;
    }
    ConsoleLog console;
    public void read(java.net.Socket socket) throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));
        char[] buffer = new char[200];
        int anzahlZeichen = bufferedReader.read(buffer, 0, 200); // blockiert bis Nachricht empfangen
        //String nachricht = new String(buffer, 0, 200);
        int checksum;
        int i = 0;
        String nachricht = new String();
        while(buffer[i] != '0' && (buffer[i] != 0)){
            nachricht += buffer[i];
            i++;
        }
        if(buffer[i] != 0){
        String checksumString = new String(buffer, i+1,4);
        checksum = Integer.parseInt(checksumString);
        Command command = Command.identifyCommand(nachricht);
        String[] ip = (InetAddress.getLocalHost().getHostAddress()).split(Pattern.quote("."));
        int playerID = Integer.parseInt(ip[3]);
        console.runCommand(command,checksum,playerID);
        }

    }
}