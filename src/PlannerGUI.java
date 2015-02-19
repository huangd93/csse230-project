import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlannerGUI{
	/**
     * Mainframe.
     */
     JFrame mainframe;
     
     /**
     * Constructs the Planner GUI from start screen.
     */
     public PlannerGUI(JFrame frame) {
    	 this.mainframe = frame;
    	 this.mainframe.getContentPane().removeAll();
    	 this.mainframe.getContentPane().revalidate();
    	 this.mainframe.setBackground(Color.GREEN);
    	 this.mainframe.setTitle("Yggdrasil (The World Tree): Plan Adventure");
    	 
	     JPanel mainPanel = new JPanel();
	     
	     JLabel startChoice = new JLabel("Where is your starting location?");
	     String[] realms = {"(Choose a Realm)","Asgard","Jotunheim","Niflheim","Vanaheim","Alfheim","Midgard","Svartalfheim","Nidavellir","Muspelheim"};
		 JComboBox realmList = new JComboBox(realms);
		 String[] startStrings = {"(Please Choose a Realm)"};
		 DefaultComboBoxModel startModel = new DefaultComboBoxModel(startStrings);
	     JComboBox startList = new JComboBox();
	     startList.setModel(startModel);
	     realmList.addActionListener(new DropDownHandler(null, startList, mainPanel));
	       
	     JLabel distanceChoice = new JLabel("What is the max distance you would like to travel?");
	     JTextField distanceInput = new JTextField();
	     Dimension size = new Dimension(100, 20);
		 distanceInput.setMinimumSize(size);
		 distanceInput.setPreferredSize(size);
		 distanceInput.setSize(size);
	     
	     JLabel timeChoice = new JLabel("What is the max time you would like your adventure to be?");
	     JTextField timeInput = new JTextField();
	     timeInput.setMaximumSize(size);
	     timeInput.setPreferredSize(size);
	     timeInput.setSize(size);
	     
	     JButton optionsButton = new JButton("Get Options");
	     optionsButton.addActionListener(new ButtonHandler(this.mainframe, mainPanel, null, distanceInput, timeInput, startList, realmList, null, null, null));
	     
	     mainPanel.setBounds(433, 115, 500, 550);
	     
	     mainPanel.add(startChoice);
	     mainPanel.add(realmList);
	     mainPanel.add(startList);
	     mainPanel.add(distanceChoice);
	     mainPanel.add(distanceInput);
	     mainPanel.add(timeChoice);
	     mainPanel.add(timeInput);
	     mainPanel.add(optionsButton);
	      
	     this.mainframe.setLayout(null);
	     this.mainframe.add(mainPanel);
     }
     
     /**
      * Constructs the Planner GUI from error.
      */
      public PlannerGUI(JFrame frame, JLabel error) {
     	 this.mainframe = frame;
     	 this.mainframe.getContentPane().removeAll();
     	 this.mainframe.getContentPane().revalidate();
     	 this.mainframe.setBackground(Color.GREEN);
     	 this.mainframe.setTitle("Yggdrasil (The World Tree): Plan Adventure");
     	 
 	     JPanel mainPanel = new JPanel();
 	     
 	     JLabel startChoice = new JLabel("Where is your starting location?");
 	     String[] realms = {"(Choose a Realm)","Asgard","Jotunheim","Niflheim","Vanaheim","Alfheim","Midgard","Svartalfheim","Nidavellir","Muspelheim"};
 		 JComboBox realmList = new JComboBox(realms);
 		 String[] startStrings = {"(Please Choose a Realm)"};
 		 DefaultComboBoxModel startModel = new DefaultComboBoxModel(startStrings);
 	     JComboBox startList = new JComboBox();
 	     startList.setModel(startModel);
 	     realmList.addActionListener(new DropDownHandler(null, startList, mainPanel));
 	       
 	     JLabel distanceChoice = new JLabel("What is the max distance you would like to travel?");
 	     JTextField distanceInput = new JTextField();
 	     Dimension size = new Dimension(100, 20);
 		 distanceInput.setMinimumSize(size);
 		 distanceInput.setPreferredSize(size);
 		 distanceInput.setSize(size);
 	     
 	     JLabel timeChoice = new JLabel("What is the max time you would like your adventure to be?");
 	     JTextField timeInput = new JTextField();
 	     timeInput.setMaximumSize(size);
 	     timeInput.setPreferredSize(size);
 	     timeInput.setSize(size);
 	     
 	     JButton optionsButton = new JButton("Get Options");
 	     optionsButton.addActionListener(new ButtonHandler(this.mainframe, mainPanel, null, distanceInput, timeInput, startList, realmList, null, null, null));
 	     
 	     mainPanel.setBounds(433, 115, 500, 550);
 	     
 	     mainPanel.add(error);
 	     mainPanel.add(startChoice);
 	     mainPanel.add(realmList);
 	     mainPanel.add(startList);
 	     mainPanel.add(distanceChoice);
 	     mainPanel.add(distanceInput);
 	     mainPanel.add(timeChoice);
 	     mainPanel.add(timeInput);
 	     mainPanel.add(optionsButton);
 	      
 	     this.mainframe.setLayout(null);
 	     this.mainframe.add(mainPanel);
      }
}