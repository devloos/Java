package client;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;

import CourseManager.*;
import CourseManager.models.academics.Student;

public class Client {
  private final static String ABSOLUTE_REPORT_FOLDER_PATH = "/Users/ca/Development/Java/Final/results";

  private final static int GPA_ASCENDING = 0;
  private final static int GPA_DESCENDING = 1;
  private final static int LAST_NAME_ASCENDING = 2;
  private final static int LAST_NAME_DESCENDING = 3;

  // since the project required running all reports here is an example usage on it
  // this should be flexible to fit most needs, in other words if you just needed
  // scheduled courses report you can do just that.
  private static void runReport(CourseManager mg) {
    if (mg == null) {
      return;
    }

    // example of getting specific reports
    System.out.println("Total Students: " + mg.getTotalStudents());
    System.out.println("Total Faculty: " + mg.getTotalFaculty());
    System.out.println("Total Courses: " + mg.getTotalCourses());
    System.out.println("Total Sessions Scheduled: " + mg.getTotalScheduledSessions());
    System.out.println("Total Courses (not sessions) Unscheduled: " + mg.getTotalUnscheduledCourses());
    System.out.println("Total Students With No Classes: " + mg.getTotalStudentsNotScheduled());

    FileWriter fin = null;
    try {
      fin = new FileWriter(ABSOLUTE_REPORT_FOLDER_PATH + "/UnscheduledStudents.txt");
      mg.printUnscheduledStudentReport(fin);
      fin.close();

      fin = new FileWriter(ABSOLUTE_REPORT_FOLDER_PATH + "/ScheduledCourseSession.txt");
      mg.printScheduledCourseReport(fin);
      fin.close();

      fin = new FileWriter(ABSOLUTE_REPORT_FOLDER_PATH + "/ScheduledStudents.txt");
      mg.printScheduledStudentsReport(fin);
      fin.close();

      fin = new FileWriter(ABSOLUTE_REPORT_FOLDER_PATH + "/UnscheduledCourseSessions.txt");
      mg.printCancelledCoursesReport(fin);
      fin.close();

      fin = new FileWriter(ABSOLUTE_REPORT_FOLDER_PATH + "/Faculty.txt");
      mg.printFacultyReport(fin);
      fin.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void main(String[] args) {
    CourseManager mg = new CourseManager(args[0]);

    // example initialization of the library
    try {
      mg.init();
    } catch (InputMismatchException e) {
      System.err.println("ERROR: INPUT MISMATCH");
    } catch (FileNotFoundException e) {
      System.err.println("ERROR: FILE NOT FOUND");
    }

    Random rng = new Random(System.currentTimeMillis());

    // Example of different scheduling algorithms
    switch (rng.nextInt(4)) {
      case GPA_ASCENDING: {
        mg.schedule((Student s1, Student s2) -> {
          return s1.getGpa() < s2.getGpa();
        });
        break;
      }
      case GPA_DESCENDING: {
        mg.schedule((Student s1, Student s2) -> {
          return s1.getGpa() > s2.getGpa();
        });
        break;
      }
      case LAST_NAME_ASCENDING: {
        mg.schedule((Student s1, Student s2) -> {
          return (s1.getLastName().compareTo(s2.getLastName()) < 0) ? true : false;
        });
        break;
      }
      case LAST_NAME_DESCENDING: {
        mg.schedule((Student s1, Student s2) -> {
          return (s1.getLastName().compareTo(s2.getLastName()) > 0) ? true : false;
        });
        break;
      }
    }

    runReport(mg);
  }

}
