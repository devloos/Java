package src;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("My First JavaFX App");

    Label label = new Label("THIS IS A LABEL");
    Scene scene = new Scene(label, 640, 480);
    primaryStage.setScene(scene);

    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}