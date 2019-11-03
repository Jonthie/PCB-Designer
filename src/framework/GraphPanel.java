package framework;

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class GraphPanel extends JComponent {

	public GraphPanel(ToolBar aToolBar, Graph aGraph) {
		toolBar = aToolBar;
		graph = aGraph;
		setBackground(Color.WHITE);

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				Point2D mousePoint = event.getPoint();
				Node n = graph.findNode(mousePoint);
				Edge e = graph.findEdge(mousePoint);
				origin = mousePoint;
				Object tool = toolBar.getSelectedTool();
				if (tool != null) {
					if(tool instanceof Node){
						Node prototype = (Node) tool;
						Node newNode = (Node) prototype.clone();
						graph.add(newNode, mousePoint);
					}
					else if(tool instanceof Edge){
						if(n != null)lineStart = mousePoint;
						
					}
					else{
						selected = graph.findNode(mousePoint);
					}
				}
				repaint();
			}
			public void mouseReleased(MouseEvent event){
				Object tool = toolBar.getSelectedTool();
				if(lineStart != null){
					Point2D mousePoint = event.getPoint();
					Edge prototype = (Edge) tool;
					Edge newEdge = (Edge)prototype.clone();
					if (graph.connect(newEdge, 
							lineStart, mousePoint))
						selected = newEdge;
				}
				revalidate();
				repaint();
				lineStart = null;
				origin = event.getPoint();
			}
		});
		addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent event){
				Point2D mousePoint = event.getPoint();
				Object tool = toolBar.getSelectedTool();
				if (tool != null) {
					if(tool instanceof Node){
						//DO SOME when mouse released
					}
					else{
						if(selected != null && selected instanceof Node)
							((Node)selected).translate(mousePoint.getX()-origin.getX() , mousePoint.getY()-origin.getY());
					}
					origin = mousePoint;
				}
				repaint();
			}
		});
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		graph.draw(g2);
	}

	private Point2D origin;
	private Point2D lineStart;
	private Object selected;
	private Graph graph;
	private ToolBar toolBar;
}
