package com.edu.Main.messages.server;

import com.edu.Main.messages.Message;
import com.edu.Main.messages.MessageType;

public class GameJoined extends Message {
  public GameJoined(String hostUsername) {
    super(MessageType.GameJoined);
    this.hostUsername = hostUsername;
  }

  public String getHostUsername() {
    return hostUsername;
  }

  public void setHostUsername(String hostUsername) {
    this.hostUsername = hostUsername;
  }

  private String hostUsername = null;
}
