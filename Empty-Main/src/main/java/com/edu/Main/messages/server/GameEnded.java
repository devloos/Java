package com.edu.Main.messages.server;

import com.edu.Main.messages.GameResult;
import com.edu.Main.messages.Message;
import com.edu.Main.messages.MessageType;

public class GameEnded extends Message {
  public GameEnded(GameResult result) {
    super(MessageType.GameEnded);
    this.result = result;
  }

  public GameResult getGameResult() {
    return result;
  }

  public void setGameResult(GameResult result) {
    this.result = result;
  }

  private GameResult result = null;
}
