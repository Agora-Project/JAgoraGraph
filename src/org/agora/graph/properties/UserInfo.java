package org.agora.graph.properties;

import org.agora.graph.ID;
import org.bson.BSONObject;
import org.bson.BasicBSONObject;

public class UserInfo extends Property implements ID {
	String user;
	Integer ID;
	public static String JSONTag = "user";
	
	public UserInfo(BSONObject bsonObject) {
		setSource((String) bsonObject.get(JSON_SOURCE));
		setID((Integer) bsonObject.get(JSON_ID));
	}

	@Override
	public BasicBSONObject getBSON() {
		// TODO Auto-generated method stub
		BasicBSONObject bson = new BasicBSONObject();
		bson.put(JSON_SOURCE, user);
		bson.put(JSON_ID, ID);
		return bson;
	}

	@Override
	public String getSource() {
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public void setSource(String source) {
		user = source;
	}

	@Override
	public Integer getID() {
		// TODO Auto-generated method stub
		return ID;
	}

	@Override
	public void setID(int digit) {
		ID = digit;		
	}

}
