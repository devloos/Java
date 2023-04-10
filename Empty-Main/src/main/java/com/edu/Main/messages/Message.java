package com.edu.Main.messages;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Message implements Serializable {
  private String type = this.getClass().getName();
  private String message = null;

  public Message(String message) {
    this.message = message;
  }
}