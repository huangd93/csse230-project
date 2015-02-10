import java.awt.Color;

import javax.swing.JFrame;


public class MapGUI {
	private JFrame mainframe;
	public MapGUI(JFrame frame){
		this.mainframe = frame;
		this.mainframe = frame;
    	this.mainframe.getContentPane().removeAll();
    	this.mainframe.getContentPane().revalidate();
    	this.mainframe.setBackground(Color.GRAY);
    	this.mainframe.setTitle("Your Adventure");
        
        
	}
}
