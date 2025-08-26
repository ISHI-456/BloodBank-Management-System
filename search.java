
package bbms;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class search extends JFrame {
    private JTextField searchField;
    private JTextArea resultArea;

    public search() {
        setTitle("Search Donor");
        setSize(600, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/images/bg25.jpg")));
        background.setBounds(0, 0, 1030, 800);
        setContentPane(background);
        background.setLayout(null);
       


        JLabel label = new JLabel("Enter Donor Name or Blood Group:");
        label.setBounds(500, 100, 400, 50);
        label.setFont(new Font("Serif", Font.BOLD, 28));
        label.setForeground(Color.WHITE);
        add(label);

        searchField = new JTextField();
        searchField.setBounds(900, 100, 200, 50);
        searchField.setFont(new Font("Serif", Font.BOLD, 22));
        add(searchField);

        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(650, 600, 150, 50);
        searchBtn.setFont(new Font("Serif", Font.BOLD, 22));
        
        add(searchBtn);

        resultArea = new JTextArea();
        resultArea.setBounds(400, 200, 800, 300);
        resultArea.setEditable(false);
        label.setFont(new Font("Serif", Font.BOLD, 24));
        add(resultArea);

        searchBtn.addActionListener(e -> searchDonors());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void searchDonors() {
        String input = searchField.getText().trim();

        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a name or blood group to search.");
            return;
        }

        StringBuilder results = new StringBuilder();

        
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT full_name, blood_group, mobile, city FROM donors WHERE full_name LIKE ? OR blood_group LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + input + "%");
            ps.setString(2, "%" + input + "%");

            ResultSet rs = ps.executeQuery();

            boolean found = false;
            while (rs.next()) {
                found = true;
                results.append("Name: ").append(rs.getString("full_name")).append("\n");
                results.append("Blood Group: ").append(rs.getString("blood_group")).append("\n");
                results.append("Mobile: ").append(rs.getString("mobile")).append("\n");
                results.append("City: ").append(rs.getString("city")).append("\n");
                results.append("--------------------------\n");
            }

            if (!found) {
                results.append("No donors found matching your search.");
            }

            resultArea.setText(results.toString());

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error while searching: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(search::new);
    }
}

