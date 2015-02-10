import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ButtonHandler implements ActionListener {
	
	public void actionPerformed(ActionEvent ae) {
		 String action = ae.getActionCommand();
	     if(action.equals("Plan an adventure")) {
	         System.out.println("Plan pressed!");
	         new PlannerGUI();
	     }
	     else if(action.equals("Get Directions")) {
	         System.out.println("Directions pressed!");
	         new MapGUI();
	     }
	     else if(action.equals("Create Adventure")){
	    	 System.out.println("Create pressed!");
	    	 new MapGUI();
	     }
     }
}
