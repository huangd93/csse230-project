import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

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
	private PlacesDao pdi;
	
	public MapGUI(JFrame frame, String start, String startRealm, String dest, String destRealm){
		this.mainframe = frame;
    	this.mainframe.getContentPane().removeAll();
    	this.mainframe.getContentPane().revalidate();
    	this.mainframe.setBackground(Color.BLACK);
    	this.mainframe.setTitle("Your Adventure");
    	this.pdi = PlacesDaoFactory.getPlacesDaoSingleton();
    	
    	JPanel mainPanel = new JPanel();
    	MigLayout layout = new MigLayout();
    	mainPanel.setLayout(layout);
    	mainPanel.setSize(1366, 768);
    	
    	JPanel controlPanel = new JPanel();
    	JPanel direcsPanel = new JPanel();
    	JPanel mapPanel = new JPanel();
	       
	    JLabel startChoice = new JLabel("Choose your starting point: ");
	    
	    String[] realms = {"(Choose a Realm)","Asgard","Jotunheim","Niflheim","Vanaheim","Alfheim","Midgard","Svartalfheim","Nidavellir","Muspelheim"};
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
	    createButton.addActionListener(new ButtonHandler(this.mainframe, direcsPanel, null, null, startList, realmList1, destinationList, realmList2, null));
	    
	    JButton planButton = new JButton("Plan an adventure");
	    planButton.addActionListener(new ButtonHandler(this.mainframe, mainPanel, null, null, null, null, null, null, null));
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
	    
	    String imageLoc = "C:/EclipseWorkspaces/csse230/csse230-project/yggdrasil.jpg";
	    mapPanel.add(new JLabel(new ImageIcon(imageLoc)));
	    
	    
	    direcsPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
	    Place sp = this.pdi.getPlace(start, startRealm);
   	    Place ep = this.pdi.getPlace(dest, destRealm);
	    String fastString = "Here is the fastest route: \n";
	   	ArrayList<Connection> fastRoute = this.pdi.getFastestRoute(sp, ep);
	   	for(Connection c : fastRoute){
	   		Route r = c.getRoute();
	   		ArrayList<Point> points = r.getPoints();
	   		for(Point p : points){
	   		// maybe want places as well as points
	   		}
	   	}
	   	 
	   	String shortString = "Here is the shortest route: \n";
	   	ArrayList<Connection> shortRoute = this.pdi.getShortestRoute(sp, ep);
	   	for(Connection c : shortRoute){
	   		 Route r = c.getRoute();
	   		 ArrayList<Point> points = r.getPoints();
	   		 for(Point p : points){
	   		 // maybe want places as well as points
	   	     }
	   	}
	   	JLabel direcsLabel = new JLabel(fastString + shortString);
	   	direcsPanel.add(direcsLabel);
	    
	    mainPanel.add(controlPanel, "dock north, h 55!, w 1354!");
	    mainPanel.add(direcsPanel, "cell 0 1, h 670!, w 350!");
	    mainPanel.add(mapPanel, "cell 1 1, h 670!, w 1000!");
	    
	    this.mainframe.add(mainPanel);
	}
	
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
	    
	    String[] realms = {"(Choose a Realm)","Asgard","Jotunheim","Niflheim","Vanaheim","Alfheim","Midgard","Svartalfheim","Nidavellir","Muspelheim"};
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
	    createButton.addActionListener(new ButtonHandler(this.mainframe, direcsPanel, null, null, startList, realmList1, destinationList, realmList2, null));
	    
	    JButton planButton = new JButton("Plan an adventure");
	    planButton.addActionListener(new ButtonHandler(this.mainframe, mainPanel, null, null, null, null, null, null, null));
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
	    
	    String imageLoc = "C:/EclipseWorkspaces/csse230/csse230-project/yggdrasil.jpg";
	    mapPanel.add(new JLabel(new ImageIcon(imageLoc)));
	    
	    direcsPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
	    
	    mainPanel.add(controlPanel, "dock north, h 55!, w 1354!");
	    mainPanel.add(direcsPanel, "cell 0 1, h 670!, w 350!");
	    mainPanel.add(mapPanel, "cell 1 1, h 670!, w 1000!");
	    
	    this.mainframe.add(mainPanel);
	}
}
