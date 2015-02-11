
public class Connection {
	
	private Place destination;
	private Route route;
	private double distance;
	private double time;
	
	//destination, new route object (two points, beginning and end), speed
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
