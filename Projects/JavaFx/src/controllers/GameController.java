package src.controllers;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class GameController {
  public Stage window_m = null;
  public String gameMode_m = null;
  public ArrayList<ArrayList<Player>> board_m = null;

  public enum Player {
    PLAYER_X,
    PLAYER_Y
  };

  public Player currPlayer_m = Player.PLAYER_X;

  public GameController() {
  }

  public GameController(Stage window, String gameMode) {
    window_m = window;
    gameMode_m = gameMode;
    board_m = new ArrayList<ArrayList<Player>>();
    for (int i = 0; i < 3; ++i) {
      board_m.add(new ArrayList<Player>());
      for (int j = 0; j < 3; ++j) {
        board_m.get(i).add(null);
      }
    }
  }

  @FXML
  public void clickedGrid(MouseEvent e) {
    Region box = (Region) e.getPickResult().getIntersectedNode();
    Integer col = GridPane.getColumnIndex(box);
    Integer row = GridPane.getRowIndex(box);

    // not an index
    if (col == null && row == null) {
      return;
    }

    // Board already set
    if (board_m.get(row).get(col) != null) {
      return;
    }

    // set player
    switch (currPlayer_m) {
      case PLAYER_X: {
        box.getStyleClass().clear();
        box.setStyle(null);
        box.setStyle("-fx-background-color: darkgoldenrod");
        board_m.get(row).set(col, Player.PLAYER_X);
        currPlayer_m = Player.PLAYER_Y;
        break;
      }

      case PLAYER_Y: {
        box.getStyleClass().clear();
        box.setStyle(null);
        box.setStyle("-fx-background-color: forestgreen");
        board_m.get(row).set(col, Player.PLAYER_Y);
        currPlayer_m = Player.PLAYER_X;
        break;
      }
    }

    if (playerWon()) {
      GridPane grid = (GridPane) e.getSource();
      ObservableList<Node> nodes = grid.getChildren();
      for (int i = 0; i < nodes.size(); ++i) {
        box = (Region) nodes.get(i);
        box.getStyleClass().clear();
        box.setStyle(null);
        box.getStyleClass().add("box");
      }
    }
  }
}
