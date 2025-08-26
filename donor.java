package bbms;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class donor extends JFrame {

    private JTextField donorIdField, fullNameField, fatherNameField, motherNameField, mobileField, emailField, cityField;
    private JTextArea addressArea;
    private JComboBox<String> genderBox, bloodGroupBox, dayBox, monthBox, yearBox;

    public donor() {
        setTitle("New Donor Details");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/images/back1.jpg")));
        background.setBounds(0, 0, 900, 700);
        setContentPane(background);
        background.setLayout(null);

        JLabel heading = new JLabel("New Donor Details");
        heading.setFont(new Font("Arial", Font.BOLD, 45));
        heading.setForeground(Color.WHITE);
        heading.setBounds(500, 30, 400, 40);
        background.add(heading);

        JLabel donorIdLabel = new JLabel("Donor ID:");
        donorIdLabel.setForeground(Color.WHITE);
        donorIdLabel.setBounds(100, 50, 100, 30);
        donorIdLabel.setFont(new Font("Arial", Font.BOLD, 18));
        background.add(donorIdLabel);

        donorIdField = new JTextField();
        donorIdField.setBounds(250, 50, 100, 30);
        donorIdField.setEditable(false);
        background.add(donorIdField);

        JLabel fullNameLabel = new JLabel("Full Name:");
        fullNameLabel.setForeground(Color.WHITE);
        fullNameLabel.setBounds(100, 100, 100, 30);
        fullNameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        background.add(fullNameLabel);
        fullNameField = new JTextField();
        fullNameField.setBounds(250, 100, 200, 30);
        background.add(fullNameField);

        JLabel fatherLabel = new JLabel("Father's Name:");
        fatherLabel.setForeground(Color.WHITE);
        fatherLabel.setBounds(100, 150, 140, 30);
        fatherLabel.setFont(new Font("Arial", Font.BOLD, 18));
        background.add(fatherLabel);
        fatherNameField = new JTextField();
        fatherNameField.setBounds(250, 150, 200, 30);
        background.add(fatherNameField);

        JLabel motherLabel = new JLabel("Mother's Name:");
        motherLabel.setForeground(Color.WHITE);
        motherLabel.setBounds(100, 200, 140, 30);
        motherLabel.setFont(new Font("Arial", Font.BOLD, 18));
        background.add(motherLabel);
        motherNameField = new JTextField();
        motherNameField.setBounds(250, 200, 200, 30);
        background.add(motherNameField);

        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setForeground(Color.WHITE);
        dobLabel.setBounds(100, 250, 120, 30);
        dobLabel.setFont(new Font("Arial", Font.BOLD, 18));
        background.add(dobLabel);
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) days[i - 1] = String.valueOf(i);
        dayBox = new JComboBox<>(days);
        dayBox.setBounds(250, 250, 50, 30);
        background.add(dayBox);

        String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
        monthBox = new JComboBox<>(months);
        monthBox.setBounds(310, 250, 70, 30);
        background.add(monthBox);

        String[] years = new String[100];
        for (int i = 0; i < 100; i++) years[i] = String.valueOf(2025 - i);
        yearBox = new JComboBox<>(years);
        yearBox.setBounds(390, 250, 70, 30);
        background.add(yearBox);

        JLabel mobileLabel = new JLabel("Mobile Number:");
        mobileLabel.setForeground(Color.WHITE);
        mobileLabel.setBounds(100, 300, 140, 30);
        mobileLabel.setFont(new Font("Arial", Font.BOLD, 18));
        background.add(mobileLabel);
        mobileField = new JTextField();
        mobileField.setBounds(250, 300, 200, 30);
        background.add(mobileField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setForeground(Color.WHITE);
        genderLabel.setBounds(100, 350, 100, 30);
        genderLabel.setFont(new Font("Arial", Font.BOLD, 18));
        background.add(genderLabel);
        String[] genders = { "Male", "Female", "Other" };
        genderBox = new JComboBox<>(genders);
        genderBox.setBounds(250, 350, 200, 30);
        background.add(genderBox);

        JLabel emailLabel = new JLabel("Email ID:");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setBounds(1030, 100, 140, 30);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 18));
        background.add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(1200, 100, 200, 30);
        background.add(emailField);

        JLabel bloodLabel = new JLabel("Blood Group:");
        bloodLabel.setForeground(Color.WHITE);
        bloodLabel.setBounds(1030, 150, 140, 30);
        bloodLabel.setFont(new Font("Arial", Font.BOLD, 18));
        background.add(bloodLabel);
        String[] bloodGroups = { "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" };
        bloodGroupBox = new JComboBox<>(bloodGroups);
        bloodGroupBox.setBounds(1200, 150, 200, 30);
        background.add(bloodGroupBox);

        JLabel cityLabel = new JLabel("City:");
        cityLabel.setForeground(Color.WHITE);
        cityLabel.setBounds(1030, 200, 100, 30);
        cityLabel.setFont(new Font("Arial", Font.BOLD, 18));
        background.add(cityLabel);
        cityField = new JTextField();
        cityField.setBounds(1200, 200, 200, 30);
        background.add(cityField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setForeground(Color.WHITE);
        addressLabel.setBounds(1030, 250, 180, 30);
        addressLabel.setFont(new Font("Arial", Font.BOLD, 18));
        background.add(addressLabel);
        addressArea = new JTextArea();
        addressArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(addressArea);
        scrollPane.setBounds(1200, 250, 300, 60);
        background.add(scrollPane);

        JButton saveBtn = new JButton("Save");
        saveBtn.setBounds(1030, 500, 100, 40);
        saveBtn.setFont(new Font("Arial", Font.BOLD, 18));
        background.add(saveBtn);

        JButton resetBtn = new JButton("Reset");
        resetBtn.setBounds(1200, 500, 100, 40);
        resetBtn.setFont(new Font("Arial", Font.BOLD, 18));
        background.add(resetBtn);

        JButton closeBtn = new JButton("Close");
        closeBtn.setBounds(1400, 500, 100, 40);
        closeBtn.setFont(new Font("Arial", Font.BOLD, 18));
        background.add(closeBtn);

        closeBtn.addActionListener(e -> dispose());

        resetBtn.addActionListener(e -> {
            fullNameField.setText("");
            fatherNameField.setText("");
            motherNameField.setText("");
            mobileField.setText("");
            emailField.setText("");
            cityField.setText("");
            addressArea.setText("");
            genderBox.setSelectedIndex(0);
            bloodGroupBox.setSelectedIndex(0);
            dayBox.setSelectedIndex(0);
            monthBox.setSelectedIndex(0);
            yearBox.setSelectedIndex(0);
            donorIdField.setText(String.valueOf(getNextDonorId()));
        });

        saveBtn.addActionListener(e -> {
            int donorId = Integer.parseInt(donorIdField.getText());
            String fullName = fullNameField.getText();
            String fatherName = fatherNameField.getText();
            String motherName = motherNameField.getText();
            String dob = dayBox.getSelectedItem() + "-" + monthBox.getSelectedItem() + "-" + yearBox.getSelectedItem();
            String mobile = mobileField.getText();
            String gender = (String) genderBox.getSelectedItem();
            String email = emailField.getText();
            String bloodGroup = (String) bloodGroupBox.getSelectedItem();
            String city = cityField.getText();
            String address = addressArea.getText();

            try (Connection conn = DBConnection.getConnection()) {
                String query = "INSERT INTO donors (id, full_name, father_name, mother_name, dob, mobile, gender, email, blood_group, city, address) " +
                               "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, donorId);
                ps.setString(2, fullName);
                ps.setString(3, fatherName);
                ps.setString(4, motherName);
                ps.setString(5, dob);
                ps.setString(6, mobile);
                ps.setString(7, gender);
                ps.setString(8, email);
                ps.setString(9, bloodGroup);
                ps.setString(10, city);
                ps.setString(11, address);

                int rows = ps.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(this, "Donor information saved successfully!");
                    donorIdField.setText(String.valueOf(getNextDonorId()));
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to save donor information.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        donorIdField.setText(String.valueOf(getNextDonorId()));
    }

    private int getNextDonorId() {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id FROM donors ORDER BY id ")) {

            int id = 1;
            while (rs.next()) {
                if (rs.getInt("id") != id) {
                    return id;
                }
                id++;
            }
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new donor().setVisible(true));
    }
}
