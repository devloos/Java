package com.edu.Main.messages.client;

import com.edu.Main.messages.Message;
import com.edu.Main.messages.MessageType;

public class SubscribeGameList extends Message {
  public SubscribeGameList() {
    super(MessageType.SubscribeGameList);
  }
}
