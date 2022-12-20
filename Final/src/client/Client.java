/**
 * @author Carlos Aguilera
 * @date 12-19-22
 * @student_id 1152562
 * @brief This program stress tests my Course Manager library
 * the course manager library handles managing students, staff, courses and sessions
 * the purpose of the library is to be flexible in the way that the sessions are
 * scheduled. The way I accomplished this was by the use of lambdas or bipredicates
 * to allow any user to sort which ever way they want and schedule sequentially from
 * there. I also allowed for flexible report analysis by letting users run reports 
 * separately or in a batch, I also made the library robust and used the concept of
 * proper handling exceptions and allowed the user to handle most exceptions that
 * made sense for them to handle
 */
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

  enum Sorting {
    GPA_ASCENDING,
    GPA_DESCENDING,
    LAST_NAME_ASCENDING,
    LAST_NAME_DESCENDING
  }

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

    FileWriter fout = null;
    try {
      fout = new FileWriter(ABSOLUTE_REPORT_FOLDER_PATH + "/UnscheduledStudents.txt");
      mg.printUnscheduledStudentReport(fout);
      fout.close();

      fout = new FileWriter(ABSOLUTE_REPORT_FOLDER_PATH + "/ScheduledCourseSession.txt");
      mg.printScheduledCourseReport(fout);
      fout.close();

      fout = new FileWriter(ABSOLUTE_REPORT_FOLDER_PATH + "/ScheduledStudents.txt");
      mg.printScheduledStudentsReport(fout);
      fout.close();

      fout = new FileWriter(ABSOLUTE_REPORT_FOLDER_PATH + "/UnscheduledCourseSessions.txt");
      mg.printCancelledCoursesReport(fout);
      fout.close();

      fout = new FileWriter(ABSOLUTE_REPORT_FOLDER_PATH + "/Faculty.txt");
      mg.printFacultyReport(fout);
      fout.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  private static void demoAlgorithm(CourseManager mg, Sorting type) {
    if (mg == null) {
      return;
    }

    try {
      FileWriter fout = new FileWriter(ABSOLUTE_REPORT_FOLDER_PATH + "/demo-for-homi.txt");
      for (Student student : mg.getStudents()) {
        fout.write(student.toString() + "\n\n");
      }
      fout.close();
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

    Sorting rng = Sorting.values()[(new Random(System.currentTimeMillis()).nextInt(4))];

    // Example of different scheduling algorithms
    switch (rng) {
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
    demoAlgorithm(mg, rng);
  }

}
