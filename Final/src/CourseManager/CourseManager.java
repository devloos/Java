package CourseManager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;
import java.util.function.BiPredicate;

import CourseManager.models.academics.Address;
import CourseManager.models.academics.Faculty;
import CourseManager.models.academics.Person;
import CourseManager.models.academics.Student;
import CourseManager.models.education.Course;
import CourseManager.models.education.Session;

public class CourseManager {
  public CourseManager(String dataAbsoluteFolderPath) {
    m_dataAbsoluteFolderPath = dataAbsoluteFolderPath;
    m_students = new ArrayList<Student>();
    m_faculty = new ArrayList<Faculty>();
    m_courses = new ArrayList<Course>();
  }

  public void init() throws InputMismatchException, FileNotFoundException {
    readCourses();
    readFaculty();
    readStudents();
  }

  public void printFacultyReport(FileWriter fout) throws IOException {
    for (Faculty instructor : m_faculty) {
      if (instructor.hasNoSessions()) {
        continue;
      }

      fout.write(
          "----------------------------------------------------------------------------------\n");
      fout.write(instructor.toString() + "\n\n");

      for (Session session : instructor.getSessions()) {
        fout.write(String.format("%-25s %s\n", "COURSE CODE", "COURSE DESCRIPTION"));
        fout.write(String.format("%-25s %s\n", "-----------", "------------------"));
        fout.write(String.format("%-25s %s\n", session.getCourseId(), session.getCourseDescription()));

        fout.write("\n");

        fout.write(String.format("%-40s %s\n", "SESSION ID", "NUMBER OF STUDENTS"));
        fout.write(String.format("%-40s %s\n", "----------", "------------------"));
        fout.write(String.format("%-40s %s\n", session.getId(), session.getNumberOfStudents()));

        fout.write("\n");
      }

      fout.write(
          "----------------------------------------------------------------------------------\n");
    }
  }

  public void printUnscheduledStudentReport(FileWriter fout) throws IOException {
    for (Student student : m_students) {
      if (student.hasNoClasses()) {
        fout.write(
            "------------------------------------------------------------\n");
        fout.write(student.toString() + "\n");
        fout.write("PREFERRED CLASSES: ");
        for (String preferredClasses : student.getCoursePreference()) {
          fout.write(preferredClasses + ", ");
        }
        fout.write("\n");
        fout.write(
            "------------------------------------------------------------\n");
      }
    }
  }

  public void printScheduledStudentsReport(FileWriter fout) throws IOException {
    for (Student student : m_students) {
      if (student.hasNoClasses()) {
        continue;
      }

      fout.write(
          "-------------------------------------------------------------------------------\n");

      fout.write(student.toString());
      fout.write("\n\n");

      for (Session session : student.getSessions()) {
        fout.write(String.format("%-25s %s\n", "COURSE CODE", "COURSE DESCRIPTION"));
        fout.write(String.format("%-25s %s\n", "-----------", "------------------"));
        fout.write(String.format("%-25s %s\n", session.getCourseId(), session.getCourseDescription()));

        fout.write("\n");

        fout.write(String.format("%-40s %s\n", "SESSION ID", "INSTRUCTOR"));
        fout.write(String.format("%-40s %s\n", "----------", "----------"));
        fout.write(String.format("%-40s %s\n", session.getId(), session.getTeacher().getFullName()));

        fout.write("\n");
      }

      fout.write(
          "-------------------------------------------------------------------------------\n");

    }
  }

  public void printCancelledCoursesReport(FileWriter fout) throws IOException {
    for (Course course : m_courses) {
      if (!course.isCancelled()) {
        continue;
      }

      fout.write("----------------------------------------------------------------------------------------\n");
      fout.write(String.format("%-25s %s\n", "COURSE CODE", "COURSE DESCRIPTION"));
      fout.write(String.format("%-25s %s\n", "-----------", "------------------"));
      fout.write(String.format("%-25s %s\n", course.getCode(), course.getDescription()));
      fout.write("----------------------------------------------------------------------------------------\n");
    }
  }

  public void printScheduledCourseReport(FileWriter fout) throws IOException {
    for (Course course : m_courses) {
      if (course.isCancelled()) {
        continue;
      }

      fout.write(
          "-----------------------------------------------------------------------------------------------------------------------------------------\n");
      fout.write(String.format("%-25s %s\n", "COURSE CODE", "COURSE DESCRIPTION"));
      fout.write(String.format("%-25s %s\n", "-----------", "------------------"));
      fout.write(String.format("%-25s %s\n", course.getCode(), course.getDescription()));

      fout.write("\n");

      for (Session session : course.getSessions()) {
        if (session.isCancelled()) {
          continue;
        }

        fout.write(
            String.format("%-40s %-35s %-40s %s\n", "SESSION ID", "INSTRUCTOR", "INSTRUCTOR ID", "NUMBER OF STUDENTS"));
        fout.write(
            String.format("%-40s %-35s %-40s %s\n", "----------", "----------", "-------------", "------------------"));
        fout.write(String.format("%-40s %-35s %-40s %s\n", session.getId(), session.getTeacher().getFullName(),
            session.getTeacher().getId(), session.getNumberOfStudents()));

        fout.write("\n");

        fout.write(String.format("%-35s %s\n", "FULL NAME", "STUDENT ID"));
        fout.write(String.format("%-35s %s\n", "---------", "----------"));
        for (Student student : session.getStudents()) {
          fout.write(String.format("%-35s %s\n", student.getFullName(), student.getId()));
        }

        fout.write("\n");
      }

      fout.write(
          "-----------------------------------------------------------------------------------------------------------------------------------------\n");
    }
  }

  public int getTotalStudents() {
    return m_students.size();
  }

  public int getTotalFaculty() {
    return m_faculty.size();
  }

  public int getTotalCourses() {
    return m_courses.size();
  }

  public int getTotalScheduledSessions() {
    int count = 0;

    for (Course course : m_courses) {
      for (Session session : course.getSessions()) {
        if (!session.isCancelled()) {
          ++count;
        }
      }
    }

    return count;
  }

  public int getTotalUnscheduledCourses() {
    int count = 0;
    for (Course course : m_courses) {
      if (course.isCancelled()) {
        ++count;
      }
    }

    return count;
  }

  public int getTotalStudentsNotScheduled() {
    int count = 0;

    for (Student student : m_students) {
      if (student.getSessions().size() <= 0) {
        ++count;
      }
    }

    return count;
  }

  public void addStudent(Student student) {
    m_students.add(student);
  }

  public Student removeStudentById(UUID id) {
    for (int i = 0; i < m_students.size(); i++) {
      if (m_students.get(i).getId().equals(id)) {
        return m_students.remove(i);
      }
    }

    return null;
  }

  public void addFaculty(Faculty faculty) {
    m_faculty.add(faculty);
  }

  public Faculty removeFacultyById(UUID id) {
    for (int i = 0; i < m_faculty.size(); i++) {
      if (m_faculty.get(i).getId().equals(id)) {
        return m_faculty.remove(i);
      }
    }

    return null;
  }

  public void addCourse(Course course) {
    m_courses.add(course);
  }

  public Course removeCourseByCode(String code) {
    for (int i = 0; i < m_courses.size(); i++) {
      if (m_courses.get(i).getCode().equals(code)) {
        return m_courses.remove(i);
      }
    }

    return null;
  }

  public void sortStudents(BiPredicate<Student, Student> action) {
    if (action == null) {
      return;
    }

    for (int i = 0; i < m_students.size(); i++) {
      int index = i;
      for (int j = i + 1; j < m_students.size(); j++) {
        if (action.test(m_students.get(j), m_students.get(index))) {
          index = j;
        }
      }

      Student temp = m_students.get(i);
      m_students.set(i, m_students.get(index));
      m_students.set(index, temp);
    }
  }

  // one to sort and then schedule
  public void schedule(BiPredicate<Student, Student> action) {
    sortStudents(action);

    for (Student student : m_students) {
      for (String coursePreference : student.getCoursePreference()) {
        for (Course course : m_courses) {
          if (!course.getCode().equals(coursePreference)) {
            continue;
          }
          Session session = course.returnAvailableSession();
          // if no available sessions exist
          if (session == null) {
            Random rd = new Random(System.currentTimeMillis());
            Faculty instructor = m_faculty.get(rd.nextInt(m_faculty.size()));
            session = new Session(UUID.randomUUID(), course.getCode(), course.getDescription(),
                instructor, rd.nextInt(5) + 26, rd.nextInt(4) + 20);
            course.addSession(session);
            instructor.addCourse(course);
            instructor.addSession(session);
          }

          session.addStudent(student);
          student.addSession(session);
        }
      }
    }

    filterSchedule();
  }

  // another to sort with current arrangment of array
  public void schedule() {
    schedule(null);
    return;
  }

  private void filterSchedule() {
    for (Course course : m_courses) {
      if (course.getNumberOfSessions() == 0) {
        course.setCancelled(true);
        continue;
      }

      Session session = course.returnAvailableSession();
      if (session == null) {
        continue;
      }

      if (session.getNumberOfStudents() < session.getMinNumberOfStudents()) {
        session.setCancelled(true);
        for (Student student : session.getStudents()) {
          student.removeSession(session);
        }

        Faculty instructor = session.getTeacher();
        instructor.removeSession(session);

        if (course.getNumberOfSessions() == 1) {
          course.setCancelled(true);
          instructor.removeCourse(course);
        }
      }
    }
  }

  private void readStudents() throws InputMismatchException, FileNotFoundException {
    Scanner fout = new Scanner(new File(m_dataAbsoluteFolderPath + "students.db"));

    while (fout.hasNextLine()) {
      Student student = new Student();
      String[] fields = fout.nextLine().split(",");

      setPersonAttributes(fields, student);

      student.setDateOfBirth(fields[10]);
      student.setGpa(Float.parseFloat(fields[11]));
      student.setEnrollmentDate(fields[12]);

      student.setCoursePreference(m_courses);

      m_students.add(student);
    }

    fout.close();
  }

  private void readFaculty() throws InputMismatchException, FileNotFoundException {
    Scanner fout = new Scanner(new File(m_dataAbsoluteFolderPath + "faculty.db"));

    while (fout.hasNextLine()) {
      Faculty faculty = new Faculty();
      String[] fields = fout.nextLine().split(",");

      setPersonAttributes(fields, faculty);

      faculty.setHireDate(fields[10]);
      faculty.setTenured(Boolean.parseBoolean(fields[11]));

      m_faculty.add(faculty);
    }

    fout.close();
  }

  private void setPersonAttributes(String[] fields, Person person) {
    person.setId(UUID.fromString(fields[0]));
    person.setFirstName(fields[1]);
    person.setMiddleName(fields[2]);
    person.setLastName(fields[3]);
    person.setEmail(fields[4]);
    person.setNumber(fields[5]);

    Address address = person.getAddress();
    address.setStreet(fields[6]);
    address.setCity(fields[7]);
    address.setState(fields[8]);
    address.setZip(Integer.parseInt(fields[9]));
  }

  private void readCourses() throws InputMismatchException, FileNotFoundException {
    Scanner fout = new Scanner(new File(m_dataAbsoluteFolderPath + "courses.db"));

    while (fout.hasNextLine()) {
      Course course = new Course();
      String[] fields = fout.nextLine().split(",");

      course.setId(fields[0]);
      course.setDepartment(fields[1]);
      course.setCode(course.getId() + course.getDepartment());
      course.setDescription(fields[2]);

      m_courses.add(course);
    }

    fout.close();
  }

  private ArrayList<Student> m_students;
  private ArrayList<Faculty> m_faculty;
  private ArrayList<Course> m_courses;
  private String m_dataAbsoluteFolderPath;
}