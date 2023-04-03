package com.edu.Main.messages.server;

import com.edu.Main.messages.Message;
import com.edu.Main.messages.MessageType;

public class AvatarSelectionStarted extends Message {
  public AvatarSelectionStarted(String username) {
    super(MessageType.AvatarSelectionStarted);
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
