import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class DropDownHandler implements ActionListener {

	String[] startStrings;
	JComboBox startList;
	private JPanel controlPanel;
	
	public DropDownHandler(String[] list, JComboBox combo, JPanel pan){
		this.startStrings = list;
		this.startList = combo;
		this.controlPanel = pan;
	}
	
	public void actionPerformed(ActionEvent e) {
		JComboBox combo = (JComboBox)e.getSource();
	    String current = (String)combo.getSelectedItem();
	     if(current.equals("Asgard")) {
	    	 String[] asgardStrings = {"Valhalla","Odin’s Fortress","Lake Logur","Asgard Mountains","Sea of Marmora"};
	    	 JComboBox startList = new JComboBox(asgardStrings);
	    	 this.controlPanel.revalidate();
	    	 this.controlPanel.add(startList);
	         System.out.println("You're in Asgard!");
	     }
	     else if(current.equals("Utgard")){
	    	String[] utgardStrings = {"The River Iving","Mimir’s Well of Wisdom","Utgard-Loki’s Throne","Griotunagardar","The Mountain Thrymheim"};
	    	JComboBox startList = new JComboBox(utgardStrings);
	    	this.controlPanel.revalidate();
	    	this.controlPanel.add(startList);
	    	System.out.println("You're in Utgard!");
	     }
//	     else if(String.valueOf(realmList.getSelectedItem()) == "Niflheim"){
//	    	String[] niflheimStrings = {"The Spring Hvergelmir","The Plains of Ginnungagap","The Rivers Elivagar","Helheim (Hel’s Throne)","Fimbulthul"};
//	    	startStrings = niflheimStrings;
//	     }
	}

}
