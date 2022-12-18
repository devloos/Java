package client;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

import CourseManager.*;
import CourseManager.models.academics.Student;

public class Client {
  public static void main(String[] args) {
    CourseManager mg = new CourseManager(args[0]);

    try {
      mg.init();
    } catch (InputMismatchException e) {

    } catch (FileNotFoundException e) {

    }

    mg.sortStudents((Student s1, Student s2) -> {
      return s1.getGpa() < s2.getGpa();
    });

    mg.print();
    // mg.schedule(() -> {
    // });
    // potentially grab stats from course manager
  }
}
