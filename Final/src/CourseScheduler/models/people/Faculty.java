package CourseScheduler.models.people;

import java.util.UUID;

public class Faculty extends Person {
  public Faculty(UUID id, String firstName, String middleName, String lastName, String email, String number,
      Address address, String hireDate, boolean tenured) {
    super(id, firstName, middleName, lastName, email, number, address);
    m_hireDate = hireDate;
    m_tenured = tenured;
  }

  public String getHireDate() {
    return m_hireDate;
  }

  public void setHireDate(String hireDate) {
    m_hireDate = hireDate;
  }

  public boolean isTenured() {
    return m_tenured;
  }

  public void setTenured(boolean tenured) {
    m_tenured = tenured;
  }

  private String m_hireDate;
  private boolean m_tenured;
}
