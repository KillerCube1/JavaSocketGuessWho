import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ServerMenu {

    private JFrame frame;
    private JLabel label1;
    private JLabel label2;

    public ServerMenu() {
        frame = new JFrame("Simple UI Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);

        label1 = new JLabel("IP:    Port: ");
        label2 = new JLabel("Waiting for second player...");

        JPanel panel = new JPanel();
        panel.add(label1);
        panel.add(label2);

        frame.getContentPane().add(panel);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void updateUI(String ip, int port) {
        label1.setText("IP: " + ip + "    Port: " + port);
        label2.setText("Waiting for second player...");
    }

    public void disposeFrame() {
        frame.dispose();
    }
}
