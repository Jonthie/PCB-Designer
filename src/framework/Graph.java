package framework;

import java.awt.*;
import java.awt.geom.*;
import java.io.Serializable;
import java.util.*;
import java.util.List;

@SuppressWarnings("serial")
public abstract class Graph implements Serializable{

	public Graph() {
		nodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
	}
	
	 public boolean connect(Edge e, Point2D p1, Point2D p2){
	      Node n1 = findNode(p1);
	      Node n2 = findNode(p2);
	      if (n1 != null && n2 != null)
	      {
	         e.connect(n1, n2);
	         edges.add(e);
	         return true;
	      }
	      return false;
	   }

	public void add(Node n, Point2D p) {
		Rectangle2D bounds = n.getBounds();
		n.translate(p.getX() - bounds.getX(), p.getY() - bounds.getY());
		nodes.add(n);
	}

	public void draw(Graphics2D g2) {
		for (Node n : nodes)
			n.draw(g2);
		for(Edge e : edges)
			e.draw(g2);
	}
	
	public Node findNode(Point2D point){
		for(Node n : nodes){
			if(n.getBounds().contains(point)){
				return n;
			}
		}
		return null;
	}
	
	public Edge findEdge(Point2D point){
		for(Edge e : edges)
			if(e.contains(point))
					return e;
		return null;
	}
	
	public Rectangle2D getBounds(Graphics2D g2){
	      Rectangle2D r = null;
	      for (Node n : nodes)
	      {
	         Rectangle2D b = n.getBounds();
	         if (r == null) r = b;
	         else r.add(b);
	      }
	      for (Edge e : edges)
	         r.add(e.getBounds(g2));
	      return r == null ? new Rectangle2D.Double() : r;
	   }

	public abstract Node[] getNodePrototypes();
	public abstract Edge[] getEdgePrototypes();

	public List<Node> getNodes() {
		return Collections.unmodifiableList(nodes);
	}
	
	public List<Edge> getEdges(){
		return Collections.unmodifiableList(edges);
	}

	private ArrayList<Node> nodes;
	private ArrayList<Edge> edges;

}
