import javax.swing.*;
import java.io.IOException;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class CheckServerUpOrDown {

    private static final String SERVER_ADDRESS = "43.255.154.28";
    private static final int TCP_SERVER_PORT = 21;

    public static boolean hostAvailabilityCheck() {
        try (Socket s = new Socket(SERVER_ADDRESS, TCP_SERVER_PORT)) {
            return true;
        } catch (IOException ex) {
            /* ignore */
        }
        return false;
    }
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                checkServerIsUpOrDown();
            }
        }, 0, 300000);

    }

    private static void checkServerIsUpOrDown() {
        if(hostAvailabilityCheck()){
            System.out.println("Server is Up!!!!");
        } else {
            System.out.println("Server is Down!!!!");
        }
    }
}
