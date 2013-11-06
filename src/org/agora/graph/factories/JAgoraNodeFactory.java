package org.agora.graph.factories;

import org.agora.graph.JAgoraNode;

public class JAgoraNodeFactory implements INodeFactory<JAgoraNode> {
  public JAgoraNode produce() {
    return new JAgoraNode();
  }
}
