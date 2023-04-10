package com.edu.Main.messages;

import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Subscribe extends Message {
  private ArrayList<String> channels = null;

  public Subscribe(ArrayList<String> channels) {
    this.channels = channels;
  }
}
