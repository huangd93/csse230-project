import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlannerGUI implements PlacesDaoInterface{
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
	     
	     JLabel startChoice = new JLabel("Where is your starting location?");
	     String[] startStrings = {"Valhalla","Odin’s Fortress","Lake Logur","Asgard Mountains","Sea of Marmora",
	    		 "The River Iving","Mimir’s Well of Wisdom","Utgard-Loki’s Throne","Griotunagardar","The Mountain Thrymheim",
	    		 "The Spring Hvergelmir","The Plains of Ginnungagap","The Rivers Elivagar","Helheim (Hel’s Throne)","Fimbulthul",
	    		 "The Forests of the Vanir","Don River","The Home of Njord","Eiglopian Mountains","Pictish Wilderness",
	    		 "Freyr’s Throne","Geffen","Canolbarth Forest",
	    		 "New York City","Washington D.C.","Puente Antiguo, New Mexico","London, England","Wheaton, New Jersey",
	    		 "The Domain of Malekith","The Black Forest","The Unseelie Court","Aurvangar","Byrgir",
	    		 "Hreidmar’s Kingdom","The Dark Fields","The Furnaces of Nidavellir","Durin’s Hall","Dvalin’s Hall",
	    		 "The Burning Plains of Surt","Sinmore Hall","Surtur’s Kingdom"};
	     JComboBox startList = new JComboBox(startStrings);
	       
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
	     
	     JButton optionsButton = new JButton("Get Options");
	     optionsButton.addActionListener(new ButtonHandler(this.mainframe, mainPanel, distanceList, timeList, startList));
	     
	     mainPanel.setBounds(433, 115, 500, 550);
	     
	     mainPanel.add(startChoice);
	     mainPanel.add(startList);
	     mainPanel.add(distanceChoice);
	     mainPanel.add(distanceList);
	     mainPanel.add(timeChoice);
	     mainPanel.add(timeList);
	     mainPanel.add(optionsButton);
	      
	     this.mainframe.setLayout(null);
	     this.mainframe.add(mainPanel);
     }
}