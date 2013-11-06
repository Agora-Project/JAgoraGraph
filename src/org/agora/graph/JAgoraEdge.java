package org.agora.graph;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JAgoraEdge {
  protected JAgoraNode origin;
  protected JAgoraNode target;

	protected JAgoraEdgeID id;
	
	// TODO: need o get this from DB.
	protected String posterName;
	protected int posterID;

	public JAgoraEdge() {}
	
	public JAgoraEdge(JAgoraNode origin, JAgoraNode target) {
	  construct(origin, target);
	}
	
	public void construct(JAgoraNode origin, JAgoraNode target) {
    this.origin = origin;
    this.target = target;
    
    id = new JAgoraEdgeID();
    id.setSource(origin.getSource() + target.getSource());
  }
	
	
	/**
	 * Loads an edge from a ResultSet and two nodes - an origin and a target.
	 * @param rs
	 * @throws SQLException
	 */
	public JAgoraEdge(JAgoraNode origin, JAgoraNode target, ResultSet rs) throws SQLException {
		id = new JAgoraEdgeID(rs);
		this.origin = origin;
		this.target = target;
		// TODO: Write this - if the ResultSet doesn't refer to the same node as the ones put into these parameters, things could get really weird.
//		if (getID().getOriginSource().equals(origin.getSource()) && getID().getTargetSource().equals(target.getSource())) {
//			
//		} else {
//			
//		}
				
		
	}

	public JAgoraEdgeID getID() { return id; }
	public JAgoraNode getOrigin() { return origin; }
	public JAgoraNode getTarget() { return target; }

}
