package client;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

import CourseManager.*;

public class Client {
  public static void main(String[] args) throws InputMismatchException, FileNotFoundException {
    CourseManager mg = new CourseManager(args[0]);
    mg.readData();

    mg.print();
    // mg.schedule()
    // potentially grab stats from course manager
  }
}
