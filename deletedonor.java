package bbms;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;

public class deletedonor extends JFrame {

    public deletedonor() {
        setTitle("Delete Donor");
        setSize(500, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/images/bg25.jpg")));
        background.setBounds(0, 0, 1030, 800);
        setContentPane(background);
        background.setLayout(null);
        
        
        JLabel label = new JLabel("Enter Donor ID to Delete:");
        label.setBounds(400, 100, 400, 100);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label);
        
        

        JTextField donorIdField = new JTextField();
        donorIdField.setBounds(760, 130, 250, 30);
        
        add(donorIdField);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(650, 400, 150, 50);
        deleteBtn.setFont(new Font("Serif", Font.BOLD, 22));
        add(deleteBtn);

        JLabel statusLabel = new JLabel("");
        statusLabel.setBounds(500, 250, 400, 30);
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(statusLabel);

        deleteBtn.addActionListener(e -> {
            String donorId = donorIdField.getText().trim();
            if (donorId.isEmpty()) {
                statusLabel.setText("Please enter a Donor ID.");
                return;
            }

            try (Connection conn = DBConnection.getConnection()) {
                // First get the blood group of the donor
                String bloodGroup = null;
                String getBloodGroupSQL = "SELECT blood_group FROM donors WHERE id = ?";
                PreparedStatement ps1 = conn.prepareStatement(getBloodGroupSQL);
                ps1.setString(1, donorId);
                ResultSet rs = ps1.executeQuery();

                if (rs.next()) {
                    bloodGroup = rs.getString("blood_group");
                } else {
                    statusLabel.setText("Donor ID not found.");
                    return;
                }

                
                String deleteDonorSQL = "DELETE FROM donors WHERE id = ?";
                PreparedStatement ps2 = conn.prepareStatement(deleteDonorSQL);
                ps2.setString(1, donorId);
                int deleted = ps2.executeUpdate();

                if (deleted > 0) {
                    // Update the stock
                    String updateStockSQL = "UPDATE blood_stock SET units = units - 1 WHERE blood_group = ? AND units > 0";
                    PreparedStatement ps3 = conn.prepareStatement(updateStockSQL);
                    ps3.setString(1, bloodGroup);
                    ps3.executeUpdate();

                    statusLabel.setText("Donor deleted and stock updated.");
                } else {
                    statusLabel.setText("Failed to delete donor.");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                statusLabel.setText("Error: " + ex.getMessage());
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(deletedonor::new);
    }
}
