import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapGUI {
	/**
     * Mainframe.
     */
     JFrame mainframe;
     
     /**
     * Constructs the Map GUI.
     */
     public MapGUI() {
           this.mainframe = new JFrame("Yggdrasil (The World Tree)");
           this.mainframe.setSize(1366, 768);
           this.mainframe.setVisible(true);
           this.mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
           JPanel mainPanel = new JPanel();
           JPanel buttonPanel = new JPanel();
           
           JLabel welcome = new JLabel("Welcome to Yggdrasil");
           JLabel option = new JLabel("Would you like to");
           JButton planButton = new JButton("Plan an adventure");
           JButton directionsButton = new JButton("Get Directions");
           
           mainPanel.setBounds(0, 0, 100, 100);
           mainPanel.setBackground(Color.GRAY);
           
           mainPanel.add(welcome);
           mainPanel.add(option);
           buttonPanel.add(planButton);
           buttonPanel.add(directionsButton);
           mainPanel.add(buttonPanel);
           
           this.mainframe.add(mainPanel, BorderLayout.CENTER);
           
           
     }
}
