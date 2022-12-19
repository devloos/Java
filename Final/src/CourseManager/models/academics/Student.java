package CourseManager.models.academics;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import CourseManager.models.education.Course;
import CourseManager.models.education.Session;

public class Student extends Person {
  public Student() {
    super();
    m_sessions = new ArrayList<Session>();
  }

  public Student(UUID id, String firstName, String middleName, String lastName, String email, String number,
      Address address, String dateOfBirth, float gpa, String enrollmentDate) {
    super(id, firstName, middleName, lastName, email, number, address);
    m_dateOfBirth = dateOfBirth;
    m_gpa = gpa;
    m_enrollmentDate = enrollmentDate;
    m_sessions = new ArrayList<Session>();
  }

  public String getDateOfBirth() {
    return m_dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    m_dateOfBirth = dateOfBirth;
  }

  public float getGpa() {
    return m_gpa;
  }

  public void setGpa(float gpa) {
    m_gpa = gpa;
  }

  public String getEnrollmentDate() {
    return m_enrollmentDate;
  }

  public void setEnrollmentDate(String enrollmentDate) {
    m_enrollmentDate = enrollmentDate;
  }

  public ArrayList<Session> getSessions() {
    return m_sessions;
  }

  public void addSession(Session session) {
    m_sessions.add(session);
  }

  public boolean removeSession(Session session) {
    return m_sessions.remove(session);
  }

  public void setCoursePreference(ArrayList<Course> courses) {
    int i = 0;
    Random delimeter = new Random(System.currentTimeMillis());
    for (Course course : courses) {
      if (i < MAX_PREFERRED_COURSES && delimeter.nextBoolean()) {
        m_preferredCoursesByCode[i++] = course.getCode();
      }
    }
  }

  public String[] getCoursePreference() {
    return m_preferredCoursesByCode;
  }

  public boolean hasNoClasses() {
    return m_sessions.isEmpty();
  }

  @Override
  public String toString() {
    return super.toString() + "DOB: " + m_dateOfBirth + "\nGPA: " + Float.toString(m_gpa) + "\nENROLLMENT DATE: "
        + m_enrollmentDate + "\n";
  }

  final private static int MAX_PREFERRED_COURSES = 4;

  private String m_dateOfBirth;
  private float m_gpa;
  private String m_enrollmentDate;
  private ArrayList<Session> m_sessions;
  private String[] m_preferredCoursesByCode = new String[MAX_PREFERRED_COURSES];
}
