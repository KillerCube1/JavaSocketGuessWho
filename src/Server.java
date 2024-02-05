import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.SwingUtilities;
 
 
public class Server {
 
    public Server(ServerMenu UI) {

        try {
            String IP = InetAddress.getLocalHost().getHostAddress();
            SwingUtilities.invokeLater(() -> {UI.updateUI(IP, 100);});
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            try (ServerSocket server = new ServerSocket(100)) {
                System.out.println("Server started!");
                Socket socket = server.accept();
                UI.disposeFrame();
                System.out.println("Connected");
                new ServerConnection(socket).start();
            } catch (IOException ex) {
                System.out.println("Error " + ex.getMessage());
            }
        }).start();
    }
}