import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlannerGUI {
	/**
     * Mainframe.
     */
     JFrame mainframe;
     
     /**
     * Constructs the Planner GUI.
     */
     public PlannerGUI(JFrame frame) {
    	 this.mainframe = frame;
    	 this.mainframe.getContentPane().removeAll();
    	 this.mainframe.getContentPane().revalidate();
    	 this.mainframe.setBackground(Color.GREEN);
    	 this.mainframe.setTitle("Yggdrasil (The World Tree): Plan Adventure");
    	 
	     JPanel mainPanel = new JPanel();
	       
	     JLabel distanceChoice = new JLabel("How far would you like to travel?");
	     String[] distanceStrings = {"Less than 100 miles","Between 100 and 200 miles","Between 200 and 300 miles",
	       "Between 300 and 400 miles","Greater than 400 miles",
	     };
	     JComboBox distanceList = new JComboBox(distanceStrings);
	     JLabel timeChoice = new JLabel("How long would you like your adventure to be?");
	     String[] timeStrings = {"Less than 1 hour","Between 1 and 2 hours","Between 2 and 3 hours",
	       "Between 3 and 4 hours","Greater than 4 hours",
	     };
	     JComboBox timeList = new JComboBox(timeStrings);
	     JButton planButton = new JButton("Create Adventure");
	     planButton.addActionListener(new ButtonHandler(this.mainframe, null));
	     
	     mainPanel.setBounds(433, 115, 500, 550);
	     
	     mainPanel.add(distanceChoice);
	     mainPanel.add(distanceList);
	     mainPanel.add(timeChoice);
	     mainPanel.add(timeList);
	     mainPanel.add(planButton);
	      
	     this.mainframe.setLayout(null);
	     this.mainframe.add(mainPanel);
     }
}