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
//	    	String[] utgardStrings = {"The River Iving","Mimir’s Well of Wisdom","Utgard-Loki’s Throne","Griotunagardar","The Mountain Thrymheim"};
	    	DefaultComboBoxModel model = new DefaultComboBoxModel(placesStrings);
	    	this.list.setModel(model);
	    	this.controlPanel.revalidate();
	     }
	     else if(current.equals("Niflheim")){
//	    	String[] niflheimStrings = {"The Spring Hvergelmir","The Plains of Ginnungagap","The Rivers Elivagar","Helheim (Hel’s Throne)","Fimbulthul"};
	    	DefaultComboBoxModel model = new DefaultComboBoxModel(placesStrings);
	    	this.list.setModel(model);
	    	this.controlPanel.revalidate();
	     }
	     else if(current.equals("Vanaheim")){
//	    	String[] vanaheimStrings = {"The Forests of the Vanir","Don River","The Home of Njord","Eiglopian Mountains","Pictish Wilderness"};
	    	DefaultComboBoxModel model = new DefaultComboBoxModel(placesStrings);
	    	this.list.setModel(model);
	    	this.controlPanel.revalidate();
	     }
	     else if(current.equals("Alfheim")){
//	    	String[] vanaheimStrings = {"Freyr’s Throne","Geffen","Canolbarth Forest"};
	    	DefaultComboBoxModel model = new DefaultComboBoxModel(placesStrings);
	    	this.list.setModel(model);
	    	this.controlPanel.revalidate();
		 }
	     else if(current.equals("Midgard")){
//	    	String[] midgardStrings = {"New York City","Washington D.C.","Puente Antiguo, New Mexico","London, England","Wheaton, New Jersey"};
	    	DefaultComboBoxModel model = new DefaultComboBoxModel(placesStrings);
	    	this.list.setModel(model);
	    	this.controlPanel.revalidate();
		 }
	     else if(current.equals("Svartalfheim")){
//	    	String[] svartalfheimStrings = {"The Domain of Malekith","The Black Forest","The Unseelie Court","Aurvangar","Byrgir"};
	    	DefaultComboBoxModel model = new DefaultComboBoxModel(placesStrings);
	    	this.list.setModel(model);
	    	this.controlPanel.revalidate();
		 }
	     else if(current.equals("Nidavellir")){
//	    	String[] nidavellirStrings = {"Hreidmar’s Kingdom","The Dark Fields","The Furnaces of Nidavellir","Durin’s Hall","Dvalin’s Hall"};
	    	DefaultComboBoxModel model = new DefaultComboBoxModel(placesStrings);
	    	this.list.setModel(model);
	    	this.controlPanel.revalidate();
		 }
	     else if(current.equals("Muspelheim")){
//	    	String[] muspelheimStrings = {"The Burning Plains of Surt","Sinmore Hall","Surtur’s Kingdom"};
	    	DefaultComboBoxModel model = new DefaultComboBoxModel(placesStrings);
	    	this.list.setModel(model);
	    	this.controlPanel.revalidate();
		 }
	}

}
