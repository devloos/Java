package src;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import src.controllers.LoginController;

public class Main extends Application {

  public static final String BASE_FILE_URI = "file:////Users/ca/Development/Java/Projects/JavaFx";

  @Override
  public void start(Stage window) throws Exception {
    window.setTitle("Tic Tac Toe");
    FXMLLoader loader = new FXMLLoader();
    loader.setController(new LoginController(window));
    loader.setLocation(new URL(BASE_FILE_URI + "/src/views/login.fxml"));
    try {
      BorderPane vbox = loader.<BorderPane>load();
      Scene scene = new Scene(vbox, 640, 480);
      window.setScene(scene);
      window.show();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}