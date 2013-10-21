package org.agora.graph;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Node {
	protected ID id;

	private List<Edge> edges;

	
	protected Node(String source, Integer ID) {
		id = new ID();
		id.setSource(source);
		id.setNumber(ID);
	}
	
	protected Node(ResultSet rs) throws SQLException {
		id = new ID(rs);
	}

	/**
	 * Adds an edge to the node
	 * @param att
	 */
	protected void addEdge(Edge arg) {
		edges.add(arg);
	}
	public int getNumber() { return id.getNumber(); }
	public String getSource() { return id.getSource(); }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id.getSource() == null || id.getNumber() == null) ? 0 : id.hashCode());
		return result;
	}
	public List<Edge> getEdges() {
		return edges;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
