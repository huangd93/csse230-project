import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ButtonHandler implements ActionListener {
	JFrame mainframe;
	JPanel panel;
	MapPanel mapPanel;
	JTextField distance;
	JTextField time;
	JComboBox startRealmCombo;
	JComboBox startPlaceCombo;
	JComboBox endRealmCombo;
	JComboBox endPlaceCombo;
	PlacesDaoInterface pdi;
	ButtonGroup group;

	private String s;
	private String d;
	private String sr;
	private String dr;

	public ButtonHandler(JFrame frame, JPanel mainPan, MapPanel mapPan, JTextField distanceInput,
			JTextField timeInput, JComboBox startPlaceCombo,
			JComboBox startRealmCombo, JComboBox endPlaceCombo,
			JComboBox endRealmCombo, ButtonGroup buttonGroup) {
		this.mainframe = frame;
		this.panel = mainPan;
		this.mapPanel = mapPan;
		this.distance = distanceInput;
		this.time = timeInput;
		this.startRealmCombo = startRealmCombo;
		this.startPlaceCombo = startPlaceCombo;
		this.endRealmCombo = endRealmCombo;
		this.endPlaceCombo = endPlaceCombo;
		this.pdi = PlacesDaoFactory.getPlacesDaoSingleton();
		this.group = buttonGroup;
	}

	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();

		if (action.equals("Plan an adventure")) {
			new PlannerGUI(this.mainframe);
		}

		else if (action.equals("Get Directions")) {
			new MapGUI(this.mainframe);
		}

		else if (action.equals("Get Your Directions")) {
			String startRealm = (String) this.startRealmCombo.getSelectedItem();
			String startPlace = (String) this.startPlaceCombo.getSelectedItem();
			String endPlace = "";
			String endRealm = "";
			String temp = "";
			this.group.getElements();
			for (Enumeration<AbstractButton> buttons = this.group.getElements(); buttons
					.hasMoreElements();) {
				AbstractButton button = buttons.nextElement();
				if (button.isSelected()) {
					temp = button.getText();
				}
			}
			String[] tempArr = temp.split("; ");
			endPlace = tempArr[0];
			endRealm = tempArr[1];
			new MapGUI(this.mainframe, startPlace, startRealm, endPlace,
					endRealm);
		}

		else if (action.equals("Get Options")) {
			this.panel.removeAll();
			this.panel.revalidate();
			this.mainframe.getContentPane().removeAll();
			this.mainframe.getContentPane().revalidate();
			this.mainframe.setBackground(Color.BLACK);
			this.mainframe.add(this.panel);
			this.pdi = PlacesDaoFactory.getPlacesDaoSingleton();

			String realm = (String) this.startRealmCombo.getSelectedItem();
			String place = (String) this.startPlaceCombo.getSelectedItem();
			String dist = this.distance.getText();
			String time = this.time.getText();
			double d = 0;
			double t = 0;
			if((!dist.isEmpty() && !time.isEmpty())){
				try{
				d = Double.parseDouble(dist);
				t = Double.parseDouble(time);				
				}catch (NumberFormatException ex){
				}
			}
			

			Place p = this.pdi.getPlace(place, realm);
			if(p == null){
				JLabel errorMessage = new JLabel("You must choose a starting location");
				errorMessage.setForeground(Color.RED);
				new PlannerGUI(this.mainframe, errorMessage);
			} else{
				ArrayList<Place> routeList = this.pdi.getPlacesWithin(p, d, t);
				String temp = "Adventure options: ";
				JLabel text = new JLabel(temp);
				this.panel.add(text);
				
				ButtonGroup group = new ButtonGroup();
				for (Place dest : routeList) {
					JRadioButton r = new JRadioButton(dest.getName() + "; "
							+ dest.getRealm().toString());
					group.add(r);
					this.panel.add(r);
				}
				if(group.getButtonCount() == 0){
					JLabel errorMessage = new JLabel("There were no options generated for the given restraints");
					errorMessage.setForeground(Color.RED);
					new PlannerGUI(this.mainframe, errorMessage);
				}else{
					JButton get = new JButton("Get Your Directions");
					get.addActionListener(new ButtonHandler(this.mainframe, this.panel, this.mapPanel,
							null, null, this.startPlaceCombo, this.startRealmCombo,
							null, null, group));
					this.panel.add(get);				
				}
			}


		}

		else if (action.equals("Create")) {
			this.panel.removeAll();
			this.panel.revalidate();
			this.mainframe.revalidate();

			String startRealm = (String) this.startRealmCombo.getSelectedItem();
			String startPlace = (String) this.startPlaceCombo.getSelectedItem();
			String endRealm = (String) this.endRealmCombo.getSelectedItem();
			String endPlace = (String) this.endPlaceCombo.getSelectedItem();

			Place sp = this.pdi.getPlace(startPlace, startRealm);
			Place ep = this.pdi.getPlace(endPlace, endRealm);
			if(sp == null || ep == null){
				JTextArea directions = new JTextArea(41, 29);
				directions.setLineWrap(true);
				directions.setText("You have to choose starting and ending locations!");

				this.panel.add(directions);
			}else{
				String fastString = "";
				fastString += "Here is the fastest route: " + "\n" + "Travel from "
						+ startPlace + " to ";
				String totalFastDistanceString = "The total distance is: ";
				ArrayList<Connection> fastRoute = this.pdi.getFastestRoute(sp, ep);
				double totalFastDistance = 0;
				double totalFastTime = 0;
				for (int i = fastRoute.size() - 1; i > -1; i--) {
					double time = Math.floor(fastRoute.get(i).getTime());
					totalFastTime += time;
					Route r = fastRoute.get(i).getRoute();
					Place nextPlace = fastRoute.get(i).getDestination();
					double distance = r.getDistance();
					totalFastDistance += distance;
					String nextPlaceName = nextPlace.getName();
					if (fastRoute.get(0).equals(fastRoute.get(i))) {
						fastString += nextPlaceName + " for "
								+ Math.floor(distance) + " Richardsons.\n\n";
					} else {
						fastString += nextPlaceName + " for "
								+ Math.floor(distance) + " Richardsons\nthen to ";
					}
					
					ArrayList<Point> points = r.getPoints();
					for (Point p : points) {
						this.mapPanel.collectFastPoint(p);
					}
				}
				totalFastDistanceString += Math.floor(totalFastDistance) + " Richardsons\n";
				String totalFastTimeString = "The total time is: " + totalFastTime + " minutes\n\n\n";
				
				String shortString = "Here is the shortest route: " + "\n"
						+ "Travel from " + startPlace + " to ";
				String totalShortDistanceString = "The total distance is: ";
				ArrayList<Connection> shortRoute = this.pdi
						.getShortestRoute(sp, ep);
				double totalShortDistance = 0;
				double totalShortTime = 0;
				for (int i = shortRoute.size() - 1; i > -1; i--) {
					double time = Math.floor(shortRoute.get(i).getTime());
					totalShortTime += time;
					Route r = shortRoute.get(i).getRoute();
					double distance = r.getDistance();
					totalShortDistance += distance;
					Place nextPlace = shortRoute.get(i).getDestination();
					String nextPlaceName = nextPlace.getName();
					if (shortRoute.get(0).equals(shortRoute.get(i))) {
						shortString += nextPlaceName + " for "
								+ Math.floor(distance) + " Richardsons.\n";
					} else {
						shortString += nextPlaceName + " for "
								+ Math.floor(distance) + " Richardsons\nthen to ";
					}
					
					ArrayList<Point> points = r.getPoints();
					for (Point p : points) {
						this.mapPanel.collectShortPoint(p);
					}
				}
				this.mapPanel.bool = true;
				this.mapPanel.revalidate();
				this.mapPanel.repaint();
				totalShortDistanceString += Math.floor(totalShortDistance) + " Richardsons\n";
				String totalShortTimeString = "The total time is: " + totalShortTime + " minutes";
				
				JTextArea directions = new JTextArea(41, 29);
				directions.setLineWrap(true);
				directions.setText(fastString + totalFastDistanceString + totalFastTimeString +
						shortString + "\n" + totalShortDistanceString + totalShortTimeString);
				
				this.panel.add(directions);
			}

		}
	}
}
