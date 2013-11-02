package org.agora.graph;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.agora.graph.properties.PostInfo;
import org.bson.BSONObject;
import org.bson.BasicBSONObject;
import org.bson.types.BasicBSONList;

public class Node implements BSONable, ID {
	public static String JSONTag = "node";
	
	private PostInfo post;
	protected List<Edge> incomingEdges;
	protected List<Edge> outgoingEdges;
	
	private Integer ID;
	private String source;
	protected double acceptability;
	protected int threadID;


	protected Node() {
		incomingEdges = new LinkedList<Edge>();
		outgoingEdges = new LinkedList<Edge>();
	}

	public Node(String source, Integer ID) {
		this.ID = ID;
		this.source = source;
	}

	public Node(BSONObject bsonObject) {
		BasicBSONObject bson = (BasicBSONObject) bsonObject;
		setID(bson.getInt(JSON_ID));
		setSource(bson.getString(JSON_SOURCE));
		setAcceptability(bson.getDouble("acceptability"));
		setThreadID(bson.getInt("thread_ID"));
		
		post = new PostInfo((BSONObject) bsonObject.get(PostInfo.JSONTag));
		
		// Add incoming and outgoing edges to a list
		BasicBSONList incoming = (BasicBSONList) bson.get("incoming");
		BasicBSONList outgoing = (BasicBSONList) bson.get("outgoing");
		for (Iterator<Object> i = incoming.iterator(); i.hasNext();) {
			Edge e = new Edge((BSONObject) i.next());
			incomingEdges.add(e.getID(), e);
		}
		for (Iterator<Object> i = outgoing.iterator(); i.hasNext();) {
			Edge e = new Edge((BSONObject) i.next());
			outgoingEdges.add(e.getID(), e);
		}
		
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
	public String getSource() { return source; }


	public Iterator<Edge> getIncomingEdges() { return incomingEdges.iterator(); }
	public Iterator<Edge> getOutgoingEdges() { return outgoingEdges.iterator(); }


	public Integer getID() { return ID; }
	public double getAcceptability() { return acceptability; }
	public int getThreadID() { return threadID; }

	public void setID(Integer id) { this.ID = id; }
	public void setAcceptability(double a) { this.acceptability = a; }
	public void setThreadID(int id) { this.threadID = id ; }

	@Override
	public int hashCode() {
		return ID.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return ID.equals(obj);
	}

	@Override
	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public void setID(int digit) {
		this.ID = digit;
	}

	@Override
	public BSONObject getBSON() {
		BasicBSONObject bson = new BasicBSONObject();
		bson.put(JSON_ID, ID);
		bson.put(JSON_SOURCE, source);
		bson.put("acceptability", acceptability);
		bson.put(PostInfo.JSONTag, post.getBSON());
		
		// Edges
		BasicBSONList incomingList = new BasicBSONList();
		BasicBSONList outgoingList = new BasicBSONList();
		incomingList.addAll(incomingEdges);
		outgoingList.addAll(outgoingEdges);
		bson.put("incoming", incomingList);
		bson.put("outgoing", outgoingList);
		return bson;
	}

	public PostInfo getPost() {
		return post;
	}

	public void setPost(PostInfo post) {
		this.post = post;
	}



}
