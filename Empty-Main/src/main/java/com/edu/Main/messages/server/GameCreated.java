package com.edu.Main.messages.server;

import com.edu.Main.messages.Message;
import com.edu.Main.messages.MessageType;

public class GameCreated extends Message {
  public GameCreated(int gameLobbyId) {
    super(MessageType.GameCreated);
    this.gameLobbyId = gameLobbyId;
  }

  public int getGameLobbyId() {
    return gameLobbyId;
  }

  public void setGameLobbyId(int gameLobbyId) {
    this.gameLobbyId = gameLobbyId;
  }

  private int gameLobbyId = 0;
}
