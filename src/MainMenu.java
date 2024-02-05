import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {

    private static JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    public static void createAndShowGUI() {
        frame = new JFrame("Guess Who");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel titleLabel = new JLabel("Guess Who");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(titleLabel, gbc);

        gbc.gridy++;
        gbc.insets = new Insets(10, 0, 0, 0);

        JButton hostButton = new JButton("Host");
        JButton joinButton = new JButton("Join");

        // Customize button appearance
        hostButton.setFont(new Font("Arial", Font.PLAIN, 16));
        joinButton.setFont(new Font("Arial", Font.PLAIN, 16));

        panel.add(hostButton, gbc);
        gbc.gridy++;
        panel.add(joinButton, gbc);

        hostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hostFunction();
            }
        });

        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                joinFunction();
            }
        });

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }

    private static void hostFunction() {
        // Code for hosting function goes here
        frame.dispose();
        ServerMenu sm = new ServerMenu();
        new Server(sm);
    }

    private static void joinFunction() {
        // Code for joining function goes here
        frame.dispose();
        new JoinMenu();
    }
}