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
			double d;
			double t;
			if (dist == null || time == null) {
				// handle this exception
				d = 0;
				t = 0;
			} else {
				d = Double.parseDouble(dist);
				t = Double.parseDouble(time);
			}

			Place p = this.pdi.getPlace(place, realm);

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
			JButton get = new JButton("Get Your Directions");
			get.addActionListener(new ButtonHandler(this.mainframe, this.panel, this.mapPanel,
					null, null, this.startPlaceCombo, this.startRealmCombo,
					null, null, group));
			this.panel.add(get);
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

			String fastString = "";
			fastString += "Here is the fastest route: " + "\n" + "Travel from "
					+ startPlace + " to ";
			ArrayList<Connection> fastRoute = this.pdi.getFastestRoute(sp, ep);
			for (int i = fastRoute.size() - 1; i > -1; i--) {
				Route r = fastRoute.get(i).getRoute();
				Place nextPlace = fastRoute.get(i).getDestination();
				double distance = r.getDistance();
				String nextPlaceName = nextPlace.getName();
				if (fastRoute.get(0).equals(fastRoute.get(i))) {
					fastString += nextPlaceName + " for "
							+ Math.floor(distance) + " miles.\n\n";
				} else {
					fastString += nextPlaceName + " for "
							+ Math.floor(distance) + " miles\nthen to ";
				}
				ArrayList<Point> points = r.getPoints();
				for (Point p : points) {
					int x = p.getXValue();
					int y = p.getYValue();
					
				}
			}

			String shortString = "Here is the shortest route: " + "\n"
					+ "Travel from " + startPlace + " to ";
			ArrayList<Connection> shortRoute = this.pdi
					.getShortestRoute(sp, ep);
			for (int i = shortRoute.size() - 1; i > -1; i--) {
				Route r = shortRoute.get(i).getRoute();
				double distance = r.getDistance();
				Place nextPlace = shortRoute.get(i).getDestination();
				String nextPlaceName = nextPlace.getName();
				if (shortRoute.get(0).equals(shortRoute.get(i))) {
					shortString += nextPlaceName + " for "
							+ Math.floor(distance) + " miles.\n";
				} else {
					shortString += nextPlaceName + " for "
							+ Math.floor(distance) + " miles\nthen to ";
				}
				ArrayList<Point> points = r.getPoints();
				for (Point p : points) {
					double x = p.getXValue();
					double y = p.getYValue();
					this.mapPanel.drawPointsandLines(x, y);
					this.mapPanel.repaint();
					this.mapPanel.revalidate();
				}
			}

			JTextArea directions = new JTextArea(41, 29);
			directions.setLineWrap(true);
			directions.setText(fastString + shortString);

			this.panel.add(directions);
		}
	}
}
