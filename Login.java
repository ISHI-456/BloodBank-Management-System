//Blood Bank Management System is a Java Swing application integrated with MySQL that enables efficient donor data management. 
//The admin can securely log in to add, delete, and view donor details, as well as search donors by name or blood group.
//The system also maintains real-time tracking of blood stock units, ensuring easy monitoring and availability.
//This project streamlines donor information handling and blood inventory management, making the process more organized and reliable.

package bbms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame implements ActionListener {
JTextField usernameField;
JPasswordField passwordField;
JButton loginButton, closeButton;

public Login() {
    setTitle("Blood Bank Login");
    setSize(1030, 760);
    setLocationRelativeTo(null);
    setExtendedState(JFrame.MAXIMIZED_BOTH);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(null);

    
    JLabel background = new JLabel(new ImageIcon(getClass().getResource("/images/bggme.jpg")));
    background.setBounds(0, 0, 1030, 760);
    setContentPane(background);
    background.setLayout(null);

    
    JLabel userLabel = new JLabel("Username:");
    userLabel.setBounds(600, 260, 230, 50);
    userLabel.setForeground(Color.BLACK);
    userLabel.setFont(new Font("Serif", Font.BOLD, 18));
    background.add(userLabel);

    usernameField = new JTextField();
    usernameField.setBounds(750, 268, 238, 30);
    background.add(usernameField);

    
    JLabel passLabel = new JLabel("Password:");
    passLabel.setBounds(600, 355, 238, 50);
    passLabel.setForeground(Color.BLACK);
    passLabel.setFont(new Font("Serif", Font.BOLD, 18));
    background.add(passLabel);

    passwordField = new JPasswordField();
    passwordField.setBounds(750, 365, 238, 30);
    background.add(passwordField);

    
    loginButton = new JButton("Login");
    loginButton.setIcon(new ImageIcon(getClass().getResource("/images/login1.jpg")));
    loginButton.setBounds(600, 450, 140, 40);
    loginButton.setFont(new Font("Serif", Font.BOLD, 18));
    loginButton.addActionListener(this);
    background.add(loginButton);

    
    closeButton = new JButton("Close");
    closeButton.setIcon(new ImageIcon(getClass().getResource("/images/close1.png")));
    closeButton.setBounds(800, 450, 140, 40);
    closeButton.setFont(new Font("Serif", Font.BOLD, 18));
    closeButton.addActionListener((ActionListener) this);
    background.add(closeButton);

    setVisible(true);
}

public void actionPerformed(ActionEvent e) {
    if (e.getSource() == loginButton) {
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        if (user.equals("admin") && pass.equals("admin123")) {
            dispose(); // close login window
            new home().setVisible(true); // open home window
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else if (e.getSource() == closeButton) {
        System.exit(0);
    }
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new Login());
}

}