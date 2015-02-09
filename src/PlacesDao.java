import java.util.ArrayList;


public class PlacesDao implements PlacesDaoInterface {
	
	protected PlacesDao() {
		
	}

	public ArrayList<Place> getPlaces() {
		// TODO Auto-generated method stub
		return null;
	}

	public Realm findPlace(Place place) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Route> getFastestRoute(Place place1, Place place2) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Route> getShortestRoute(Place place1, Place place2) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insert(Place place) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean insert(Place place, String name, ArrayList<Place> neighbors,
			Route route, ArrayList<Connection> connections, Point point,
			Integer rating, Realm realm) {
		PlacesTree t = new PlacesTree();
		Place newPlace = new Place(name, connections, point, rating, realm);
		t.insert(newPlace);
		return false;
	}

}
