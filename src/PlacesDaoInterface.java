import java.util.ArrayList;

public interface PlacesDaoInterface {

	/**
	 * Returns an ArrayList of all places in the Dao
	 * 
	 * @return
	 */
	public ArrayList<Place> getPlaces();
	
	/**
	 * Returns an ArrayList of all Realms
	 * @return
	 */
	public ArrayList<Realm> getRealms();
	
	/**
	 * Returns an ArrayList of all Places within the realm given
	 * @param realm
	 * @return
	 */
	public ArrayList<Place> getPlacesInRealm(Realm realm);
	
	/**
	 * Returns the place with the specified name and realm
	 * @param name
	 * @param realm
	 * @return
	 */
	public Place getPlace(String name, String realm);
	
	/**
	 * Returns an ArrayList of Places that connect to the starting point with
	 * a distance less than the input distance and a time less than the input time
	 * @param start The starting point
	 * @param distance The maximum distance to travel
	 * @param time The maximum time to travel
	 * @return
	 */
	public ArrayList<Place> getPlacesWithin(Place start, double distance, double time);
	
	/**
	 * Returns an ArrayList of Places that connect to the starting point with
	 * a distance less than the input distance and a time less than the input time. 
	 * Looks up the starting Place by name and realm
	 * @param name Name of starting Place
	 * @param realm Realm of starting Place
	 * @param distance Max Distance to travel
	 * @param time Max Time to travel
	 * @return
	 */
	public ArrayList<Place> getPlacesWithin(String name, String realm, double distance, double time);

	/**
	 * Returns the fastest set of Routes going from place1 to place2
	 * 
	 * @param place1
	 * @param place2
	 * @return
	 */
	public ArrayList<Connection> getFastestRoute(Place place1, Place place2);

	/**
	 * Returns the shortest set of Routes going from place1 to place2
	 * 
	 * @param place1
	 * @param place2
	 * @return
	 */
	public ArrayList<Connection> getShortestRoute(Place place1, Place place2);

	/**
	 * Inserts the given place into the Dao
	 * @param place
	 * @return
	 */
	public boolean insert(Place place);
	
	/**
	 * Inserts into existing rating tree.
	 * @param place
	 * @return
	 */
	public boolean insertIntoRatingTree(Place place, String name, Route route,
			ArrayList<Connection> connections, Point point, Integer rating,
			Realm realm);
	

}
