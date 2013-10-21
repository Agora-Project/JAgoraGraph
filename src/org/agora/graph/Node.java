package org.agora.graph;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
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
	
	public Node(NodeID nodeID) {
	  id = nodeID;
	}
	
	public Node(String source, Integer ID) {
	  this(new NodeID(source, ID));
	}
	
	public Node(ResultSet rs) throws SQLException {
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
	public void addIncomingEdge(Edge arg) {
	  incomingEdges.add(arg);
	}
	
	public void addOutgoingEdge(Edge arg) {
    outgoingEdges.add(arg);
  }
	
	public int getNumber() { return id.getLocalID(); }
	public String getSource() { return id.getSource(); }


	public Iterator<Edge> getIncomingEdges() { return incomingEdges.iterator(); }
	public Iterator<Edge> getOutgoingEdges() { return outgoingEdges.iterator(); }
	
	
	public NodeID getID() { return id; }
  public String getPosterName() { return posterName; }
  public int getPosterID() { return posterID; }
  public Date getDate() { return date; }
  public double getAcceptability() { return acceptability; }
  public int getThreadID() { return threadID; }
  
  public void setID(NodeID id) { this.id = id; }
  public void setPosterName(String posterName) { this.posterName = posterName; }
  public void setPosterID(int id) { this.posterID = id ; }
  public void setDate(Date date) { this.date = date; }
  public void setAcceptability(double a) { this.acceptability = a; }
  public void setThreadID(int id) { this.threadID = id ; }

  @Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return id.equals(obj);
	}

}
