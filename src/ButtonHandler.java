import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ButtonHandler implements ActionListener {
	
	JFrame mainframe;
	JPanel panel;
	JTextField distance;
	JTextField time;
	JComboBox realmCombo;
	JComboBox placeCombo;
	PlacesDaoInterface pdi;
	
	public ButtonHandler(JFrame frame, JPanel pan, JTextField distanceInput, JTextField timeInput, JComboBox combo3, JComboBox combo4){
		this.mainframe = frame;
		this.panel = pan;
		this.distance = distanceInput;
		this.time = timeInput;
		this.realmCombo = combo4;
		this.placeCombo = combo3;
		this.pdi = PlacesDaoFactory.getPlacesDaoSingleton();
	}
	
	public void actionPerformed(ActionEvent ae) {
		 String action = ae.getActionCommand();
	     if(action.equals("Plan an adventure")) {
	         new PlannerGUI(this.mainframe);
	     }
	     else if(action.equals("Get Directions")) {
	         new MapGUI(this.mainframe);
	     }
	     else if(action.equals("Get Options")){
	    	 String realm = (String)this.realmCombo.getSelectedItem();
	    	 String place = (String)this.placeCombo.getSelectedItem();
	 	     String dist = this.distance.getText();
	 	     String time = this.time.getText();
	 	     double d = Double.parseDouble(dist);
	 	     double t = Double.parseDouble(time);
	 	     Place p = this.pdi.getPlace(place, realm);
	 	     
	 	     
	    	 this.panel.removeAll();
	    	 this.panel.revalidate();
	    	 this.mainframe.getContentPane().removeAll();
	    	 this.mainframe.getContentPane().revalidate();
	    	 this.mainframe.setBackground(Color.BLACK);
	    	 this.mainframe.add(this.panel);
	    	 
//			 ArrayList<Place> routeList = this.pdi.getPlacesWithin(p, d, t);
			 String temp = "Adventure options: ";
//	    	 for(Place dest : routeList){
//	    		 temp += "Travel from " + place + " to " + dest.getName();
//	    	 }
	    	 JLabel options = new JLabel(temp);
	    	 JButton go = new JButton("Get Directions");
	    	 go.addActionListener(new ButtonHandler(this.mainframe, this.panel, null, null, null, null));
	    	 this.panel.add(options);
	    	 this.panel.add(go);
	     }
	     else if(action.equals("Create")){
	    	 this.panel.removeAll();
	     	 this.panel.revalidate();
	    	 this.panel.add(new JLabel("Directions will be placed here"));
	    	 this.mainframe.revalidate();
	     }
     }
}
