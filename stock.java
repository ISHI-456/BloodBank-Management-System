
package bbms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class stock extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;

    public stock() {
        setTitle("Blood Stock");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/images/bg25.jpg")));
        background.setBounds(0, 0, 1030, 800);
        setContentPane(background);
        background.setLayout(null);

        String[] columnNames = {"Blood Group", "Units Available"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        
        table.setFont(new Font("Serif", Font.PLAIN, 20));         
        table.setRowHeight(30);                                   
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 22)); 

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(500, 200, 480, 250);
        add(scrollPane);

        loadStockData();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void loadStockData() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT blood_group, units FROM blood_stock";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            tableModel.setRowCount(0);

            while (rs.next()) {
                String bloodGroup = rs.getString("blood_group");
                int units = rs.getInt("units");
                tableModel.addRow(new Object[]{bloodGroup, units});
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading stock data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(stock::new);
    }
}
