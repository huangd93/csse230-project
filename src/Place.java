import java.util.ArrayList;

/**
 * Place is an object intended for storing primary locations. It stores its own name, coordinates, rating, realm, and
 * an ArrayList of Connections to its neighbors. 
 * @author huangd
 *
 */
public class Place {
	private String name;
	private ArrayList<Connection> connections;
	private Point point;
	private Integer rating;
	private Realm realm;
	
	/**
	 * Creates a place with these set parameters
	 * @param n Name
	 * @param con ArrayList of Connections to neighboring Places
	 * @param p Point that this Place is located at
	 * @param r Rating
	 * @param re Realm
	 */
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
	public static double estimatedDistance(Place x, Place y) throws IllegalArgumentException {
		if(x == null || y == null) throw new IllegalArgumentException();
		double result = 0;
//		if(x.getRealm() != y.getRealm()) {
//			Place gate1 = x.getRealm().getGate();
//			Place gate2 = y.getRealm().getGate();
//			// Distance to this realm gate
//			result += Point.distanceBetween(x.getPoint(), gate1.getPoint());
//			// Distance between gates
//			result += Point.distanceBetween(gate1.getPoint(), gate2.getPoint());
//			// Distance from destination realm gate to destination
//			result += Point.distanceBetween(gate2.getPoint(), y.getPoint());
//		} else {
			result += Point.distanceBetween(x.getPoint(), y.getPoint());
//		}
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
	
	/**
	 * Adds the given connection to the connection array
	 * @param c Connection to add
	 */
	public void addConection(Connection c) {
		if(connections == null) connections = new ArrayList<Connection>();
		connections.add(c);
	}
}
