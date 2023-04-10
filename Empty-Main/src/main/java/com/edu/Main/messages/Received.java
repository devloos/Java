package com.edu.Main.messages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Received extends Message {
  private boolean success = false;

  public Received(boolean success, String message) {
    super(message);
    this.success = success;
  }
}
