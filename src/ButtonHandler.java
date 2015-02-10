import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ButtonHandler implements ActionListener {
	
	JFrame mainframe;
	
	public ButtonHandler(JFrame frame){
		this.mainframe = frame;
	}
	
	public void actionPerformed(ActionEvent ae) {
		 String action = ae.getActionCommand();
	     if(action.equals("Plan an adventure")) {
	         System.out.println("Plan pressed!");
	         new PlannerGUI(this.mainframe);
	     }
	     else if(action.equals("Get Directions")) {
	         System.out.println("Directions pressed!");
	         new MapGUI(this.mainframe);
	     }
	     else if(action.equals("Create Adventure")){
	    	 System.out.println("Create pressed!");
	    	 new MapGUI(this.mainframe);
	     }
     }
}
