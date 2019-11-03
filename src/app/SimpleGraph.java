package app;

import java.awt.*;

import framework.*;

@SuppressWarnings("serial")
public class SimpleGraph extends Graph {
	public Node[] getNodePrototypes() {
		Node[] nodeTypes = { new CircleNode(Color.BLACK), new CircleNode(Color.WHITE), new SquareNode(Color.BLUE)};
		return nodeTypes;
	}
	public Edge[] getEdgePrototypes(){
		Edge[] edgeTypes = {new LineEdge()};
		return edgeTypes;
	}
}
