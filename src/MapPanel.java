import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JPanel;


public class MapPanel extends JPanel {
	public boolean bool;
	public ArrayList<Point> points = new ArrayList<Point>();
	public int index = 0;
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if(this.bool){
			drawPointsandLines(this.points, g2);
		}
	}
	public void drawPointsandLines(ArrayList<Point> points, Graphics2D g2){
		for(Point p: points){
			double x = p.getXValue();
			double y = p.getYValue();
			Point2D point = new Point2D.Double(x, y);
			
			Ellipse2D marker = new Ellipse2D.Double(point.getX(), point.getY(), 10, 10);
//			Line2D line = new Line2D.Double(point, p2)
			g2.setColor(Color.RED);
			g2.fill(marker);
		}
		System.out.println("Here...");
		this.bool = false;
		this.index = 0;
		this.points.clear();
	}
	
	public void collectPoint(Point p){
		this.points.add(this.index, p);
		this.index++;
	}

}
