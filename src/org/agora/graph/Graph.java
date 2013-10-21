package org.agora.graph;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;



public abstract class Graph {

	public Map<ID, Node> nodeMap;
	public Map<EdgeID, Edge> edgeMap;

	protected Node[] nodes;

	/**
	 * This takes in a ResultSet and makes the following assumptions: 1) first
	 * column is argument source; 2) second column is argument ID.
	 * @param rs Where the database results come from.
	 */
	public void loadNodesFromResultSet(ResultSet rs) throws SQLException {
		List<Node> tmpNodes = new LinkedList<Node>();
		
		nodeMap = new HashMap<ID, Node>();

		while (rs.next()) {
			Node a = new Node(rs);
			tmpNodes.add(a);
			nodeMap.put(a.id, a);
		}

		this.nodes = tmpNodes.toArray(new Node[0]);
	}

	//TODO: Split ID loading from a ResultSet into their own functions.
	
	/**
	 * Assumes the column ordering is sourceArg.source, sourceArg.localID,
	 * targetArg.source, targetArg.localID
	 * @param rs Where the database results come from.
	 * @throws SQLException
	 */
	public void loadEdgesFromResultSet(ResultSet rs) throws SQLException  {
		while(rs.next()) {
			ID originID = new ID();
				originID.setSource(rs.getString("source_ID_attacker"));
				originID.setNumber(rs.getInt("arg_ID_attacker"));
			ID targetID = new ID();
				targetID.setSource(rs.getString("source_ID_attacker"));
				targetID.setNumber(rs.getInt("arg_ID_attacker"));
			Edge edge = new Edge(nodeMap.get(originID), nodeMap.get(targetID));
			addEdge(edge);
		}
	}

	public void addEdge(Edge edge) {
		edgeMap.put(edge.getID(), edge);
		edge.getOrigin().addEdge(edge);
	}

	public Node[] getNodes() { return nodes; }

}
