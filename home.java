package bbms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class home extends JFrame {
	 
    public home() {
        setTitle("Blood Bank Management System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setLayout(null);

        
        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/images/back1.jpg")));
        background.setBounds(0, 0, 1030, 800);
        setContentPane(background);
        background.setLayout(null);

        
        JLabel title = new JLabel("GIVE  BLOOD !  SAVE  LIFE !", JLabel.CENTER);
        title.setFont(new Font("Verdana", Font.BOLD, 40));
        title.setForeground(Color.WHITE);
        title.setBounds(250, 30, 1000, 50);
        background.add(title);

       
        JButton donorBtn = new JButton("DONOR");
        donorBtn.setIcon(new ImageIcon(getClass().getResource("/images/donor1.jpg")));
        donorBtn.setBounds(100, 170, 200, 70);
        donorBtn.setFont(new Font("Serif", Font.BOLD, 24));
        donorBtn.setBackground(Color.WHITE);
        donorBtn.addActionListener(e -> {
            new donor().setVisible(true); 
        });

        
        JButton searchBtn = new JButton("SEARCH");
        searchBtn.setIcon(new ImageIcon(getClass().getResource("/images/search1.jpg")));
        searchBtn.setBounds(360, 170, 200, 70);
        searchBtn.setFont(new Font("Serif", Font.BOLD, 24));
        searchBtn.setBackground(Color.WHITE);
        searchBtn.addActionListener(e -> {
            new search().setVisible(true); 
        });

        
        JButton stockBtn = new JButton("STOCK");
        stockBtn.setIcon(new ImageIcon(getClass().getResource("/images/stock1.jpg")));
        stockBtn.setBounds(620, 170, 200, 70);
        stockBtn.setFont(new Font("Serif", Font.BOLD, 24));
        stockBtn.setBackground(Color.WHITE);
        stockBtn.addActionListener(e -> {
            new stock().setVisible(true); 
        });

      
        JButton deleteBtn = new JButton("DELETE");
        deleteBtn.setIcon(new ImageIcon(getClass().getResource("/images/deletedonor1.jpg")));
        deleteBtn.setBounds(880, 170, 200, 70);
        deleteBtn.setFont(new Font("Serif", Font.BOLD, 24));
        deleteBtn.setBackground(Color.WHITE);
        deleteBtn.addActionListener(e -> {
            new deletedonor().setVisible(true); 
            });

       
        JButton exitBtn = new JButton("EXIT");
        exitBtn.setIcon(new ImageIcon(getClass().getResource("/images/exit1.png")));
        exitBtn.setBounds(1140, 170, 200, 70);
        exitBtn.setFont(new Font("Serif", Font.BOLD, 24));
        exitBtn.setBackground(Color.WHITE);
        exitBtn.addActionListener(e -> System.exit(0));

        
        background.add(donorBtn);
        background.add(searchBtn);
        background.add(stockBtn);
        background.add(deleteBtn);
        background.add(exitBtn);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(home::new);
    }
}
