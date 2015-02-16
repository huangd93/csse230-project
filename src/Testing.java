import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;


public class Testing {
	
	@Test
	public void testSingleton() {
		PlacesDaoInterface p = PlacesDaoFactory.getPlacesDaoSingleton();
		PlacesDaoInterface i = PlacesDaoFactory.getPlacesDaoSingleton();
		assertEquals(p, i);
	}
	
	@Test
	public void testInsertGet() {
		PlacesDaoInterface p = PlacesDaoFactory.getPlacesDaoSingleton();
		ArrayList<Connection> place1C = new ArrayList<Connection>(); 
		Place place = new Place("Place1", place1C, new Point(10, 10), 5, Realm.Asgard);
		p.insert(place);
	}
	
	@Test
	public void testStuff() {
		
	}
}