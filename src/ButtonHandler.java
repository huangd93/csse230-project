import java.awt.Color;
import java.awt.Component;
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
	JComboBox startRealmCombo;
	JComboBox startPlaceCombo;
	JComboBox endRealmCombo;
	JComboBox endPlaceCombo;
	PlacesDaoInterface pdi;
	
	private String s;
	private String d;
	private String sr;
	private String dr;
	
	public ButtonHandler(JFrame frame, JPanel pan, JTextField distanceInput, 
			JTextField timeInput, JComboBox startPlaceCombo, JComboBox startRealmCombo,
			JComboBox endPlaceCombo, JComboBox endRealmCombo){
		this.mainframe = frame;
		this.panel = pan;
		this.distance = distanceInput;
		this.time = timeInput;
		this.startRealmCombo = startRealmCombo;
		this.startPlaceCombo = startPlaceCombo;
		this.endRealmCombo = endRealmCombo;
		this.endPlaceCombo = endPlaceCombo;
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
	    	 this.panel.removeAll();
	    	 this.panel.revalidate();
	    	 this.mainframe.getContentPane().removeAll();
	    	 this.mainframe.getContentPane().revalidate();
	    	 this.mainframe.setBackground(Color.BLACK);
	    	 this.mainframe.add(this.panel);
	    	 this.pdi = PlacesDaoFactory.getPlacesDaoSingleton();
	    	 
	    	 String realm = (String)this.startRealmCombo.getSelectedItem();
	    	 String place = (String)this.startPlaceCombo.getSelectedItem();
	 	     String dist = this.distance.getText();
	 	     String time = this.time.getText();
	 	     double d;
	 	     double t;
	 	     if(dist == null || time == null){
	 	    	 // handle this exception
	 	    	 d = 0;
	 	    	 t = 0;
	 	     }else{
	 	    	 d = Double.parseDouble(dist);
	 	    	 t = Double.parseDouble(time);	 	    	 
	 	     }
	 	     
	 	     Place p = this.pdi.getPlace(place, realm);
	 	     
			 ArrayList<Place> routeList = this.pdi.getPlacesWithin(p, d, t);
			 for(Place i : routeList){
				 System.out.println(i.getName());
			 }
			 String temp = "Adventure options: ";
	    	 for(Place dest : routeList){
	    		 temp += "Travel from " + place + " to " + dest.getName();
	    	 }
	    	 JLabel options = new JLabel(temp);
	    	 JButton get = new JButton("Get Directions");
	    	 get.addActionListener(new ButtonHandler(this.mainframe, this.panel, null, null, null, null, null, null));
	    	 this.panel.add(options);
	    	 this.panel.add(get);
	     }
	     else if(action.equals("Create")){
	    	 this.panel.removeAll();
	     	 this.panel.revalidate();
	     	 this.mainframe.revalidate();
	     	 
	     	 String startRealm = (String)this.startRealmCombo.getSelectedItem();
	    	 String startPlace = (String)this.startPlaceCombo.getSelectedItem();
	    	 String endRealm = (String)this.endRealmCombo.getSelectedItem();
	    	 String endPlace = (String)this.endPlaceCombo.getSelectedItem();
	    	 
	    	 Place sp = this.pdi.getPlace(startPlace, startRealm);
	    	 Place ep = this.pdi.getPlace(endPlace, endRealm);
	    	 
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
			 JLabel directions = new JLabel(fastString + shortString );
	     	 
			 this.panel.add(directions);
	     }
     }
}
