import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class DropDownHandler implements ActionListener {

	String[] startStrings;
	
	public DropDownHandler(String[] list){
		this.startStrings = list;
	}
	
	public void actionPerformed(ActionEvent e) {
		JComboBox combo = (JComboBox)e.getSource();
	    String current = (String)combo.getSelectedItem();
	     if(current.equals("Asgard")) {
	    	 String[] asgardStrings = {"Valhalla","Odin’s Fortress","Lake Logur","Asgard Mountains","Sea of Marmora"};
	    	 this.startStrings = asgardStrings;
	         System.out.println("You're in Asgard!");
	     }
//	     if(String.valueOf(realmList.getSelectedItem()) == "Asgard"){
//	     }
//	     else if(String.valueOf(realmList.getSelectedItem()) == "Utgard"){
//	    	String[] utgardStrings = {"The River Iving","Mimir’s Well of Wisdom","Utgard-Loki’s Throne","Griotunagardar","The Mountain Thrymheim"};
//	    	startStrings = utgardStrings;
//	     }
//	     else if(String.valueOf(realmList.getSelectedItem()) == "Niflheim"){
//	    	String[] niflheimStrings = {"The Spring Hvergelmir","The Plains of Ginnungagap","The Rivers Elivagar","Helheim (Hel’s Throne)","Fimbulthul"};
//	    	startStrings = niflheimStrings;
//	     }
	}

}
