package org.agora.graph.factories;

import org.agora.graph.JAgoraGraph;

public class JAgoraGraphFactory implements IGraphFactory<JAgoraGraph> {
  public JAgoraGraph produce() {
    return new JAgoraGraph();
  }
}
