package com.edu.Main.messages.client;

import com.edu.Main.messages.Message;
import com.edu.Main.messages.MessageType;

public class JoinGame extends Message {
  public JoinGame(String username, int gameLobbyId) {
    super(MessageType.JoinGame);
    this.username = username;
    this.gameLobbyId = gameLobbyId;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public int getGameLobbyId() {
    return this.gameLobbyId;
  }

  public void setGameLobbyId(int gameLobbyId) {
    this.gameLobbyId = gameLobbyId;
  }

  private String username = null;
  private int gameLobbyId = 0;
}
