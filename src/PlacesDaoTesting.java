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
//		assertEquals(
//				4,
//				yggdrasil.t.getFastestRoute(
//						yggdrasil.t.getPlace("Valhalla", "Asgard"),
//						yggdrasil.t.getPlace("The Mountain Thrymheim",
//								"Jotunheim")).size());

	}

	@Test
	public void getShortestRouteTest() {
		assertEquals(
				1,
				yggdrasil.t.getShortestRoute(
						yggdrasil.t.getPlace("Valhalla", "Asgard"),
						yggdrasil.t.getPlace("Odin's Fortress", "Asgard"))
						.size());
//		assertEquals(
//				4,
//				yggdrasil.t.getFastestRoute(
//						yggdrasil.t.getPlace("Valhalla", "Asgard"),
//						yggdrasil.t.getPlace("The Mountain Thrymheim",
//								"Jotunheim")).size());

	}

	@Test
	public void insertIntoRatingTreeTest() {

	}

}
