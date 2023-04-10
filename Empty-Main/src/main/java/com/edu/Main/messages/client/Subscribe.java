package com.edu.Main.messages.client;

import java.util.ArrayList;

import com.edu.Main.messages.Message;
import com.edu.Main.messages.MessageType;

import lombok.Getter;

@Getter
public class Subscribe extends Message {
  private ArrayList<String> channels = null;

  public Subscribe(ArrayList<String> channels) {
    super(MessageType.Subscribe);
    this.channels = channels;
  }
}
