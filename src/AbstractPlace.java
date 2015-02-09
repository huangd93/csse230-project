import java.util.ArrayList;

public abstract class AbstractPlace {
	String name;
	ArrayList<Connection> neighbors;
	Point point;
	Integer rating;
	Place realm;

	public String getName() {
		return this.name;
	}
	
	public void setName(String newName){
		this.name = newName;
	}
	
	public ArrayList<Connection> getNeighbors(){
		return this.neighbors;
	}
	
	public void setNeighbors(ArrayList<Connection> newNeighbors){
		this.neighbors = newNeighbors;
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
	
	public Place getRealm(){
		return this.realm;
	}
	
	public void setRealm(Place newRealm){
		this.realm = newRealm;
	}
	
}