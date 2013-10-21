package org.agora.graph;

import java.sql.ResultSet;
import java.sql.SQLException;




public class Edge {
	private Node origin;
	private Node target;

	protected EdgeID id;

	public Edge(Node origin, Node target) {
		this.origin = origin;
		this.target = target;
		
		id = new EdgeID();
		id.setSource(origin.getSource() + target.getSource());
	}
	/**
	 * Loads an edge from a ResultSet and two nodes - an origin and a target.
	 * @param rs
	 * @throws SQLException
	 */
	public Edge(Node origin, Node target, ResultSet rs) throws SQLException {
		id = new EdgeID(rs);
		this.origin = origin;
		this.target = target;
		// TODO: Write this - if the ResultSet doesn't refer to the same node as the ones put into these parameters, things could get really weird.
//		if (getID().getOriginSource().equals(origin.getSource()) && getID().getTargetSource().equals(target.getSource())) {
//			
//		} else {
//			
//		}
				
		
	}

	public EdgeID getID() { return id; }
	public Node getOrigin() { return origin; }
	public Node getTarget() { return target; }

}
