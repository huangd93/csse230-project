import java.util.ArrayList;
import java.util.Iterator;


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
	
	public boolean containsName(String name) {
		int hash = hash(name, placesArray.length);
		if(placesArray[hash] != null && placesArray[hash].containsName(name)) return true;
		return false;
	}
	
	public Place getPlace(String name, String realm) {
		if(!containsName(name)) return null;
		int hash = hash(name, placesArray.length);
		return placesArray[hash].getPlace(name, realm);
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
	private class PlacesList implements Iterable<Place> {
		private LinkedList<Place> places;
		private int size;
		private int maxSize;
		
		/**
		 * Creates a LinkedList of Places with a max length of 8 before considering rebalancing.
		 */
		public PlacesList() {
			places = new LinkedList<Place>();
			size = 0;
			maxSize = 8;
		}
		
		/**
		 * Returns the place with the given name and realm
		 * @param name
		 * @param realm
		 * @return
		 */
		public Place getPlace(String name, String realm) {
			Iterator<Place> t = iterator();
			while(t.hasNext()) {
				Place n = t.next();
				if(n.getName().equals(name) && n.getRealm().toString().equals(realm)) return n;
			}
			return null;
		}

		/**
		 * Insert the given place into places
		 * @param p
		 */
		public void insert(Place p) {
			places.insert(p);
			size++;
			if(size > maxSize) {
				if(size > maxSize + 1) {
					if(p.getName().equals(places.root.getElement().getName())) rebalance();
				} else {
					if(!sameName()) rebalance();
				}
			}
		}
		
		public boolean containsName(String name) {
			Iterator<Place> t = iterator();
			while(t.hasNext()) {
				if(t.next().getName().equals(name)) return true;
			}
			return false;
		}
		
		private boolean sameName() {
			String name = places.root.getElement().getName();
			for(Place p : places) {
				if(!name.equals(p.getName())) return false;
			}
			return true;
		}
		
		public LinkedList<Place> getPlaces() {
			return places;
		}

		public Iterator<Place> iterator() {
			return places.iterator();
		}
	}
}
