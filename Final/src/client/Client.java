package client;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;

import CourseManager.*;
import CourseManager.models.academics.Student;

public class Client {
  private final static String SCHEDULED_COURSES_TEXT_FILE = "/Users/ca/Development/Java/Final/results/ScheduledCourseSessions.txt";
  private final static String SCHEDULED_STUDENTS_TEXT_FILE = "/Users/ca/Development/Java/Final/results/ScheduledStudents.txt";
  private final static String UNSCHEDULED_COURSES_TEXT_FILE = "/Users/ca/Development/Java/Final/results/UnscheduledCourseSessions.txt";
  private final static String FACULTY_TEXT_FILE = "/Users/ca/Development/Java/Final/results/Faculty.txt";
  private final static String UNSCHEDULED_STUDENTS_TEXT_FILE = "/Users/ca/Development/Java/Final/results/UnscheduledStudents.txt";

  private static void runReport(CourseManager mg) {
    System.out.println("Total Students: " + mg.getTotalStudents());
    System.out.println("Total Faculty: " + mg.getTotalFaculty());
    System.out.println("Total Courses: " + mg.getTotalCourses());
    System.out.println("Total Sessions Scheduled: " + mg.getTotalScheduledSessions());
    System.out.println("Total Courses (not sessions) Unscheduled: " + mg.getTotalUnscheduledCourses());
    System.out.println("Total Students With No Classes: " + mg.getTotalStudentsNotScheduled());

    try {
      FileWriter fin = new FileWriter(UNSCHEDULED_STUDENTS_TEXT_FILE);
      mg.printUnscheduledStudentReport(fin);
      fin.close();

      fin = new FileWriter(SCHEDULED_COURSES_TEXT_FILE);
      mg.printScheduledCourseReport(fin);
      fin.close();

      fin = new FileWriter(SCHEDULED_STUDENTS_TEXT_FILE);
      mg.printScheduledStudentsReport(fin);
      fin.close();

      fin = new FileWriter(UNSCHEDULED_COURSES_TEXT_FILE);
      mg.printCancelledCoursesReport(fin);
      fin.close();

      fin = new FileWriter(FACULTY_TEXT_FILE);
      mg.printFacultyReport(fin);
      fin.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void main(String[] args) {
    CourseManager mg = new CourseManager(args[0]);

    try {
      mg.init();
    } catch (InputMismatchException e) {
      System.err.println("ERROR: INPUT MISMATCH");
    } catch (FileNotFoundException e) {
      System.err.println("ERROR: FILE NOT FOUND");
    }

    mg.schedule((Student s1, Student s2) -> {
      return s1.getGpa() > s2.getGpa();
    });

    runReport(mg);
  }

}
