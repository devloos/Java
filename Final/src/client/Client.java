package client;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

import CourseManager.*;

public class Client {
  public static void main(String[] args) {
    CourseManager mg = new CourseManager(args[0]);

    try {
      mg.init();
    } catch (InputMismatchException e) {

    } catch (FileNotFoundException e) {

    }

    mg.print();
    // mg.schedule()
    // potentially grab stats from course manager
  }
}
