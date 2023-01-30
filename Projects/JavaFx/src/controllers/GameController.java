package src.controllers;

import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
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
  public void clickedGrid(MouseEvent e) {
    Node node = e.getPickResult().getIntersectedNode();
    Integer col = GridPane.getColumnIndex(node);
    Integer row = GridPane.getRowIndex(node);
    if (col != null && row != null) {
      System.out.println("Mouse clicked cell: " + col + " And: " + row);
    }
  }
}
