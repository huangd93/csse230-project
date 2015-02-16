
public class PlacesHashMap {
	private PlacesList[] placesArray;
	private double loadFactor;
	private int size;
	
	public PlacesHashMap() {
		placesArray = new PlacesList[128];
		loadFactor = 0.75;
	}
	
	public boolean insert(Place p) {
		size++;
		if(size / placesArray.length > loadFactor) rebalance();
		int hash = hash(p.getName(), placesArray.length);
		if(placesArray[hash] == null) placesArray[hash] = new PlacesList();
		placesArray[hash].insert(p);
		return true;
	}
	
	public int hash(String s, int length) {
		return s.hashCode() % length;
	}
	
	private void rebalance() {
		PlacesList[] temp = new PlacesList[placesArray.length * 2];
		for(PlacesList i : placesArray) {
			for(Place p : i.getPlaces()) {
				int hash = hash(p.getName(), temp.length);
				if(temp[hash] == null) temp[hash] = new PlacesList();
				temp[hash].insert(p);
			}
		}
		placesArray = temp;
	}
	
	private class PlacesList {
		private LinkedList<Place> places;
		private int size;
		// private int maxSize;
		
		public PlacesList() {
			places = new LinkedList<Place>();
			size = 0;
		}
		
		public void insert(Place p) {
			places.insert(p);
			size++;
			// TODO: Should I put a max length?
		}
		
		public int getSize() {
			return size;
		}
		
		public LinkedList<Place> getPlaces() {
			return places;
		}
	}
}
