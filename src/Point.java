public class Point {
	
	private Integer xValue;
	private Integer yValue;
	
	public Point(int x, int y) {
		xValue = x;
		yValue = y;
	}
	
	public double distanceTo(Point p) {
		double xSquared = Math.pow(xValue - p.getXValue(), 2);
		double ySquared = Math.pow(yValue - p.getYValue(), 2);
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
