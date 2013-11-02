package org.agora.graph.properties;

import java.util.Date;

import org.bson.BSONObject;
import org.bson.BasicBSONObject;

public class PostInfo extends Property {
	private UserInfo user;
	private Date date;
	public static String JSONTag = "post";
	
	
	public PostInfo(BSONObject bson) {
		user = new UserInfo((BSONObject)bson.get(UserInfo.JSONTag));
		date = (Date)bson.get("date");
	}
	public PostInfo(UserInfo user, Date date) {
		
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public BasicBSONObject getBSON() {
		BasicBSONObject bson = new BasicBSONObject();
		bson.put(UserInfo.JSONTag, user.getBSON());
		bson.put("date", date);
		return bson;
	}


}
