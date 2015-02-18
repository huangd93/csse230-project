import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import javax.swing.JPanel;


public class MapPanel extends JPanel {
	public boolean bool;
	public double x;
	public double y;
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if(this.bool){
			drawPointsandLines(this.x, this.y, g2);
		}
	}
	public void drawPointsandLines(double x, double y, Graphics2D g2){
		Point2D point = new Point2D.Double(x, y);
		Ellipse2D marker = new Ellipse2D.Double(point.getX(), point.getY(), 10, 10);
		g2.setColor(Color.RED);
		g2.fill(marker);
		System.out.println("Here...");
	}
	
	public void setXandY(double x, double y){
		this.x = x;
		this.y = y;
	}

}
