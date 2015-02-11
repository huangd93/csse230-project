import java.util.ArrayList;

public abstract class AbstractPlace {
	private String name;
	private ArrayList<Connection> connections;
	private ArrayList<Place> neighbors;
	private Point point;
	private Integer rating;
	private Realm realm;
	
	//the next two are only used within the PlacesTree
	public Place leftChild = null;
	public Place rightChild = null;
	
	public static double estimatedDistance(Place x, Place y) {
		double result = 0;
		if(x.getRealm() != y.getRealm()) {
			// TODO: Add in finding realm gate stuff
		}
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

	public ArrayList<Place> getNeighbors() {
		return this.neighbors;
	}

	public void setNeighbors(ArrayList<Place> neighbors) {
		this.neighbors = neighbors;
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
	
}