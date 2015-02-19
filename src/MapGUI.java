import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;

public class MapGUI {
	private JFrame mainframe;
	private PlacesDao pdi;

	public MapGUI(JFrame frame, String start, String startRealm, String dest,
			String destRealm) {
		this.pdi = PlacesDaoFactory.getPlacesDaoSingleton();
		JPanel direcsPanel = new JPanel();
		MapPanel mapPanel = new MapPanel();
		// ////////////////////////////////////////////////////////////////////////////////
		// differencess
		Place sp = this.pdi.getPlace(start, startRealm);
		Place ep = this.pdi.getPlace(dest, destRealm);
		String fastString = "";
		fastString += "Here is the fastest route: " + "\n" + "Travel from "
				+ start + " to ";
		ArrayList<Connection> fastRoute = this.pdi.getFastestRoute(sp, ep);
		String totalFastDistanceString = "The total distance is: ";
		double totalFastDistance = 0;
		for (int i = fastRoute.size() - 1; i > -1; i--) {
			Route r = fastRoute.get(i).getRoute();
			Place nextPlace = fastRoute.get(i).getDestination();
			double distance = r.getDistance();
			totalFastDistance += distance;
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
				mapPanel.collectPoint(p);
			}
			mapPanel.bool = true;
			mapPanel.revalidate();
			mapPanel.repaint();
		}
		totalFastDistanceString += Math.floor(totalFastDistance) + " miles\n\n\n";

		String shortString = "Here is the shortest route: " + "\n"
				+ "Travel from " + start + " to ";
		ArrayList<Connection> shortRoute = this.pdi
				.getShortestRoute(sp, ep);
		String totalShortDistanceString = "The total distance is: ";
		double totalShortDistance = 0;
		for (int i = shortRoute.size() - 1; i > -1; i--) {
			Route r = shortRoute.get(i).getRoute();
			double distance = r.getDistance();
			totalShortDistance += distance;
			Place nextPlace = shortRoute.get(i).getDestination();
			String nextPlaceName = nextPlace.getName();
			if (shortRoute.get(0).equals(shortRoute.get(i))) {
				shortString += nextPlaceName + " for "
						+ Math.floor(distance) + " miles.\n";
			} else {
				shortString += nextPlaceName + " for "
						+ Math.floor(distance) + " miles\nthen to ";
			}
		}
		totalShortDistanceString += Math.floor(totalShortDistance) + " miles\n\n";

		JTextArea directions = new JTextArea(41, 29);
		directions.setLineWrap(true);
		directions.setText(fastString + totalFastDistanceString + shortString + "\n" + totalShortDistanceString);
		direcsPanel.add(directions);
		// /////////////////////////////////////////////////////////////////////////////////
		setup(frame, direcsPanel, mapPanel);

	}

	public MapGUI(JFrame frame) {
		JPanel direcsPanel = new JPanel();
		MapPanel mapPanel = new MapPanel();
		setup(frame, direcsPanel, mapPanel);
	}

	public void setup(JFrame frame, JPanel direcsP, MapPanel mapPanel) {
		JPanel direcsPanel = direcsP;
		this.pdi = PlacesDaoFactory.getPlacesDaoSingleton();
		this.mainframe = frame;
		this.mainframe.getContentPane().removeAll();
		this.mainframe.getContentPane().revalidate();
		this.mainframe.setBackground(Color.BLACK);
		this.mainframe.setTitle("Your Adventure");

		JPanel mainPanel = new JPanel();
		MigLayout layout = new MigLayout();
		mainPanel.setLayout(layout);
		mainPanel.setSize(1366, 768);

		JPanel controlPanel = new JPanel();

		JLabel startChoice = new JLabel("Choose your starting point: ");

		ArrayList<Realm> realmsArray = this.pdi.getRealms();

		ArrayList<String> realmsStringArray = new ArrayList<String>();
		realmsStringArray.add("(Choose a Realm)");

		for (int i = 1; i < realmsArray.size() + 1; i++) {
			realmsStringArray.add(i, realmsArray.get(i - 1).toString());
		}
		Object[] realms = realmsStringArray.toArray();
		JComboBox realmList1 = new JComboBox(realms);
		String[] startStrings = { "(Please Choose a Realm)" };
		DefaultComboBoxModel startModel = new DefaultComboBoxModel(startStrings);

		JComboBox startList = new JComboBox();
		startList.setModel(startModel);
		realmList1.addActionListener(new DropDownHandler(null, startList,
				controlPanel));

		JLabel destinationChoice = new JLabel("Choose your destination: ");

		JComboBox realmList2 = new JComboBox(realms);
		JComboBox destinationList = new JComboBox();
		DefaultComboBoxModel destModel = new DefaultComboBoxModel(realms);
		destinationList.setModel(destModel);
		realmList2.addActionListener(new DropDownHandler(null, destinationList,
				controlPanel));

		JButton createButton = new JButton("Create");
		createButton.addActionListener(new ButtonHandler(this.mainframe,
				direcsPanel, mapPanel, null, null, startList, realmList1,
				destinationList, realmList2, null));

		JButton planButton = new JButton("Plan an adventure");
		planButton.addActionListener(new ButtonHandler(this.mainframe,
				mainPanel, null, null, null, null, null, null, null, null));
		controlPanel.add(startChoice);
		controlPanel.add(realmList1);
		controlPanel.add(startList);
		controlPanel.add(destinationChoice);
		controlPanel.add(realmList2);
		controlPanel.add(destinationList);
		controlPanel.add(createButton);
		controlPanel.add(new JLabel("      or      "));
		controlPanel.add(planButton);
		controlPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
				Color.gray));

		direcsPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
				Color.gray));

		mainPanel.add(controlPanel, "dock north, h 55!, w 1354!");
		mainPanel.add(direcsPanel, "cell 0 1, h 670!, w 350!");
		mainPanel.add(mapPanel, "cell 1 1, h 670!, w 1000!");

		this.mainframe.add(mainPanel);
	}
}
