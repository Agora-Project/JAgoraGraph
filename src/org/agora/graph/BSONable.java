package org.agora.graph;

import org.bson.BSONObject;

import com.sun.istack.internal.NotNull;

public interface BSONable {

	/**
	 * The standard JSON tag for this type of object - change for each class
	 */
	@NotNull
	public static String JSONTag = null;
	/**
	 * Gets this object turned into a BSONObject
	 * @return
	 */
	public BSONObject getBSON();


}
