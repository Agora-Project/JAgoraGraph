package org.agora.graph;

public interface ID {

	/**
	 * The standard JSON tag for an object's source (username, site, etc)
	 */
	final static String JSON_SOURCE = "source";
	/**
	 * The standard JSON tag for an object's identification number
	 */
	final static String JSON_ID = "id";
	
	/**
	 * Gets the source for this element (usually a URI)
	 * @return the element's source information
	 */
	public String getSource();
	/**
	 * Sets the source information for this element
	 * @param source
	 */
	public void setSource(String source);
	/**
	 * Gets the identification number for this element
	 * @return
	 */
	public Integer getID();
	/**
	 * Sets the ID number for this element
	 * @param digit
	 */
	public void setID(int digit);
}
