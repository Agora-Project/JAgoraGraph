package org.agora.graph.factories;

import org.agora.graph.JAgoraNode;

public interface INodeFactory <N extends JAgoraNode> {
  N produce();
}
