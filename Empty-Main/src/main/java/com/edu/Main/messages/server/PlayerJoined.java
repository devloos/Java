package com.edu.Main.messages.server;

import com.edu.Main.messages.Message;
import com.edu.Main.messages.MessageType;

public class PlayerJoined extends Message {
  public PlayerJoined(String username) {
    super(MessageType.PlayerJoined);
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  private String username = null;
}
