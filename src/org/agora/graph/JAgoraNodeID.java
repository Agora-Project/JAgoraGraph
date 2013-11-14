package org.agora.graph;

import java.sql.ResultSet;
import java.sql.SQLException;



public class JAgoraNodeID {
	protected String source;
	protected Integer localID;
	
	public JAgoraNodeID() {
	  source = null;
	  localID = null;
	}
	
	public JAgoraNodeID(String source, Integer localID) {
	  this.source = source;
	  this.localID = localID;
	}
	
	public JAgoraNodeID(ResultSet rs) throws SQLException {
		setSource(rs.getString("source_ID"));
		setLocalID(rs.getInt("arg_ID"));
	}
	
	
	
	public String getSource() { return source; }
	public void setSource(String source) { this.source = source; }
	public Integer getLocalID() { return localID; }
	public void setLocalID(int digit) { this.localID = digit; }
	
}
