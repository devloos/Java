package src;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import src.controllers.LoginController;

public class Main extends Application {

  public static final String BASE_FILE_URI = "file:////Users/ca/Development/Java/Projects/JavaFx";

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("My First JavaFX App");
    FXMLLoader loader = new FXMLLoader();
    loader.setController(new LoginController());
    loader.setLocation(new URL(BASE_FILE_URI + "/src/scenes/login.fxml"));
    try {
      VBox vbox = loader.<VBox>load();
      Scene scene = new Scene(vbox, 640, 480);
      scene.getStylesheets().add(BASE_FILE_URI + "/assets/styles.css");
      primaryStage.setScene(scene);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}