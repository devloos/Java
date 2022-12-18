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
    for (Student student : m_students) {
      System.out.println(student);
    }

    System.out.println();

    for (Faculty faculty : m_faculty) {
      System.out.println(faculty);
    }

    System.out.println();

    for (Course course : m_courses) {
      System.out.println(course);
    }
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
    return;
  }

  // another to sort with current arrangment of array
  public void schedule() {
    return;
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