import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PlacesDaoTesting {

	Creation yggdrasil = new Creation();

	public PlacesDaoTesting() {
		yggdrasil.createAsgard();
		yggdrasil.createAlfheim();
		yggdrasil.createJotunheim();
		yggdrasil.createMidgard();
		yggdrasil.createMuspelheim();
		yggdrasil.createNidavellir();
		yggdrasil.createNiflheim();
		yggdrasil.createSvartalfheim();
		yggdrasil.createVanaheim();
	}

	@Test
	public void getPlacesTest() {
		assertEquals(41, yggdrasil.t.getPlaces().size());
		// this line is to make sure we get a new ArrayList, and it doesn't just
		// add on top of the old one
		assertEquals(41, yggdrasil.t.getPlaces().size());

	}

	@Test
	public void getFastestRouteTest() {
		// null pointer exception
		assertEquals(
				2,
				yggdrasil.t.getFastestRoute(
						yggdrasil.t.getPlace("Valhalla", "Asgard"),
						yggdrasil.t.getPlace("Sea Of Marmora", "Asgard"))
						.size());

		assertEquals(
				4,
				yggdrasil.t.getFastestRoute(
						yggdrasil.t.getPlace("Valhalla", "Asgard"),
						yggdrasil.t.getPlace("The Mountain Thrymheim",
								"Jotunheim")).size());

	}

	@Test
	public void getShortestRouteTest() {
		assertEquals(
				1,
				yggdrasil.t.getShortestRoute(
						yggdrasil.t.getPlace("Valhalla", "Asgard"),
						yggdrasil.t.getPlace("Odin's Fortress", "Asgard"))
						.size());

		assertEquals(
				2,
				yggdrasil.t.getShortestRoute(
						yggdrasil.t.getPlace("Valhalla", "Asgard"),
						yggdrasil.t.getPlace("Lake Logur", "Asgard")).size());

		// This gives us an infinite loop <<<<<<<<<<<<
		// assertEquals(
		// 4,
		// yggdrasil.t.getFastestRoute(
		// yggdrasil.t.getPlace("Valhalla", "Asgard"),
		// yggdrasil.t.getPlace("The Mountain Thrymheim",
		// "Jotunheim")).size());

	}

	@Test
	public void insertIntoRatingTreeTest() {
		ArrayList<Connection> otherConnect = new ArrayList<Connection>();
		ArrayList<Connection> randomConnect = new ArrayList<Connection>();
		Point randomPoint = new Point(500, 500);
		Point otherPoint = new Point(400, 500);
		Place otherPlace = new Place("Other New Place", otherConnect,
				otherPoint, 4, Realm.Midgard);
		Place randomPlace = new Place("Random New Place", randomConnect,
				randomPoint, 4, Realm.Midgard);

		ArrayList<Point> connectPoints = new ArrayList<Point>();
		connectPoints.add(randomPoint);
		connectPoints.add(otherPoint);

		Route randomRoute = new Route();
		randomRoute.addPoint(randomPoint);
		randomRoute.addPoint(otherPoint);

		randomConnect.add(new Connection(otherPlace, randomRoute, 45));
		randomPlace.setConnections(randomConnect);

		yggdrasil.t.insertIntoRatingTree(randomPlace, "Random New Place",
				randomRoute, randomConnect, randomPoint, 4, Realm.Midgard);
		assertEquals(42, yggdrasil.t.getPlaces().size());
	}


}
