import static org.junit.Assert.*;

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
		//test size of tree (should equal # of places in our universe)
		assertEquals(41, yggdrasil.t.getPlaces().size());
		// this line is to make sure we get a new ArrayList, and it doesn't just
		// add on top of the old one
		assertEquals(41, yggdrasil.t.getPlaces().size());

	}

	@Test
	public void getFastestRouteTest() {
		// Illegal argument exception
		assertEquals(
				2,
				yggdrasil.t.getFastestRoute(
						yggdrasil.t.getPlace("Valhalla", "Asgard"),
						yggdrasil.t.getPlace("Sea of Marmora", "Asgard"))
						.size());

		assertEquals(
				3,
				yggdrasil.t.getFastestRoute(
						yggdrasil.t.getPlace("Valhalla", "Asgard"),
						yggdrasil.t.getPlace("The Mountain Thrymheim",
								"Jotunheim")).size());

	}

	@Test
	public void getShortestRouteTest() {
		//intra-realm shortest routes
		assertEquals(
				1,
				yggdrasil.t.getShortestRoute(
						yggdrasil.t.getPlace("Valhalla", "Asgard"),
						yggdrasil.t.getPlace("Odin's Fortress", "Asgard"))
						.size());
		
		assertEquals(
				2,
				yggdrasil.t.getShortestRoute(
						yggdrasil.t.getPlace("The River Iving", "Jotunheim"),
						yggdrasil.t.getPlace("The Mountain Thrymheim", "Jotunheim"))
						.size());

		assertEquals(
				2,
				yggdrasil.t.getShortestRoute(
						yggdrasil.t.getPlace("Valhalla", "Asgard"),
						yggdrasil.t.getPlace("Lake Logur", "Asgard")).size());
		
		assertEquals(
				3,
				yggdrasil.t.getShortestRoute(
						yggdrasil.t.getPlace("The Home Of Njord", "Vanaheim"),
						yggdrasil.t.getPlace("The Pictish Wilderness", "Vanaheim"))
						.size());

		assertEquals(
				3,
				yggdrasil.t.getShortestRoute(
						yggdrasil.t.getPlace("Valhalla", "Asgard"),
						yggdrasil.t.getPlace("The Mountain Thrymheim",
								"Jotunheim")).size());

	}

}
