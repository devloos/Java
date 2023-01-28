package src;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LoginController {
  public Label label1 = null;
  public Label label2 = null;
  public Button btn = null;

  @FXML
  public void clicked(Event e) {
    label1.setText("NEW TEXT");
    label2.setText("LABEL 2 NEW TEXT");
  }
}
