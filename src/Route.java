import java.util.ArrayList;

/**
 * Route object. Stores an ArrayList of points. Needs to have at least a starting and ending point.
 * @author huangd
 *
 */
public class Route {
	
	private ArrayList<Point> pointsArray;
	
	/**
	 * Creates an empty route
	 */
	public Route() {
		pointsArray = new ArrayList<Point>();
	}
	
	/**
	 * Creates a route with the given set of points
	 * @param input
	 * @throws IllegalArgumentException
	 */
	public Route(ArrayList<Point> input) throws IllegalArgumentException {
		if(input == null || input.size() < 2) throw new IllegalArgumentException();
		pointsArray = input;
	}
	
	/**
	 * Returns the length of this route. Finds this calculating point to point from start to finish.
	 * @return
	 */
	public double getDistance() {
		double result =0;
		Point last = pointsArray.get(0);
		for(Point o: pointsArray) {
			result += Point.distanceBetween(o, last);
		}
		return result;
	}
	
	/**
	 * Adds a point to this route
	 * @param point
	 * @return
	 */
	public boolean addPoint(Point point) {
		if(pointsArray == null) return false;
		pointsArray.add(point);
		return true;
	}
	
	/**
	 * Returns the points ArrayList in this route
	 * @return
	 */
	public ArrayList<Point> getPoints(){
		return this.pointsArray;
	}
}
