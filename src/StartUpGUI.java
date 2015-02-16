import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartUpGUI {
	/**
     * Mainframe.
     */
     JFrame mainframe = new JFrame();
     
     /**
     * Constructs the Start up screen.
     * 
     */
     public StartUpGUI() {
           this.mainframe.setTitle("Yggdrasil (The World Tree)");
           this.mainframe.setSize(1366, 768);
           this.mainframe.setVisible(true);
           this.mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           this.mainframe.setResizable(false);
           
           JPanel textPanel = new JPanel();
           JPanel buttonPanel = new JPanel();
           
           JLabel welcome = new JLabel("Welcome to Yggdrasil");
           JLabel option = new JLabel("Would you like to");
           JButton planButton = new JButton("Plan an adventure");
           planButton.addActionListener(new ButtonHandler(this.mainframe, null, null, null, null, null));
           JButton directionsButton = new JButton("Get Directions");
           directionsButton.addActionListener(new ButtonHandler(this.mainframe, null, null, null, null, null));
           
           textPanel.setBounds(583, 284, 200, 55);
           buttonPanel.setBounds(533, 384, 300, 50);
           
           textPanel.add(welcome);
           textPanel.add(option);
           buttonPanel.add(planButton, BorderLayout.WEST);
           buttonPanel.add(new JLabel("or"), BorderLayout.CENTER);
           buttonPanel.add(directionsButton, BorderLayout.EAST);
           
           this.mainframe.setLayout(null);
           this.mainframe.add(textPanel);
           this.mainframe.add(buttonPanel);
     }
}
