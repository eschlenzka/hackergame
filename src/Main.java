import communicate.*;
import console_backend.Command;

public class Main {
    public static void main(String[] args){
        //RemoteGameProxy r = new RemoteGameProxy();
        Receiver re = new Receiver();
        re.streamCommands();
        //r.execute(Command.SPAWNME, 1);
    }
}
