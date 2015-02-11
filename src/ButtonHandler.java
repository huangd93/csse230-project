import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ButtonHandler implements ActionListener {
	
	JFrame mainframe;
	JPanel panel;
	
	public ButtonHandler(JFrame frame, JPanel pan){
		this.mainframe = frame;
		this.panel = pan;
	}
	
	public void actionPerformed(ActionEvent ae) {
		 String action = ae.getActionCommand();
	     if(action.equals("Plan an adventure")) {
	         System.out.println("Plan an adventure pressed!");
	         new PlannerGUI(this.mainframe);
	     }
	     else if(action.equals("Get Directions")) {
	         System.out.println("Get Directions pressed!");
	         new MapGUI(this.mainframe);
	     }
	     else if(action.equals("Create Adventure")){
	    	 System.out.println("Create Adventure pressed!");
	    	 new MapGUI(this.mainframe);
	     }
	     else if(action.equals("Create")){
	    	 System.out.println("Create pressed!");
	    	 this.panel.removeAll();
	     	 this.panel.revalidate();
	    	 this.panel.add(new JLabel("Directions will be placed here"));
	    	 this.mainframe.revalidate();
	     }
     }
}
