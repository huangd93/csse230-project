import java.util.ArrayList;

/**
 * 
 *This will actually create Yggdrasil and waypoints.
 *If we don't need this at the moment, the code will be useful later
 *
 * 
 * @author richarel
 *
 */
public class Creation {
// for reference => Place(String n, ArrayList<Connection> ne, Point p, int r, Realm re)
	public void createAsgard() {
		PlacesTree t = new PlacesTree();
		ArrayList<Connection> valhallaConnect = new ArrayList<Connection>();
		ArrayList<Place> valhallaNeighbors = new ArrayList<Place>();
		Point point = new Point(50, 50); // to be further define for real
		Place valhalla = new Place("Valhalla", valhallaConnect, valhallaNeighbors, point, 9,
				Realm.Asgard);
		t.insert(valhalla);
	}
}
