
/**
 * A Point. Stores a set of x and y coordinates
 * @author huangd
 *
 */
public class Point {
	
	private Integer xValue;
	private Integer yValue;
	
	/**
	 * Creates a point at the given x and y coordinates
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public Point(int x, int y) {
		xValue = x;
		yValue = y;
	}
	
	/**
	 * Calculates the distance between this point and the given point
	 * @param p
	 * @return
	 */
	public double distanceTo(Point p) {
		return distanceBetween(this, p);
	}
	
	/**
	 * Calculates the distance between the given two points
	 * @param x
	 * @param y
	 * @return Distance between the two points
	 */
	public static double distanceBetween(Point x, Point y) {
		double xSquared = Math.pow(x.getXValue() - y.getXValue(),2);
		double ySquared = Math.pow(x.getYValue() - y.getYValue(),2);
		return Math.sqrt(xSquared + ySquared);
	}
	
	public Integer getXValue(){
		return this.xValue;
	}
	
	public void setXValue(Integer newX){
		this.xValue = newX;
	}
	
	public Integer getYValue(){
		return this.yValue;
	}
	
	public void setYValue(Integer newY){
		this.yValue = newY;
	}

}
