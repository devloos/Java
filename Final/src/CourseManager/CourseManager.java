package CourseManager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;
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
  public CourseManager(String absoluteFolderPath) {
    m_absoluteFolderPath = absoluteFolderPath;
    m_students = new ArrayList<Student>();
    m_faculty = new ArrayList<Faculty>();
    m_courses = new ArrayList<Course>();
  }

  public void init() throws InputMismatchException, FileNotFoundException {
    readCourses();
    readFaculty();
    readStudents();
  }

  public void print() {
    printScheduledCourseReport();
    printCancelledCoursesReport();
    printScheduledStudentsReport();
    printUnscheduledStudentReport();
  }

  public void printUnscheduledStudentReport() {
    for (Student student : m_students) {
      if (student.hasNoClasses()) {
        System.out.println(
            "------------------------------------------------------------");
        System.out.println(student);
        System.out.print("PREFERRED CLASSES: ");
        for (String preferredClasses : student.getCoursePreference()) {
          System.out.print(preferredClasses + ", ");
        }
        System.out.println();
        System.out.println(
            "------------------------------------------------------------");
      }
    }
  }

  public void printScheduledStudentsReport() {
    for (Student student : m_students) {
      if (student.hasNoClasses()) {
        continue;
      }

      System.out.println(
          "-------------------------------------------------------------------------------");

      System.out.println(student);
      System.out.println();

      for (Session session : student.getSessions()) {
        System.out.println("COURSE CODE\t\t\t\tCOURSE DESCRIPTION");
        System.out.println("---------\t\t\t\t------------------");
        System.out.println(session.getCourseId() + "\t\t\t\t\t" + session.getCourseDescription());
        System.out.println();
        System.out.println("SESSION ID\t\t\t\tINSTRUCTOR");
        System.out.println("----------\t\t\t\t----------");
        System.out.println(session.getId() + "\t" + session.getTeacher().getFullName());
        System.out.println();
      }

      System.out.println(
          "-------------------------------------------------------------------------------");

    }
  }

  public void printCancelledCoursesReport() {
    for (Course course : m_courses) {
      if (!course.isCancelled()) {
        continue;
      }

      System.out.println("----------------------------------------------------------------------------------------");
      System.out.println("COURSE CODE\t\t\tCOURSE DESCRIPTION");
      System.out.println("---------\t\t\t------------------");
      System.out.println(course.getCode() + "\t\t\t\t" + course.getDescription());
      System.out.println("----------------------------------------------------------------------------------------");
    }
  }

  public void printScheduledCourseReport() {
    for (Course course : m_courses) {
      if (course.isCancelled()) {
        continue;
      }

      System.out.println(
          "-----------------------------------------------------------------------------------------------------------------------------------------");
      System.out.println("COURSE CODE\t\t\tCOURSE DESCRIPTION");
      System.out.println("---------\t\t\t------------------");
      System.out.println(course.getCode() + "\t\t\t\t" + course.getDescription());

      System.out.println();

      for (Session session : course.getSessions()) {
        if (session.isCancelled()) {
          continue;
        }

        System.out.println("SESSION ID\t\t\t\tINSTRUCTOR\t\t\tINSTRUCTOR ID\t\t\t\tNUMBER OF STUDENTS");
        System.out.println("----------\t\t\t\t----------\t\t\t-------------\t\t\t\t------------------");
        System.out.println(session.getId() + "\t" + session.getTeacher().getFullName() + "\t\t"
            + session.getTeacher().getId() + "\t\t" + session.getNumberOfStudents());

        System.out.println();

        System.out.println("FULL NAME\t\t\t\t\tSTUDENT ID");
        System.out.println("---------\t\t\t\t\t----------");
        for (Student student : session.getStudents()) {
          System.out.println(student.getFullName() + "\t\t\t\t" + student.getId());
        }
      }

      System.out.println(
          "-----------------------------------------------------------------------------------------------------------------------------------------");
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
          if (course.getCode().equals(coursePreference)) {
            Session session = course.returnAvailableSession();
            // if no available sessions exist
            if (session == null) {
              session = new Session(UUID.randomUUID(), course.getCode(), course.getDescription(),
                  m_faculty.get(0), 10, 4);
              course.addSession(session);
            }

            session.addStudent(student);
            student.addSession(session);
            m_faculty.get(0).addCourse(course);
            m_faculty.get(0).addSession(session);
          }
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
    Scanner fin = new Scanner(new File(m_absoluteFolderPath + "students.db"));

    while (fin.hasNextLine()) {
      Student student = new Student();
      String[] fields = fin.nextLine().split(",");

      setPersonAttributes(fields, student);

      student.setDateOfBirth(fields[10]);
      student.setGpa(Float.parseFloat(fields[11]));
      student.setEnrollmentDate(fields[12]);

      student.setCoursePreference(m_courses);

      m_students.add(student);
    }

    fin.close();
  }

  private void readFaculty() throws InputMismatchException, FileNotFoundException {
    Scanner fin = new Scanner(new File(m_absoluteFolderPath + "faculty.db"));

    while (fin.hasNextLine()) {
      Faculty faculty = new Faculty();
      String[] fields = fin.nextLine().split(",");

      setPersonAttributes(fields, faculty);

      faculty.setHireDate(fields[10]);
      faculty.setTenured(Boolean.parseBoolean(fields[11]));

      m_faculty.add(faculty);
    }

    fin.close();
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
    Scanner fin = new Scanner(new File(m_absoluteFolderPath + "courses.db"));

    while (fin.hasNextLine()) {
      Course course = new Course();
      String[] fields = fin.nextLine().split(",");

      course.setId(fields[0]);
      course.setDepartment(fields[1]);
      course.setCode(course.getId() + course.getDepartment());
      course.setDescription(fields[2]);

      m_courses.add(course);
    }

    fin.close();
  }

  private ArrayList<Student> m_students;
  private ArrayList<Faculty> m_faculty;
  private ArrayList<Course> m_courses;
  private String m_absoluteFolderPath;
}