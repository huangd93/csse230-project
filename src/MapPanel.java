import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class MapPanel extends JPanel {
	public boolean bool;
	public ArrayList<Point> points = new ArrayList<Point>();
	public int index = 0;
	public BufferedImage img;
	public File file;
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		file = new File("yggdrasil.jpg");
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		g2.drawImage(img, 0, 0, this);
		if(this.bool){
			drawPointsandLines(this.points, g2);
		}
	}
	public void drawPointsandLines(ArrayList<Point> points, Graphics2D g2){
		double offset = 5;
		for(int i = 0; i < points.size(); i++){
			if(i == 0){
				double thisX = points.get(i).getXValue();
				double thisY = points.get(i).getYValue();
				Point2D thisPoint = new Point2D.Double(thisX, thisY);
				Ellipse2D marker = new Ellipse2D.Double(thisPoint.getX(), thisPoint.getY(), 10, 10);
				double nextX = points.get(i + 1).getXValue();
				double nextY = points.get(i + 1).getXValue();
				Point2D nextPoint = new Point2D.Double(nextX, nextY);
				Line2D line = new Line2D.Double(thisPoint, nextPoint);
				g2.setColor(Color.GREEN);
				g2.fill(marker);
			}else if(i > 0 && i < points.size() - 1){
				double thisX = points.get(i).getXValue();
				double thisY = points.get(i).getYValue();
				double nextX = points.get(i + 1).getXValue();
				double nextY = points.get(i + 1).getXValue();
				Point2D thisPoint = new Point2D.Double(thisX, thisY);
				Point2D nextPoint = new Point2D.Double(nextX, nextY);
				Ellipse2D marker = new Ellipse2D.Double(thisPoint.getX(), thisPoint.getY(), 10, 10);
				Line2D line = new Line2D.Double(thisPoint, nextPoint);
				g2.setColor(Color.BLUE);
				g2.fill(marker);
				
			}else if(i == points.size() - 1){
				double thisX = points.get(i).getXValue();
				double thisY = points.get(i).getYValue();
				Point2D thisPoint = new Point2D.Double(thisX, thisY);
				Ellipse2D marker = new Ellipse2D.Double(thisPoint.getX(), thisPoint.getY(), 10, 10);
				g2.setColor(Color.RED);
				g2.fill(marker);
			}
		}
		this.bool = false;
		this.index = 0;
		this.points.clear();
	}
	
	public void collectPoint(Point p){
		this.points.add(this.index, p);
		this.index++;
	}

}
