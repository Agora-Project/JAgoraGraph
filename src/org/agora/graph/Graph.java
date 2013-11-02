package org.agora.graph;

import java.util.HashMap;
import java.util.Iterator;
import org.bson.BSONObject;
import org.bson.BasicBSONObject;
import org.bson.types.BasicBSONList;



public class Graph implements BSONable {

	public HashMap<Integer, Node> nodeMap;
	public HashMap<Integer, Edge> edgeMap;

	protected Node[] nodes;
	
	public static String JSONTag = "graph";

	public Graph() {
		nodeMap = new HashMap<Integer, Node>();
		edgeMap = new HashMap<Integer, Edge>();
	}
	
	/**
	 * Construct a graph entirely from a BSON object! (hopefully - no error handling yet, and nothing to test it against)
	 * @param bson
	 */
	public Graph(BSONObject bson) {
		nodeMap = new HashMap<Integer, Node>();
		edgeMap = new HashMap<Integer, Edge>();
		
		BasicBSONList nodes = new BasicBSONList();
		nodes = (BasicBSONList) bson.get("nodes");
		BasicBSONList edges = new BasicBSONList();
		edges = (BasicBSONList) bson.get("edges");
		
		for (Iterator<Object> i = nodes.iterator(); i.hasNext();) {
			Node n = new Node((BSONObject) i.next());
			nodeMap.put(n.getID(), n);
		}
		
		for (Iterator<Object> i = edges.iterator(); i.hasNext();) {
			Edge e = new Edge((BSONObject) i.next());
			edgeMap.put(e.getID(), e);
		}
	}

	public void addNode(Node node) { nodeMap.put(node.getID(), node); }

	/**
	 * Adds edge to the Graph and to the respective nodes.
	 * @param edge
	 */
	public void addEdge(Edge edge) {
		edgeMap.put(edge.getID(), edge);
		edge.getOrigin().addOutgoingEdge(edge);
		edge.getTarget().addIncomingEdge(edge);
	}


	public boolean isInGraph(Integer id) { return nodeMap.containsKey(id); }
	public Node getNodeByID(Integer id) { return nodeMap.get(id); }
	public Node[] getNodes() { return nodes; }


	@Override
	public BSONObject getBSON() {
		BSONObject bsonGraph = new BasicBSONObject();
		
		// Create BSONList containing nodes
		BasicBSONList bsonNodeList = new BasicBSONList();
		for (Iterator<Integer> i = nodeMap.keySet().iterator(); i.hasNext();) {
			int next = i.next();
			bsonNodeList.set(next, nodeMap.get(next).getBSON());
		}		
		bsonGraph.put("nodes", bsonNodeList);
		
		// Create BSONList containing edges
		BasicBSONList bsonEdgeList = new BasicBSONList();
		for (Iterator<Integer> i = edgeMap.keySet().iterator(); i.hasNext();) {
			int next = i.next();
			bsonNodeList.set(next, edgeMap.get(next).getBSON());
		}
		bsonGraph.put("edges", bsonEdgeList);
		
		return bsonGraph;
	}

}
