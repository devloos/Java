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
      System.err.println("ERROR: INPUT MISMATCH");
    } catch (FileNotFoundException e) {
      System.err.println("ERROR: FILE NOT FOUND");
    }

    // mg.schedule((Student s1, Student s2) -> {
    // return s1.getGpa() < s2.getGpa();
    // });
    mg.schedule();

    System.out.println("Total Students: " + mg.getTotalStudents());
    System.out.println("Total Faculty: " + mg.getTotalFaculty());
    System.out.println("Total Courses: " + mg.getTotalCourses());
    System.out.println("Total Sessions Scheduled: " + mg.getTotalScheduledSessions());
    System.out.println("Total Courses (not sessions) Unscheduled: " + mg.getTotalUnscheduledCourses());
    System.out.println("Total Students With No Classes: " + mg.getTotalStudentsNotScheduled());

    System.out.println();
    mg.print();
  }
}
