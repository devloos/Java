package com.edu.Main.messages;

import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Subscribe extends Message {
  private ArrayList<String> channels = null;
  private String username = null;

  public Subscribe(ArrayList<String> channels, String username) {
    this.channels = channels;
    this.username = username;
  }
}
