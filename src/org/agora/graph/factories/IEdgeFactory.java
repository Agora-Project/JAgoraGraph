package org.agora.graph.factories;

import org.agora.graph.JAgoraEdge;

public interface IEdgeFactory <E extends JAgoraEdge> {
  public E produce();
}
