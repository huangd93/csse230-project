import java.awt.BasicStroke;
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
	public ArrayList<Point> shortPoints = new ArrayList<Point>();
	public ArrayList<Point> fastPoints = new ArrayList<Point>();
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
			drawPointsandLines(this.fastPoints, g2, "fast");
			drawPointsandLines(this.shortPoints, g2, "short");
		}
	}
	public void drawPointsandLines(ArrayList<Point> points, Graphics2D g2, String r) throws IllegalArgumentException {
		if(points == null || points.size() == 0) throw new IllegalArgumentException();
		double offset = 5;
		if(r.equals("short")){
			for(int i = 0; i < points.size(); i++){
				if(i == 0){
					double thisX = points.get(i).getXValue();
					double thisY = points.get(i).getYValue();
					Point2D thisPoint = new Point2D.Double(thisX, thisY);
					Ellipse2D marker = new Ellipse2D.Double(thisPoint.getX(), thisPoint.getY(), 10, 10);
					double nextX = points.get(i + 1).getXValue() + offset;
					double nextY = points.get(i + 1).getYValue() + offset;
					Point2D nextPoint = new Point2D.Double(nextX, nextY);
					Point2D thisPointOffset = new Point2D.Double(thisX + offset, thisY + offset);
					Line2D line = new Line2D.Double(thisPointOffset, nextPoint);
					g2.setColor(Color.GREEN);
					g2.fill(marker);
					g2.setColor(Color.BLUE);
					g2.setStroke(new BasicStroke(3));
					g2.draw(line);
				}else if(i > 0 && i < points.size() - 1){
					double thisX = points.get(i).getXValue();
					double thisY = points.get(i).getYValue();
					double nextX = points.get(i + 1).getXValue() + offset;
					double nextY = points.get(i + 1).getYValue() + offset;
					Point2D thisPoint = new Point2D.Double(thisX, thisY);
					Ellipse2D marker = new Ellipse2D.Double(thisPoint.getX(), thisPoint.getY(), 10, 10);
					Point2D nextPoint = new Point2D.Double(nextX, nextY);
					Point2D thisPointOffset = new Point2D.Double(thisX + offset, thisY + offset);
					Line2D line = new Line2D.Double(thisPointOffset, nextPoint);
					g2.setColor(Color.BLUE);
					g2.setStroke(new BasicStroke(3));
					g2.fill(marker);
					g2.draw(line);
					
				}else if(i == points.size() - 1){
					double thisX = points.get(i).getXValue();
					double thisY = points.get(i).getYValue();
					Point2D thisPoint = new Point2D.Double(thisX, thisY);
					Ellipse2D marker = new Ellipse2D.Double(thisPoint.getX(), thisPoint.getY(), 10, 10);
					g2.setColor(Color.RED);
					g2.fill(marker);
				}
			}
			this.shortPoints.clear();
		}else{
			for(int i = 0; i < points.size(); i++){
				if(i == 0){
					double thisX = points.get(i).getXValue();
					double thisY = points.get(i).getYValue();
					Point2D thisPoint = new Point2D.Double(thisX, thisY);
					Ellipse2D marker = new Ellipse2D.Double(thisPoint.getX(), thisPoint.getY(), 10, 10);
					double nextX = points.get(i + 1).getXValue() + offset;
					double nextY = points.get(i + 1).getYValue() + offset;
					Point2D nextPoint = new Point2D.Double(nextX, nextY);
					Point2D thisPointOffset = new Point2D.Double(thisX + offset, thisY + offset);
					Line2D line = new Line2D.Double(thisPointOffset, nextPoint);
					g2.setColor(Color.GREEN);
					g2.fill(marker);
					g2.setColor(Color.PINK);
					g2.setStroke(new BasicStroke(6));
					g2.draw(line);
				}else if(i > 0 && i < points.size() - 1){
					double thisX = points.get(i).getXValue();
					double thisY = points.get(i).getYValue();
					double nextX = points.get(i + 1).getXValue() + offset;
					double nextY = points.get(i + 1).getYValue() + offset;
					Point2D thisPoint = new Point2D.Double(thisX, thisY);
					Ellipse2D marker = new Ellipse2D.Double(thisPoint.getX(), thisPoint.getY(), 10, 10);
					Point2D nextPoint = new Point2D.Double(nextX, nextY);
					Point2D thisPointOffset = new Point2D.Double(thisX + offset, thisY + offset);
					Line2D line = new Line2D.Double(thisPointOffset, nextPoint);
					g2.fill(marker);
					g2.setColor(Color.PINK);
					g2.setStroke(new BasicStroke(6));
					g2.draw(line);
					
				}else if(i == points.size() - 1){
					double thisX = points.get(i).getXValue();
					double thisY = points.get(i).getYValue();
					Point2D thisPoint = new Point2D.Double(thisX, thisY);
					Ellipse2D marker = new Ellipse2D.Double(thisPoint.getX(), thisPoint.getY(), 10, 10);
					g2.setColor(Color.RED);
					g2.fill(marker);
				}
			}
			this.fastPoints.clear();
		}
		this.bool = false;
	}
	
	public void collectShortPoint(Point p){
		this.shortPoints.add(p);
	}
	
	public void collectFastPoint(Point p){
		this.fastPoints.add(p);
	}

}