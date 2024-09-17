package parser;

import java.util.ArrayList;



public class topology {
	public boolean directed ;
	public boolean multigraph ;
	public graph grap;
	public ArrayList<nodes> nodes ;
    public ArrayList<links> links ;

	public boolean isDirected() {
		return directed;
	}
	public ArrayList<links> getLinks() {
		return links;
	}
	public void setLinks(ArrayList<links> links) {
		this.links = links;
	}
	public void setDirected(boolean directed) {
		this.directed = directed;
	}
	public boolean isMultigraph() {
		return multigraph;
	}
	public void setMultigraph(boolean multigraph) {
		this.multigraph = multigraph;
	}
	public graph getGrap() {
		return grap;
	}
	public void setGrap(graph grap) {
		this.grap = grap;                    
	}
	public ArrayList<nodes> getNodes() {
		return nodes;
	}
	public void setNodes(ArrayList<nodes> nodes) {
		this.nodes = nodes;
	}
	public topology(boolean directed, boolean multigraph, graph grap, ArrayList<nodes> nodes ,  ArrayList<links> links) {
		super();
		this.directed = directed;
		this.multigraph = multigraph;
		this.grap = grap;
		this.nodes = nodes;
		this.links = links;
	}
	public topology() {
		super();
		// TODO Auto-generated constructor stub
	}
}
