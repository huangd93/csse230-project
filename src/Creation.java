import java.util.ArrayList;

import org.junit.Test;

/**
 * 
 * This will actually create Yggdrasil and waypoints. If we don't need this at
 * the moment, the code will be useful later
 * 
 * 
 * @author richarel
 * 
 */
public class Creation {

	@Test
	public void createAsgard() {
		PlacesTree t = new PlacesTree();

		ArrayList<Connection> valhallaConnect = new ArrayList<Connection>();
		ArrayList<Place> valhallaNeighbors = new ArrayList<Place>();
		Point valhallaPoint = new Point(50, 40); // to be further define Points
													// for
													// real position
		ArrayList<Connection> odinConnect = new ArrayList<Connection>();
		ArrayList<Place> odinNeighbors = new ArrayList<Place>();
		Point odinPoint = new Point(55, 50);

		ArrayList<Connection> mntnConnect = new ArrayList<Connection>();
		ArrayList<Place> mntnNeighbors = new ArrayList<Place>();
		Point mntnPoint = new Point(30, 30);

		ArrayList<Connection> lakeConnect = new ArrayList<Connection>();
		ArrayList<Place> lakeNeighbors = new ArrayList<Place>();
		Point lakePoint = new Point(30, 20);

		ArrayList<Connection> seaConnect = new ArrayList<Connection>();
		ArrayList<Place> seaNeighbors = new ArrayList<Place>();
		Point seaPoint = new Point(30, 20);

		Place valhalla = new Place("Valhalla", valhallaConnect,
				valhallaNeighbors, valhallaPoint, 9, Realm.Asgard);

		Place odinsFortress = new Place("Odin's Fortress", odinConnect,
				odinNeighbors, odinPoint, 8, Realm.Asgard);

		Place asgardMnts = new Place("Asgard Mountains", mntnConnect,
				mntnNeighbors, mntnPoint, 5, Realm.Asgard);

		Place lakeLogur = new Place("Lake Logur", lakeConnect, lakeNeighbors,
				lakePoint, 5, Realm.Asgard);

		Place seaOfMarmora = new Place("Sea of Marmora", seaConnect,
				seaNeighbors, seaPoint, 4, Realm.Asgard);

		t.insert(valhalla);
		t.insert(odinsFortress);
		t.insert(asgardMnts);
		t.insert(lakeLogur);
		t.insert(seaOfMarmora);

		valhallaNeighbors.add(odinsFortress);
		valhallaNeighbors.add(asgardMnts);
		valhalla.setNeighbors(valhallaNeighbors);

		odinNeighbors.add(valhalla);
		odinNeighbors.add(asgardMnts);
		odinNeighbors.add(seaOfMarmora);
		odinsFortress.setNeighbors(odinNeighbors);

		mntnNeighbors.add(lakeLogur);
		mntnNeighbors.add(valhalla);
		mntnNeighbors.add(odinsFortress);
		mntnNeighbors.add(seaOfMarmora);
		asgardMnts.setNeighbors(mntnNeighbors);

		lakeNeighbors.add(asgardMnts);
		lakeLogur.setNeighbors(lakeNeighbors);
		
		seaNeighbors.add(odinsFortress);
		seaNeighbors.add(asgardMnts);
		seaOfMarmora.setNeighbors(seaNeighbors);
		
	}
}
