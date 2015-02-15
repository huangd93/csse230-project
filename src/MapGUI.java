import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;


public class MapGUI {
	private JFrame mainframe;
	public MapGUI(JFrame frame){
		this.mainframe = frame;
    	this.mainframe.getContentPane().removeAll();
    	this.mainframe.getContentPane().revalidate();
    	this.mainframe.setBackground(Color.BLACK);
    	this.mainframe.setTitle("Your Adventure");
    	
    	JPanel mainPanel = new JPanel();
    	MigLayout layout = new MigLayout();
    	mainPanel.setLayout(layout);
    	mainPanel.setSize(1366, 768);
    	
    	JPanel controlPanel = new JPanel();
    	JPanel direcsPanel = new JPanel();
    	JPanel mapPanel = new JPanel();
	       
	    JLabel startChoice = new JLabel("Choose your starting point: ");
	    
	    String[] realms = {"(Choose a Realm)","Asgard","Utgard","Niflheim","Vanaheim","Alfheim","Midgard","Svartalfheim","Nidavellir","Muspelheim"};
	    JComboBox realmList1 = new JComboBox(realms);
	    String[] startStrings = {"(Please Choose a Realm)"};
	    DefaultComboBoxModel startModel = new DefaultComboBoxModel(startStrings);

	    JComboBox startList = new JComboBox();
	    startList.setModel(startModel);
	    realmList1.addActionListener(new DropDownHandler(null, startList, controlPanel));
	    
	    JLabel destinationChoice = new JLabel("Choose your destination: ");
	    
	    JComboBox realmList2 = new JComboBox(realms);
	    JComboBox destinationList = new JComboBox();
	    DefaultComboBoxModel destModel = new DefaultComboBoxModel(realms);
	    destinationList.setModel(destModel);
	    realmList2.addActionListener(new DropDownHandler(null, destinationList, controlPanel));
	    
	    JButton createButton = new JButton("Create");
	    createButton.addActionListener(new ButtonHandler(this.mainframe, direcsPanel, null, null, null));
	    JButton planButton = new JButton("Plan an adventure");
	    planButton.addActionListener(new ButtonHandler(this.mainframe, mainPanel, null, null, null));
	    controlPanel.add(startChoice);
	    controlPanel.add(realmList1);
	    controlPanel.add(startList);
	    controlPanel.add(destinationChoice);
	    controlPanel.add(realmList2);
	    controlPanel.add(destinationList);
	    controlPanel.add(createButton);
	    controlPanel.add(new JLabel("      or      "));
	    controlPanel.add(planButton);
	    controlPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
	    
	    String imageLoc = "C:/EclipseWorkspaces/csse230/csse230-project/Yggdrasill_Animated_2.jpg";
	    mapPanel.add(new JLabel(new ImageIcon(imageLoc)));
	    
	    direcsPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
	    
	    mainPanel.add(controlPanel, "dock north, h 55!, w 1354!");
	    mainPanel.add(direcsPanel, "cell 0 1, h 670!, w 350!");
	    mainPanel.add(mapPanel, "cell 1 1, h 670!, w 1000!");
	    
	    this.mainframe.add(mainPanel);
	}
}
