package org.agora.graph.factories;

import org.agora.graph.JAgoraEdge;

/**
 * Extend this to return a different class.
 */
public class JAgoraEdgeFactory implements IEdgeFactory<JAgoraEdge> {
  public JAgoraEdge produce() {
    return new JAgoraEdge();
  }
}
