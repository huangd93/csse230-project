import java.util.ArrayList;

public interface PlacesDaoInterface {

	/**
	 * Returns an ArrayList of all places in the Dao
	 * 
	 * @return
	 */
	public ArrayList<Place> getPlaces();
	
	/**
	 * Returns the place with the specified name and realm
	 * @param name
	 * @param realm
	 * @return
	 */
	public Place getPlace(String name, String realm);

	/**
	 * Finds what realm the input place belongs in
	 * 
	 * @param place
	 * @return Realm
	 */
	public Realm findPlace(Place place);
	
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
	 * Inserts the given place into the tree
	 * 
	 * @param place
	 * @return
	 */
	public boolean insertIntoRatingTree(Place place);

}