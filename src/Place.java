import java.util.ArrayList;


public class Place extends AbstractPlace{
	
	public Place(String n, ArrayList<Connection> con, Point p, int r, Realm re) {
		
	}
	
	public LinkedList<Connection> shortestRouteTo(Place destination) {
		if(this.getName().equals(destination.getName())) {
			return null;
		}
		LinkedList<Connection> result = new LinkedList<Connection>();
		if(this.getRealm() != destination.getRealm()) {
			if(this.getName().equals(this.getRealm().name())) {
				
			}
		} else {
			double min;
			Connection minConnection = null;
			for(Connection i : getConnections()) {
				double distance = i.getDistance() + Point.distanceBetween(i.getDestination().getPoint(), destination.getPoint());
				
			}
			
			LinkedList<Connection> temp = shortestRouteTo(destination);
			if(temp == null); 
		}
		
		return null;
	}
	
	public ArrayList<Connection> fastestRouteTo(Place destination) {
		return null;
		
	}
}
