import static org.junit.Assert.*;

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
		Place place = new Place(null, null, null, 0, null);
		p.insertIntoRatingTree(place);
	}
}