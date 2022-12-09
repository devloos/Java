package CourseScheduler.models.people;

import java.util.UUID;

public class Student extends Person {
  public Student(UUID id, String firstName, String middleName, String lastName, String email, String number,
      Address address, String dateOfBirth, float gpa, String enrollmentDate) {
    super(id, firstName, middleName, lastName, email, number, address);
    m_dateOfBirth = dateOfBirth;
    m_gpa = gpa;
    m_enrollmentDate = enrollmentDate;
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

  private String m_dateOfBirth;
  private float m_gpa;
  private String m_enrollmentDate;
  // TODO: add vector of sessions
}
