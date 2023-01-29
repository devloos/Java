package src.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class GameController {
  public Stage window_m = null;
  public String gameMode_m = null;

  public GameController() {
  }

  public GameController(Stage window, String gameMode) {
    window_m = window;
    gameMode_m = gameMode;
  }

  @FXML
  public void clicked(Event e) {
    System.out.println(e);
  }
}
