package communicate;

import java.io.IOException;
import console_backend.*;

public class Receiver {
    private Server s = new Server();
    public void streamCommands(){
        try {
            int port = 11111;
            java.net.ServerSocket serverSocket = new java.net.ServerSocket(port);
            java.net.Socket socket = serverSocket.accept();
            while(true) {
                Command c = s.read(socket);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
