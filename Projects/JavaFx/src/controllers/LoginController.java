package src.controllers;

import java.io.IOException;
import java.net.URL;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import src.Main;

public class LoginController {
  private Stage window_m = null;

  public LoginController() {

  }

  public LoginController(Stage window) {
    window_m = window;
  }

  @FXML
  public void multiplayer(Event e) throws Exception {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(new URL(Main.BASE_FILE_URI + "/src/scenes/main.fxml"));
    try {
      BorderPane graph = loader.<BorderPane>load();
      Scene scene = new Scene(graph, 640, 480);
      scene.getStylesheets().add(Main.BASE_FILE_URI + "/assets/main.css");
      scene.getStylesheets().add(Main.BASE_FILE_URI + "/assets/utility.css");
      window_m.setScene(scene);
      window_m.show();
    } catch (IOException b) {
      System.out.println(b.getMessage());
    }
  }
}
