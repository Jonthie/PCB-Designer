package framework;

import java.awt.*;
import java.awt.geom.*;

public interface Node extends Cloneable {

	void draw(Graphics2D g2);

	void translate(double dx, double dy);

	Rectangle2D getBounds();

	Object clone();
	
	Point2D getConnectionPoint(Point2D aPoint);
}
