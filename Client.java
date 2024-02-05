import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
 
 
public class Client {
     
    public Client(String IP, int Port) {
        try (
            Socket socket = new Socket(IP, Port);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedOutputStream output = new BufferedOutputStream(socket.getOutputStream())
        ) {
            System.out.println(getGameState(input, output));
        } catch (IOException ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    public static String getGameState(BufferedReader input, BufferedOutputStream output) {
        try {
            output.write("getGSV\r\n".getBytes());
            output.flush();
            return input.readLine();
        } catch (IOException ex) {
            System.out.println("Error " + ex.getMessage());
            return "null";
        }
    }

}