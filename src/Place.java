import java.util.ArrayList;


public class Place extends AbstractPlace{
	
	public Place(String n, ArrayList<Connection> con, ArrayList<Place> neighbors, Point p, int r, Realm re) {
		
	}
	
	public ArrayList<Connection> shortestRouteTo(Place destination) {
		if(this.getRealm() != destination.getRealm()) {
			
		}
		return null;
	}
	
	public ArrayList<Connection> fastestRouteTo(Place destination) {
		return null;
		
	}
}
