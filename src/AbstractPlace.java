import java.util.ArrayList;

public abstract class AbstractPlace {
	private String name;
	private ArrayList<Connection> connections;
	private ArrayList<Place> neighbors;
	private Point point;
	private Integer rating;
	private Realm realm;

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
	
}