package org.agora.graph;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Node {
	protected NodeID id;
	
	protected String posterName;
	protected int posterID;
	
	protected Date date;
	
	protected double acceptability;
	
	protected int threadID;

	protected List<Edge> incomingEdges;
	protected List<Edge> outgoingEdges;

	protected Node() {
	  incomingEdges = new LinkedList<Edge>();
    outgoingEdges = new LinkedList<Edge>();
	}
	
	protected Node(String source, Integer ID) {
	  this();
		id = new NodeID();
		id.setSource(source);
		id.setNumber(ID);
	}
	
	protected Node(ResultSet rs) throws SQLException {
	  this(rs.getString("source_ID"), rs.getInt("arg_ID"));
	  posterName = rs.getString("username");
	  posterID = rs.getInt("user_ID");
	  date = rs.getDate("date");
	  acceptability = rs.getDouble("acceptability");
	  threadID = rs.getInt("thread_ID");
	}

	/**
	 * Adds an edge to the node
	 * @param att
	 */
	protected void addIncomingEdge(Edge arg) {
	  incomingEdges.add(arg);
	}
	
	protected void addOutgoingEdge(Edge arg) {
    outgoingEdges.add(arg);
  }
	
	public int getNumber() { return id.getNumber(); }
	public String getSource() { return id.getSource(); }


	public Iterator<Edge> getIncomingEdges() { return incomingEdges.iterator(); }
	public Iterator<Edge> getOutgoingEdges() { return outgoingEdges.iterator(); }
	
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return id.equals(obj);
	}

}
