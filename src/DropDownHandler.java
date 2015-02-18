import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class DropDownHandler implements ActionListener {

	String[] startStrings;
	JComboBox list;
	PlacesDaoInterface pdi;
	private JPanel controlPanel;
	
	public DropDownHandler(String[] list, JComboBox combo, JPanel pan){
		this.list = combo;
		this.controlPanel = pan;
		this.pdi = PlacesDaoFactory.getPlacesDaoSingleton();
	}
	
	public void actionPerformed(ActionEvent e) {
		JComboBox combo = (JComboBox)e.getSource();
	    String current = (String)combo.getSelectedItem();
	    Realm realm = Realm.stringToRealm(current);
	    ArrayList<Place> placesArray = this.pdi.getPlacesInRealm(realm);
	    
	    ArrayList<String> placesStringArray = new ArrayList<String>();
	    for(int i = 0; i < placesArray.size(); i++){
	    	placesStringArray.add(i, placesArray.get(i).getName());
	    }
	    Object[] placesStrings = placesStringArray.toArray();
	    if(current.equals("(Choose a Realm)")){
	    	 String[] defaultString = {"(Please Choose a Realm)"};
	    	 DefaultComboBoxModel model = new DefaultComboBoxModel(defaultString);
	    	 this.list.setModel(model);
	    	 this.controlPanel.revalidate();
	    }
	    else if(current.equals("Asgard")) {
	    	 DefaultComboBoxModel model = new DefaultComboBoxModel(placesStrings);
	    	 this.list.setModel(model);
	    	 this.controlPanel.revalidate();
	     }
	     else if(current.equals("Jotunheim")){
	    	DefaultComboBoxModel model = new DefaultComboBoxModel(placesStrings);
	    	this.list.setModel(model);
	    	this.controlPanel.revalidate();
	     }
	     else if(current.equals("Niflheim")){
	    	DefaultComboBoxModel model = new DefaultComboBoxModel(placesStrings);
	    	this.list.setModel(model);
	    	this.controlPanel.revalidate();
	     }
	     else if(current.equals("Vanaheim")){
	    	DefaultComboBoxModel model = new DefaultComboBoxModel(placesStrings);
	    	this.list.setModel(model);
	    	this.controlPanel.revalidate();
	     }
	     else if(current.equals("Alfheim")){
	    	DefaultComboBoxModel model = new DefaultComboBoxModel(placesStrings);
	    	this.list.setModel(model);
	    	this.controlPanel.revalidate();
		 }
	     else if(current.equals("Midgard")){
	    	DefaultComboBoxModel model = new DefaultComboBoxModel(placesStrings);
	    	this.list.setModel(model);
	    	this.controlPanel.revalidate();
		 }
	     else if(current.equals("Svartalfheim")){
	    	DefaultComboBoxModel model = new DefaultComboBoxModel(placesStrings);
	    	this.list.setModel(model);
	    	this.controlPanel.revalidate();
		 }
	     else if(current.equals("Nidavellir")){
	    	DefaultComboBoxModel model = new DefaultComboBoxModel(placesStrings);
	    	this.list.setModel(model);
	    	this.controlPanel.revalidate();
		 }
	     else if(current.equals("Muspelheim")){
	    	DefaultComboBoxModel model = new DefaultComboBoxModel(placesStrings);
	    	this.list.setModel(model);
	    	this.controlPanel.revalidate();
		 }
	}

}
