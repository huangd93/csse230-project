import java.util.ArrayList;


public interface PlacesDaoInterface {
	
	/**
	 * Returns an ArrayList of all places in the Dao
	 * @return
	 */
	public ArrayList<Place> getPlaces();
	
	/**
	 * Finds what realm the input place belongs in
	 * @param place
	 * @return Realm 
	 */
	public Realm findPlace(Place place);
	
	
}
