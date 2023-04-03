package com.edu.Main.messages.client;

import com.edu.Main.messages.Message;
import com.edu.Main.messages.MessageType;

public class BackToMainMenu extends Message {
  public BackToMainMenu() {
    super(MessageType.BackToMainMenu);
  }
}
