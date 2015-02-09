import java.util.ArrayList;


public class Route {
	
	private ArrayList<Point> pointsArray;
	
	public Route() {
		pointsArray = new ArrayList<Point>();
	}
	
	public Route(ArrayList<Point> input) {
		pointsArray = input;
	}
	
	public double getDistance() {
		double result =0;
		Point last = pointsArray.get(0);
		for(Point o: pointsArray) {
			result += o.distanceTo(last);
		}
		return result;
	}
	
	public boolean addPoint(Point point) {
		if(pointsArray == null) return false;
		pointsArray.add(point);
		return true;
	}
	
	public ArrayList<Point> getPoints(){
		return this.pointsArray;
	}
}
