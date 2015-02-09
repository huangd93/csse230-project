
public class Connection {
	
	public Place destination;
	public Route route;
	public Integer distance;
	public Integer time;
	
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
	
	public Integer getDistance(){
		return this.distance;
	}
	
	public void setDistance(Integer newDistance){
		this.distance = newDistance;
	}
	
	public Integer getTime(){
		return this.time;
	}
	
	public void setTime(Integer newTime){
		this.time = newTime;
	}

}
