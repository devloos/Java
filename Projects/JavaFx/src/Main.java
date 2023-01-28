package src;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("My First JavaFX App");
    FXMLLoader loader = new FXMLLoader();
    loader.setController(new LoginController());
    loader.setLocation(new URL("file:////Users/ca/Development/Java/Projects/JavaFx/src/fxml/login-index.fxml"));
    try {
      VBox vbox = loader.<VBox>load();
      Scene scene = new Scene(vbox);
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