import java.util.ArrayList;
import java.util.Iterator;

/**
 * Hashmap of places. Has a default load factor of 0.75 and initial size of 16
 * Stores duplicate hashes in a LinkedList in the bucket. If any LinkedList gets too deep
 * and the items have different names, it will also expand the Hashmap and rebalance it.
 * @author huangd
 *
 */
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
	 * Returns true if this PlacesHashMap has an item with the input name
	 * @param name Name to check for
	 * @return True if contains that name
	 */
	public boolean containsName(String name) {
		int hash = hash(name, placesArray.length);
		if(placesArray[hash] != null && placesArray[hash].containsName(name)) return true;
		return false;
	}
	
	/**
	 * Returns true if this PlacesHashMap has the input place
	 * @param place Place to check for
	 * @return True if contains that Place
	 */
	public boolean contains(Place place) {
		if(getPlace(place.getName(), place.getRealm().toString()) != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the Place asked for.
	 * @param name Name of place to retrieve
	 * @param realm Name of realm the place is located
	 * @return Place or null if invalid
	 */
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
		return Math.abs(s.hashCode() % length);
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
	
	/**
	 * Returns an ArrayList<Place> containing all the points in this PlacesHashMap
	 * In bucket order then insertion order within each bucket.
	 * @return
	 */
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
	 * Prints every item in this PlacesHashMap
	 * In bucket order then insertion order within each bucket.
	 */
	protected void print() {
		for(int i = 0; i < placesArray.length; i++) {
			System.out.print(i + ": ");
			if(placesArray[i] == null){
				System.out.println("null");
			} else {
				String list = "";
				Iterator<Place> t = placesArray[i].iterator();
				while(t.hasNext()) {
					list += t.next().getName();
				}
				System.out.println(list);
			}
		}
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
		
		/**
		 * Returns true if this LinkedList contains a Place with the given name
		 * @param name Name to check for
		 * @return True if name is found
		 */
		public boolean containsName(String name) {
			Iterator<Place> t = iterator();
			while(t.hasNext()) {
				if(t.next().getName().equals(name)) return true;
			}
			return false;
		}
		
		/**
		 * Checks if all the Places in the LinkedList have the same name
		 * Used to prevent useless rebalancing of the HashMap if there 
		 * wll be the same number of items in this bucket anyway
		 * @return
		 */
		private boolean sameName() {
			String name = places.root.getElement().getName();
			for(Place p : places) {
				if(!name.equals(p.getName())) return false;
			}
			return true;
		}
		
		/**
		 * Returns the LinkedList with all the places
		 * @return
		 */
		public LinkedList<Place> getPlaces() {
			return places;
		}

		/**
		 * Returns an iterator through the underlying LinkedList
		 */
		public Iterator<Place> iterator() {
			return places.iterator();
		}
	}
}
