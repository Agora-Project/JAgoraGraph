package org.agora.graph.factories;

import org.agora.graph.JAgoraGraph;

public interface IGraphFactory <G extends JAgoraGraph> {
  G produce();
}
