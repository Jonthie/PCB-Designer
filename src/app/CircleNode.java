package app;

import java.awt.*;
import java.awt.geom.*;

import framework.*;

/**
 * A circular node that is filled with a color.
 */
public class CircleNode implements Node {
	public CircleNode(Color aColor) {
		size = DEFAULT_SIZE;
		x = 0;
		y = 0;
		color = aColor;
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException exception) {
			return null;
		}
	}

	public void draw(Graphics2D g2) {
		Ellipse2D circle = new Ellipse2D.Double(x, y, size, size);
		Color oldColor = g2.getColor();
		g2.setColor(color);
		g2.fill(circle);
		g2.setColor(oldColor);
		g2.draw(circle);
	}

	public void translate(double dx, double dy) {
		x += dx;
		y += dy;
	}

	public Rectangle2D getBounds() {
		return new Rectangle2D.Double(x, y, size, size);
	}
	
	@Override
	public Point2D getConnectionPoint(Point2D aPoint) {
		double centerX = x + size / 2;
		double centerY = y + size / 2;
		double dx = aPoint.getX() - centerX;
		double dy = aPoint.getY() - centerY;
		double distance = Math.sqrt(dx * dx + dy * dy);
		if (distance == 0) return aPoint;
		else return new Point2D.Double(
				centerX + dx * (size / 2) / distance,
				centerY + dy * (size / 2) / distance);
	}

	private double x;
	private double y;
	private double size;
	private Color color;
	private static final int DEFAULT_SIZE = 20;
}
