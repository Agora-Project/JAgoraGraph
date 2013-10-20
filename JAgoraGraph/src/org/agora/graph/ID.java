package org.agora.graph;

import java.sql.ResultSet;
import java.sql.SQLException;



public class ID {
	protected String source;
	protected Integer digit;
	
	public ID() {
		
	}
	public ID(ResultSet rs) throws SQLException {
		setSource(rs.getString("source_ID"));
		setNumber(rs.getInt("arg_ID"));
	}
	protected String getSource() {
		return source;
	}
	protected void setSource(String source) {
		this.source = source;
	}
	protected Integer getNumber() {
		return digit;
	}
	protected void setNumber(int digit) {
		this.digit = digit;
	}
	
}
