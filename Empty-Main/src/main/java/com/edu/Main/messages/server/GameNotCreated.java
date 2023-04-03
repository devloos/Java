package com.edu.Main.messages.server;

import com.edu.Main.messages.Message;
import com.edu.Main.messages.MessageType;

public class GameNotCreated extends Message {
  public GameNotCreated() {
    super(MessageType.GameNotCreated);
  }
}
