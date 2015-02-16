import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ButtonHandler implements ActionListener {
	
	JFrame mainframe;
	JPanel panel;
	JComboBox distanceCombo;
	JComboBox timeCombo;
	JComboBox placeCombo;
	PlacesDaoInterface pdi;
	
	public ButtonHandler(JFrame frame, JPanel pan, JComboBox combo1, JComboBox combo2, JComboBox combo3){
		this.mainframe = frame;
		this.panel = pan;
		this.distanceCombo = combo1;
		this.timeCombo = combo2;
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
	 	     String dist = (String)this.distanceCombo.getSelectedItem();
	 	     String time = (String)this.timeCombo.getSelectedItem();
	    	 this.panel.removeAll();
	    	 this.panel.revalidate();
	    	 this.mainframe.getContentPane().removeAll();
	    	 this.mainframe.getContentPane().revalidate();
	    	 this.mainframe.setBackground(Color.BLACK);
	    	 this.mainframe.add(this.panel);
	    	 JLabel options = new JLabel();
	    	 JButton go = new JButton("Get Directions");
	    	 go.addActionListener(new ButtonHandler(this.mainframe, this.panel, null, null, null));
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
