package com.edu.Main.messages.server;

import com.edu.Main.messages.Message;
import com.edu.Main.messages.MessageType;

public class GameNotJoinable extends Message {
  public GameNotJoinable() {
    super(MessageType.GameNotJoinable);
  }
}
