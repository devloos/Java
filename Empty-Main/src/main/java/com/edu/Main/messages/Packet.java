package com.edu.Main.messages;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Packet<T extends Message> implements Serializable {
  private T message;
  private String channel;
}
