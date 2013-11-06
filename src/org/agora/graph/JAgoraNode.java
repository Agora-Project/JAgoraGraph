package org.agora.graph;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.bson.BSONObject;

public class JAgoraNode {
	protected JAgoraNodeID id;
	
	protected String posterName;
	protected int posterID;
	
	protected Date date;
	
	protected double acceptability;
	
	protected BSONObject content;
	
	protected int threadID;

	protected List<JAgoraEdge> incomingEdges;
	protected List<JAgoraEdge> outgoingEdges;

	public JAgoraNode() {
	  incomingEdges = new LinkedList<JAgoraEdge>();
    outgoingEdges = new LinkedList<JAgoraEdge>();
	}
	
	public void construct(JAgoraNodeID nodeID) {
	  this.id = nodeID;
	}
	
	public JAgoraNode(JAgoraNodeID nodeID) {
	  construct(nodeID);
	}
	
	public JAgoraNode(String source, Integer ID) {
	  construct(new JAgoraNodeID(source, ID));
	}
	
	public JAgoraNode(ResultSet rs) throws SQLException {
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
	public void addIncomingEdge(JAgoraEdge arg) {
	  incomingEdges.add(arg);
	}
	
	public void addOutgoingEdge(JAgoraEdge arg) {
    outgoingEdges.add(arg);
  }
	
	public int getNumber() { return id.getLocalID(); }
	public String getSource() { return id.getSource(); }


	public Iterator<JAgoraEdge> getIncomingEdges() { return incomingEdges.iterator(); }
	public Iterator<JAgoraEdge> getOutgoingEdges() { return outgoingEdges.iterator(); }
	
	
	public JAgoraNodeID getID() { return id; }
  public String getPosterName() { return posterName; }
  public int getPosterID() { return posterID; }
  public Date getDate() { return date; }
  public double getAcceptability() { return acceptability; }
  public int getThreadID() { return threadID; }
  public BSONObject getContent() { return content; }
  
  public void setID(JAgoraNodeID id) { this.id = id; }
  public void setPosterName(String posterName) { this.posterName = posterName; }
  public void setPosterID(int id) { this.posterID = id ; }
  public void setDate(Date date) { this.date = date; }
  public void setAcceptability(double a) { this.acceptability = a; }
  public void setThreadID(int id) { this.threadID = id ; }
  public void getContent(BSONObject content) { this.content = content; }

  @Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return id.equals(obj);
	}

}
