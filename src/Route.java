import java.util.ArrayList;

/**
 * An array of points that specify the turns and such on a route between two places
 * @author huangd
 *
 */
@SuppressWarnings("serial")
public class Route extends ArrayList<Point> {
	
	/**
	 * Creates an empty route
	 */
	public Route() {
	}
	
	/**
	 * Creates a route with the given ArrayList of points
	 * @param input
	 */
	public Route(ArrayList<Point> input) {
		super.addAll(input);
	}
	
	/**
	 * Returns the total length of this route
	 * @return
	 */
	public double getDistance() {
		double result =0;
		Point last = super.get(0);
		for(Point o: this) {
			result += o.distanceTo(last);
		}
		return result;
	}
	
	/**
	 * Add a point to the tail of this route
	 * @param point
	 * @return
	 */
	public boolean addPoint(Point point) {
		super.add(point);
		return true;
	}
	
	/**
	 * Adds a point at the given index of this route. 
	 * Displaces all Points at and after that index back 1.
	 * @param point
	 * @param i
	 * @return
	 */
	public boolean insertPoint(Point point, int i) {
		super.add(i, point);
		return true;
	}
	
	/**
	 * Returns the ArrayList of Points that make up this route
	 * @return
	 */
	public ArrayList<Point> getPoints(){
		return this.pointsArray;
	}
}
