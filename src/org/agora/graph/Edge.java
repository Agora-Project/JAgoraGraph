package org.agora.graph;

import org.agora.graph.properties.UserInfo;
import org.bson.BSONObject;
import org.bson.BasicBSONObject;

public class Edge implements BSONable, ID {
	private UserInfo poster;
	protected Node origin;
	protected Node target;
	
	private String source;
	private Integer ID;
	
	public static String JSONTag = "edge";

	public Edge(BSONObject bson) {
		poster = new UserInfo((BSONObject)bson.get(UserInfo.JSONTag));
		origin = new Node((BSONObject)bson.get("origin"));
		target = new Node((BSONObject)bson.get("target"));
		source = (String)bson.get(JSON_SOURCE);
		ID = (Integer)bson.get(JSON_ID);
		
	}
	public Edge(Node origin, Node target, Integer ID) {
		this.origin = origin;
		this.target = target;
		setID(ID);
		setSource(origin.getSource() + target.getSource());
	}
	
	public Node getOrigin() { return origin; }
	public Node getTarget() { return target; }
	
	@Override
	public BSONObject getBSON() {
		BasicBSONObject bson = new BasicBSONObject();
		bson.put("origin", origin.getBSON());
		bson.put("target", target.getBSON());
		bson.put(UserInfo.JSONTag, poster.getBSON());
		bson.put(JSON_SOURCE, getSource());
		bson.put(JSON_ID, getID());
		return bson;
	}


	@Override
	public String getSource() {
		// TODO Auto-generated method stub
		return source;
	}


	@Override
	public void setSource(String source) {
		this.source = source;
	}


	@Override
	public void setID(int digit) {
		ID = digit;
	}
	@Override
	public Integer getID() {
		// TODO Auto-generated method stub
		return ID;
	}



}
