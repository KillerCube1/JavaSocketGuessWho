import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
 
public class ServerConnection extends Thread {

    Socket socket;

    // Game State
    int gameState = 546;

    public ServerConnection(Socket socket){
        this.socket = socket;
    }
     
    @Override
    public void run(){
        try(
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedOutputStream output = new BufferedOutputStream(socket.getOutputStream())
        ) {
            String command = input.readLine();
            
            if (command.substring(0, 3).equals("get")) {
                if (command.substring(3, 6).equals("GSV")) {
                    output.write((String.valueOf(gameState)+"\r\n").getBytes());
                    output.flush();
                }
            }

        } catch (IOException ex) {
            System.out.println("Error " + ex.getMessage());
        }
     
    }
}