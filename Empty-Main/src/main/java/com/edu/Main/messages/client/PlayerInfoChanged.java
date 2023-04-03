package com.edu.Main.messages.client;

import com.edu.Main.messages.Message;
import com.edu.Main.messages.MessageType;

public class PlayerInfoChanged extends Message {
  public PlayerInfoChanged(String avatarSelected) {
    super(MessageType.PlayerInfoChanged);
    this.avatarSelected = avatarSelected;
  }

  public String getAvatarSelected() {
    return avatarSelected;
  }

  public void setAvatarSelected(String avatarSelected) {
    this.avatarSelected = avatarSelected;
  }

  private String avatarSelected = null;
}
