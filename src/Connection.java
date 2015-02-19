
/**
 * A connection is the object used to connect Places. It stores a point by point route in between the two Places, 
 * as well as the distance and travel time between them. Finally, it stores its destination. 
 * @author huangd
 *
 */
public class Connection {
	
	private Place destination;
	private Route route;
	private double distance;
	private double time;
	
	/**
	 * Creates a connection with the specified values
	 * @param d Destination Place
	 * @param r Route that this follows
	 * @param speed The speed of travel, used to calculate time.
	 */
	public Connection(Place d, Route r, int speed) {
		destination = d;
		route = r;
		distance = r.getDistance();
		time = distance / speed;
	}
	
	public Place getDestination(){
		return this.destination;
	}
	
	public void setDestination(Place newDestination){
		this.destination = newDestination;
	}
	
	public Route getRoute(){
		return this.route;
	}
	
	public void setRoute(Route newRoute){
		this.route = newRoute;
	}
	
	public double getDistance(){
		return this.distance;
	}
	
	public void setDistance(Integer newDistance){
		this.distance = newDistance;
	}
	
	public double getTime(){
		return this.time;
	}
	
	public void setTime(Integer newTime){
		this.time = newTime;
	}

}
