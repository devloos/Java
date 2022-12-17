package CourseManager.models.academics;

import java.util.UUID;

abstract public class Person {
  public Person() {
    m_address = new Address();
  }

  public Person(UUID id, String firstName, String middleName, String lastName, String email, String number,
      Address address) {
    m_id = id;
    m_firstName = firstName;
    m_middleName = middleName;
    m_lastName = lastName;
    m_email = email;
    m_number = number;
    m_address = address;
  }

  public UUID getId() {
    return m_id;
  }

  public void setId(UUID id) {
    m_id = id;
  }

  public String getFirstName() {
    return m_firstName;
  }

  public void setFirstName(String firstName) {
    m_firstName = firstName;
  }

  public String getMiddleName() {
    return m_middleName;
  }

  public void setMiddleName(String middleName) {
    m_middleName = middleName;
  }

  public String getLastName() {
    return m_lastName;
  }

  public void setLastName(String lastName) {
    m_lastName = lastName;
  }

  public String getEmail() {
    return m_email;
  }

  public void setEmail(String email) {
    m_email = email;
  }

  public String getNumber() {
    return m_number;
  }

  public void setNumber(String number) {
    m_number = number;
  }

  public Address getAddress() {
    return m_address;
  }

  // todo implement clonable
  public void setAddress(Address address) {
    m_address = address;
  }

  @Override
  public String toString() {
    return m_id.toString() + "," + m_firstName + "," + m_middleName + "," + m_lastName + "," + m_email + "," + m_number
        + "," + m_address.toString();
  }

  protected UUID m_id;
  protected String m_firstName;
  protected String m_middleName;
  protected String m_lastName;
  protected String m_email;
  protected String m_number;
  protected Address m_address;
}
