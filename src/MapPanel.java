import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import javax.swing.JPanel;


public class MapPanel extends JPanel {
	Graphics2D g2;
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		this.g2 = g2;
	}
	public void drawPointsandLines(double x, double y){
		Point2D point = new Point2D.Double(x, y);
		Ellipse2D marker = new Ellipse2D.Double(point.getX(), point.getY(), 10, 10);
		this.g2.draw(marker);
		System.out.println("Here...");
	}

}
