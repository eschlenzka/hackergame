package communicate;

import console_backend.*;
import java.io.*;
public class RemoteGameProxy extends GameProxy {
    private Client c = new Client();
    public void execute(Command command, int checksum){
        try {
            String ip = "127.0.0.1";
            int port = 11111;
            java.net.Socket socket = new java.net.Socket(ip, port);
            c.write(socket,command,checksum);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
