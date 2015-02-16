import java.util.ArrayList;


public class PlacesHashMap {
	private PlacesList[] placesArray;
	private double loadFactor;
	private int size;
	
	/**
	 * Creates a PlacesHashMap with size 16 and loadFactor of 0.75
	 */
	public PlacesHashMap() {
		placesArray = new PlacesList[16];
		loadFactor = 0.75;
	}
	
	/**
	 * Inserts the given place into the PlacesHashMap using its name as a key
	 * @param p
	 * @return
	 */
	public boolean insert(Place p) {
		size++;
		if(size / placesArray.length > loadFactor) rebalance();
		int hash = hash(p.getName(), placesArray.length);
		if(placesArray[hash] == null) placesArray[hash] = new PlacesList();
		placesArray[hash].insert(p);
		return true;
	}
	
	/**
	 * Creates a hash for the given string modulated by the array length given to it
	 * @param s String to hash
	 * @param length Length of array to be inserted into
	 * @return Index to insert into the array
	 */
	public int hash(String s, int length) {
		return s.hashCode() % length;
	}
	
	/**
	 * Doubles the size of the array and reinserts all existing elements into it
	 */
	private void rebalance() {
		PlacesList[] temp = new PlacesList[placesArray.length * 2];
		for(PlacesList i : placesArray) {
			if(i != null) {
				for(Place p : i.getPlaces()) {
					int hash = hash(p.getName(), temp.length);
					if(temp[hash] == null) temp[hash] = new PlacesList();
					temp[hash].insert(p);
				}
			}
		}
		placesArray = temp;
	}
	
	public ArrayList<Place> toArrayList() {
		ArrayList<Place> result = new ArrayList<Place>();
		for(PlacesList i : placesArray) {
			if(i != null) {
				for(Place p : i.getPlaces()) {
					result.add(p);
				}
			}
		}
		return result;
	}
	
	/**
	 * Contains a LinkedList of Places. Used for repeated hashes in the HashMap. Has a max size before asking for a rebalance.
	 * @author huangd
	 *
	 */
	private class PlacesList {
		private LinkedList<Place> places;
		private int size;
		private int maxSize;
		
		/**
		 * Creates a LinkedList of Places with a max length of 8
		 */
		public PlacesList() {
			places = new LinkedList<Place>();
			size = 0;
			maxSize = 8;
		}
		
		public void insert(Place p) {
			places.insert(p);
			size++;
			if(size > maxSize) {
				if(!sameName()) rebalance();
			}
		}
		
		public boolean sameName() {
			String name = places.root.getElement().getName();
			for(Place p : places) {
				if(!name.equals(p.getName())) return false;
			}
			return true;
		}
		
		public int getSize() {
			return size;
		}
		
		public LinkedList<Place> getPlaces() {
			return places;
		}
	}
}
