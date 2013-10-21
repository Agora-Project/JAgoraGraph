package org.agora.graph;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EdgeID {
	private String source;
	public EdgeID() {
		
	}
	public EdgeID(ResultSet rs) throws SQLException {
		setSource(rs.getString("source_ID_attacker") + "+" + rs.getString("source_ID_defender"));
	}

	/**
	 * 
	 */
	protected String getSource() {
		return source;
	}
	protected String getOriginSource() {
		return source.split("+")[0];
	}
	protected String getTargetSource() {
		return source.split("+")[1];
	}
	protected void setSource(String source) {
		this.source = source;
	}
}
