package com.edu.Main.messages.client;

import com.edu.Main.messages.Message;
import com.edu.Main.messages.MessageType;

public class PlayerReady extends Message {
  public PlayerReady() {
    super(MessageType.PlayerReady);
  }
}
