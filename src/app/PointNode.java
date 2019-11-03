package app;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import framework.Node;

public class PointNode implements Node{
	private Point2D point;
	
	public PointNode(){
		point = new Point2D.Double();
		
	}
	
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException exception) {
			return null;
		}
	}

	@Override
	public void draw(Graphics2D g2) {
	}

	@Override
	public void translate(double dx, double dy) {
		point.setLocation(point.getX()+dx , point.getY()+dy);
	}

	@Override
	public Rectangle2D getBounds() {
		return new Rectangle2D.Double(point.getX(), 
		         point.getY(), 0, 0);
	}

	@Override
	public Point2D getConnectionPoint(Point2D aPoint) {
		return point;
	}

}
