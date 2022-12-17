package CourseManager.models.academics;

import java.util.ArrayList;
import java.util.UUID;

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

  @Override
  public String toString() {
    return super.toString() + m_dateOfBirth + "," + Float.toString(m_gpa) + "," + m_enrollmentDate;
  }

  private String m_dateOfBirth;
  private float m_gpa;
  private String m_enrollmentDate;
  private ArrayList<Session> m_sessions;
}
