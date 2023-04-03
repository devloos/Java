package com.edu.Main.messages.client;

import com.edu.Main.messages.Message;
import com.edu.Main.messages.MessageType;

public class CreateGame extends Message {
  public CreateGame(String username) {
    super(MessageType.CreateGame);
    this.username = username;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  private String username = null;
}
