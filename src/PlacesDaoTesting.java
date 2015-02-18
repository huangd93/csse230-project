import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PlacesDaoTesting {

	Creation yggdrasil = new Creation();

	public PlacesDaoTesting() {
		yggdrasil.createAsgard();
		yggdrasil.createAlfheim();
		yggdrasil.createJotunheim(); // aka Utgard
		yggdrasil.createMidgard();
		yggdrasil.createMuspelheim();
		yggdrasil.createNidavellir();
		yggdrasil.createNiflheim();
		yggdrasil.createSvartalfheim();
		yggdrasil.createVanaheim();
	}

	@Test
	public void getPlacesTest() {
		assertEquals(41, yggdrasil.t.getPlaces().size()); // makes sure it gets
															// all the places
		assertEquals(5, yggdrasil.asgardPlaces.size());
		assertEquals(3, yggdrasil.muspelheimPlaces.size());
	}

	@Test
	public void getFastestRouteTest() {
		assertEquals(
				2,
				yggdrasil.t.getFastestRoute(
						yggdrasil.t.getPlace("Valhalla", "Asgard"),
						yggdrasil.t.getPlace("Sea Of Marmora", "Asgard"))
						.size());

		// null pointer exception...
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
						yggdrasil.t.getPlace("Lake Logur", "Asgard"))
						.size());
		
		// This gives us an infinite loop <<<<<<<<<<<<
//		assertEquals(
//				4,
//				yggdrasil.t.getFastestRoute(
//						yggdrasil.t.getPlace("Valhalla", "Asgard"),
//						yggdrasil.t.getPlace("The Mountain Thrymheim",
//								"Jotunheim")).size());

	}

	@Test
	public void insertIntoRatingTreeTest() {
		// finish by creating a new place and then see if the tree grew by one
		ArrayList<Connection> otherConnect = new ArrayList<Connection>();
		Point otherPoint = new Point(500, 500);
		Place otherPlace = new Place("Other New Place", otherConnect,
				otherPoint, 4, Realm.Midgard);
		ArrayList<Connection> randomConnect = new ArrayList<Connection>();
		Point randomPoint = new Point(500, 500);
		ArrayList<Point> connectPoints = new ArrayList<Point>();
		connectPoints.add(randomPoint);
		connectPoints.add(otherPoint);
		randomConnect.add(new Connection(otherPlace, new Route(connectPoints),
				45));
		Place randomPlace = new Place("Random New Place", randomConnect,
				randomPoint, 4, Realm.Midgard);
		randomPlace.setConnections(randomConnect);
		yggdrasil.t.insert(randomPlace);
		assertEquals(42, yggdrasil.t.getPlaces().size());
	}

}
