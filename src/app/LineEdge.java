package app;

import java.awt.*;
import java.awt.geom.*;

/**
   An edge that is shaped like a straight line.
*/
@SuppressWarnings("serial")
public class LineEdge extends AbstractEdge
{
   public LineEdge()
   {
      lineStyle = new BasicStroke();
   }

   public void draw(Graphics2D g2){
	   g2.draw(getConnectionPoints());
   }

   public boolean contains(Point2D aPoint){
	   final double MAX_DIST = 2;
	   return getConnectionPoints().ptSegDist(aPoint) < MAX_DIST;
   }

   /**
      Sets the line style property.
      @param newValue the new value
   */
   public void setLineStyle(Stroke newValue) { lineStyle = newValue; }

   /**
      Gets the line style property.
      @return the line style
   */
   public Stroke getLineStyle() { return lineStyle; }
   
   private Stroke lineStyle;
}
