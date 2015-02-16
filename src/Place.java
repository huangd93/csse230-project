import java.util.ArrayList;


public class Place {
	private String name;
	private ArrayList<Connection> connections;
	private Point point;
	private Integer rating;
	private Realm realm;
	
	//the next two are only used within the PlacesTree
	public Place leftChild = null;
	public Place rightChild = null;
	public Place(String n, ArrayList<Connection> con, Point p, int r, Realm re) {
		this.setName(n);
		this.setConnections(con);
		this.setPoint(p);
		this.setRating(r);
		this.setRealm(re);
	}
	
	/**
	 * Returns the most direct distance between 
	 * @param x
	 * @param y
	 * @return
	 */
	public static double estimatedDistance(Place x, Place y) {
		double result = 0;
//		if(x.getRealm() != y.getRealm()) {
//			// TODO: Add in finding realm gate stuff for a better heuristic
//		}
		result += Point.distanceBetween(x.getPoint(), y.getPoint());
		return result;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String newName){
		this.name = newName;
	}
	
	public ArrayList<Connection> getConnections(){
		return this.connections;
	}
	
	public void setConnections(ArrayList<Connection> newConnections){
		this.connections = newConnections;
	}
	
	public Point getPoint(){
		return this.point;
	}
	
	public void setPoint(Point newPoint){
		this.point = newPoint;
	}
	
	public Integer getRating(){
		return this.rating;
	}
	
	public void setRating(Integer newRating){
		this.rating = newRating;
	}
	
	public Realm getRealm(){
		return this.realm;
	}
	
	public void setRealm(Realm newRealm){
		this.realm = newRealm;
	}
	
	/**
	 * Returns true if the name of the place is the same as this name and it's in the same realm.
	 * @param o
	 * @return
	 */
	public boolean equals(Place o) {
		if(name.equals(o.getName()) && realm == o.getRealm()) return true;
		return false;
	}
	
	/**
	 * Returns the time cost of the shortest connection from this Place
	 * @return -1 if there are no connections, or the shortest time to another Place
	 */
	public double getShortestTime() {
		if(connections == null || connections.size() == 0) return -1;
		double shortest = connections.get(0).getTime();
		for(Connection o : connections) {
			if(o.getTime() < shortest) {
				shortest = o.getTime();
			}
		}
		return shortest;
	}
	
	public ArrayList<Place> getPlacesWithin(double distance, double time, 
			double distanceTraveled, double timeUsed) {
		ArrayList<Place> result = new ArrayList<Place>();
		for(Connection i : connections) {
			double connectionDistance = i.getDistance() + distanceTraveled; 
			double connectionTime = i.getTime() + timeUsed;
			if(connectionDistance < distance && connectionTime < time) {
				result.add(i.getDestination());
				result.addAll(i.getDestination().getPlacesWithin(distance, time, connectionDistance, connectionTime));
			}
		}
		return result;
	}
}
