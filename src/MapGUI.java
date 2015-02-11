import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
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
	    
	    String[] realms = {"Asgard", "Utgard","Niflheim","Vanaheim","Alfheim","Midgard","Svartalfheim","Nidavellir","Muspelheim"};
	    JComboBox realmList = new JComboBox(realms);
	    String[] startStrings = null;
	    if(String.valueOf(realmList.getSelectedItem()) == "Asgard"){
	    	String[] asgardStrings = {"Valhalla","Odin�s Fortress","Lake Logur","Asgard Mountains","Sea of Marmora"};
	    	startStrings = asgardStrings;
	    }
	    else if(String.valueOf(realmList.getSelectedItem()) == "Utgard"){
	    	String[] utgardStrings = {"The River Iving","Mimir�s Well of Wisdom","Utgard-Loki�s Throne","Griotunagardar","The Mountain Thrymheim"};
	    	startStrings = utgardStrings;
	    }
	    else if(String.valueOf(realmList.getSelectedItem()) == "Niflheim"){
	    	String[] niflheimStrings = {"The Spring Hvergelmir","The Plains of Ginnungagap","The Rivers Elivagar","Helheim (Hel�s Throne)","Fimbulthul"};
	    	startStrings = niflheimStrings;
	    }
	    realmList.addActionListener(new DropDownHandler(startStrings));
	    JComboBox startList = new JComboBox(startStrings);
	    
	    JLabel destinationChoice = new JLabel("Choose your destination: ");
	    
	    String[] destinationStrings = {"Valhalla","Odin�s Fortress","Lake Logur","Asgard Mountains","Sea of Marmora"};
	    JComboBox destinationList = new JComboBox(destinationStrings);
	    
	    JButton createButton = new JButton("Create");
	    createButton.addActionListener(new ButtonHandler(this.mainframe, direcsPanel));
	    JButton planButton = new JButton("Plan an adventure");
	    planButton.addActionListener(new ButtonHandler(this.mainframe, mainPanel));
	    controlPanel.add(realmList);
	    controlPanel.add(startChoice);
	    controlPanel.add(startList);
	    controlPanel.add(destinationChoice);
	    controlPanel.add(destinationList);
	    controlPanel.add(createButton);
	    controlPanel.add(new JLabel(" or "));
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
