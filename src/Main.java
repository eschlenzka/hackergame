import communicate.*;
import console_backend.Command;
public class Main {
    public static void main(String[] args){
        Thread t = new Receiver();
        t.start();
        RemoteGameProxy r = new RemoteGameProxy();
        r.execute(Command.SPAWNME, 4321);
    }
}
