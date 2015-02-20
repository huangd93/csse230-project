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

import net.miginfocom.swing.MigLayout;

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
    	 
    	 MigLayout layout = new MigLayout();
	     JPanel mainPanel = new JPanel(layout);
	     
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
	     
	     JLabel ratingChoice = new JLabel("What is the min rating you would like for your adventure?");
	     JTextField ratingInput = new JTextField();
	     ratingInput.setMaximumSize(size);
	     ratingInput.setPreferredSize(size);
	     ratingInput.setSize(size);
	     
	     JButton optionsButton = new JButton("Get Options");
	     optionsButton.addActionListener(new ButtonHandler(this.mainframe, mainPanel, null, distanceInput, timeInput, ratingInput, startList, realmList, null, null, null));
	     
	     mainPanel.setBounds(433, 115, 800, 550);
	     
	     mainPanel.add(startChoice, "cell 0 0");
	     mainPanel.add(realmList, "cell 1 0");
	     mainPanel.add(startList, "cell 2 0");
	     
	     mainPanel.add(distanceChoice, "cell 0 1");
	     mainPanel.add(distanceInput, "cell 1 1");
	     
	     mainPanel.add(timeChoice, "cell 0 2");
	     mainPanel.add(timeInput, "cell 1 2");
	     
	     mainPanel.add(ratingChoice, "cell 0 3");
	     mainPanel.add(ratingInput, "cell 1 3");
	     
	     mainPanel.add(optionsButton, "cell 0 4");
	      
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
     	 
     	 MigLayout layout = new MigLayout();
	     JPanel mainPanel = new JPanel(layout);
 	     
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
 	     
 	     JLabel ratingChoice = new JLabel("What is the min rating you would like for your adventure?");
	     JTextField ratingInput = new JTextField();
	     ratingInput.setMaximumSize(size);
	     ratingInput.setPreferredSize(size);
	     ratingInput.setSize(size);
 	     
 	     JButton optionsButton = new JButton("Get Options");
 	     optionsButton.addActionListener(new ButtonHandler(this.mainframe, mainPanel, null, distanceInput, timeInput, ratingInput, startList, realmList, null, null, null));
 	     
 	     mainPanel.setBounds(433, 115, 800, 550);
 	     
 	     mainPanel.add(error);
 	     mainPanel.add(startChoice, "cell 0 0");
	     mainPanel.add(realmList, "cell 1 0");
	     mainPanel.add(startList, "cell 2 0");
	     
	     mainPanel.add(distanceChoice, "cell 0 1");
	     mainPanel.add(distanceInput, "cell 1 1");
	     
	     mainPanel.add(timeChoice, "cell 0 2");
	     mainPanel.add(timeInput, "cell 1 2");
	     
	     mainPanel.add(ratingChoice, "cell 0 3");
	     mainPanel.add(ratingInput, "cell 1 3");
	     
	     mainPanel.add(optionsButton, "cell 0 4");
 	      
 	     this.mainframe.setLayout(null);
 	     this.mainframe.add(mainPanel);
      }
}