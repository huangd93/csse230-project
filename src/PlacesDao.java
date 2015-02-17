import java.util.ArrayList;

public class PlacesDao implements PlacesDaoInterface {
	// Places grouped by rating
	private PlacesHashMap[] places = new PlacesHashMap[10];

	protected PlacesDao() {}

	public ArrayList<Place> getPlaces() {
		ArrayList<Place> result = new ArrayList<Place>();
		for(PlacesHashMap i : places) {
			if(i != null) result.addAll(i.toArrayList());
		}
		return result;
	}
	
	public ArrayList<Connection> getFastestRoute(Place place1, Place place2) {
		PriorityQueue<RouteNode> openList = new PriorityQueue<RouteNode>();
		LinkedList<RouteNode> closedList = new LinkedList<RouteNode>();
		
		openList.add(new RouteNode(null, null, place1, 0, Place.estimatedDistance(place1, place2)));
		RouteNode current = null;
		while(!openList.isEmpty()) {
			current = openList.poll();
			if(current.place.equals(place2)) {
				break;
			}
			closedList.insert(current);
			for(Connection i : current.place.getConnections()) {
				// The time heuristic used is simply the shortest connection available to the next Place.
				RouteNode next = new RouteNode(current, i, i.getDestination(), current.g + i.getDistance(), 
						i.getDestination().getShortestTime());
				if(!closedList.contains(next)) openList.add(next);
			}
		}
		ArrayList<Connection> construct = new ArrayList<Connection>();
		while(current.arrivalConnection != null) {
			construct.add(current.arrivalConnection);
			current = current.cameFrom;
		}
		ArrayList<Connection> result= new ArrayList<Connection>();
		for(int i = 0; i < construct.size(); i++) {
			result.add(construct.get(i));
		}
		return result;
	}

	public ArrayList<Connection> getShortestRoute(Place place1, Place place2) {
		PriorityQueue<RouteNode> openList = new PriorityQueue<RouteNode>();
		LinkedList<RouteNode> closedList = new LinkedList<RouteNode>();
		
		openList.add(new RouteNode(null, null, place1, 0, Place.estimatedDistance(place1, place2)));
		RouteNode current = null;
		while(!openList.isEmpty()) {
			current = openList.poll();
			if(current.place.equals(place2)) {
				break;
			}
			closedList.insert(current);
			for(Connection i : current.place.getConnections()) {
				RouteNode next = new RouteNode(current, i, i.getDestination(), current.g + i.getDistance(), 
						Place.estimatedDistance(i.getDestination(), place2));
				if(!closedList.contains(next)) openList.add(next);
			}
		}
		ArrayList<Connection> construct = new ArrayList<Connection>();
		while(current.arrivalConnection != null) {
			construct.add(current.arrivalConnection);
			current = current.cameFrom;
		}
		ArrayList<Connection> result= new ArrayList<Connection>();
		for(int i = 0; i < construct.size(); i++) {
			result.add(construct.get(i));
		}
		return result;
	}

	public boolean insertIntoRatingTree(Place place, String name, Route route,
			ArrayList<Connection> connections, Point point, Integer rating,
			Realm realm) {
		PlacesTree t = new PlacesTree();
		Place newPlace = new Place(name, connections, point, rating, realm);
		t.insert(newPlace);
		
		return false;
	}
	
	/**
	 * A Node used for Routing purposes
	 * @author huangd
	 *
	 */
	private class RouteNode implements Comparable<RouteNode>{
		private RouteNode cameFrom;
		private Connection arrivalConnection;
		private Place place;
		private double g;
		private double f;
		
		/**
		 * Construct a RouteNode with the specified place and cost values
		 * @param cf The RouteNode that we came from
		 * @param ac The Connection we came from
		 * @param p Place
		 * @param g Cost from start
		 * @param h Estimated cost to end
		 */
		public RouteNode(RouteNode cf, Connection ac, Place p, double g, double h) {
			cameFrom = cf;
			arrivalConnection = ac;
			place = p;
			this.g = g;
			f = g + h;
		}
		
		/**
		 * Returns the place of this RouteNode
		 * @return
		 */
		public Place getPlace() {
			return place;
		}

		/**
		 * Returns true if this RouteNode has the same Place as the given RouteNode
		 * @param o RouteNode to compare to
		 * @return
		 */
		public boolean equals(RouteNode o) {
			if(place.equals(o.getPlace())) return true;
			return false;
		}
		
		/**
		 * Compares the cost function of this RouteNode to that of the given RouteNode
		 * @return -1 if this is less than arg0, 0 if equal, and 1 if this is greater than arg0
		 */
		public int compareTo(RouteNode arg0) {
			if(f < arg0.f) {
				return -1;
			} else if(f > arg0.f) {
				return 1;
			}
			return 0;
		}
		
	}

	public boolean insert(Place place) {
		int rating = place.getRating();
		if(places[rating-1] == null) places[rating-1] = new PlacesHashMap();
		return places[rating-1].insert(place);
	}

	public ArrayList<Place> getPlacesWithin(Place start, double distance,
			double time) {
		return start.getPlacesWithin(distance, time, 0, 0);
	}
	
	public ArrayList<Place> getPlacesWithin(String name, String realm, double distance, double time) {
		return getPlacesWithin(getPlace(name, realm), distance, time);
	}

	public Place getPlace(String name, String realm) {
		Place result = null;
		for(PlacesHashMap i : places) {
			if(i != null && i.containsName(name)) {
				result = i.getPlace(name, realm);
				if(result != null) return result;
			}
		}
		return null;
	}

	public ArrayList<Realm> getRealms() {
		return Realm.toArrayList();
	}

	public ArrayList<Place> getPlacesInRealm(Realm realm) {
		ArrayList<Place> result = new ArrayList<Place>();
		for(PlacesHashMap i : places) {
			if(i != null) {
				for(Place j : i.toArrayList()) {
					if(j.getRealm() == realm) result.add(j);
				}
			}
		}
		return result;
	}
}
