package communicate;

import java.io.IOException;
import console_backend.*;

public class Receiver extends Thread {
    public Receiver(Server s){
        this.s = s;
    }
    private Server s;
    public void streamCommands(){
        try {
            int port = 11111;
            java.net.ServerSocket serverSocket = new java.net.ServerSocket(port);
            java.net.Socket socket = serverSocket.accept();
            while(true) {
                s.read(socket);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void run(){
        streamCommands();
    }
}
