package src.utilities;

public class Utility {
  public static String parseButtonEvent(String event) {
    return event.substring(event.indexOf("'", 0) + 1, event.length() - 1);
  }
}
