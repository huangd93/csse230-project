import java.util.ArrayList;

public interface PlacesDaoInterface {

	/**
	 * Returns an ArrayList of all places in the Dao
	 * 
	 * @return
	 */
	public ArrayList<Place> getPlaces();

	/**
	 * Finds what realm the input place belongs in
	 * 
	 * @param place
	 * @return Realm
	 */
	public Realm findPlace(Place place);

	/**
	 * Returns the fastest set of Routes going from place1 to place2
	 * 
	 * @param place1
	 * @param place2
	 * @return
	 */
	public ArrayList<Route> getFastestRoute(Place place1, Place place2);

	/**
	 * Returns the shortest set of Routes going from place1 to place2
	 * 
	 * @param place1
	 * @param place2
	 * @return
	 */
	public ArrayList<Route> getShortestRoute(Place place1, Place place2);

	/**
	 * Inserts the given place into the map
	 * 
	 * @param place
	 * @return
	 */
	public boolean insertIntoRatingTree(Place place, String name, ArrayList<Place> neighbors,
			Route route, ArrayList<Connection> connections, Point point,
			Integer rating, Realm realm); 

}