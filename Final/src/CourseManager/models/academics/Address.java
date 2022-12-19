package CourseManager.models.academics;

public class Address {
  public Address() {
  }

  public Address(String street, String city, String state, int zip) {
    m_street = street;
    m_city = city;
    m_state = state;
    m_zip = zip;
  }

  public String getStreet() {
    return m_street;
  }

  public void setStreet(String street) {
    m_street = street;
  }

  public String getCity() {
    return m_city;
  }

  public void setCity(String city) {
    m_city = city;
  }

  public String getState() {
    return m_state;
  }

  public void setState(String state) {
    m_state = state;
  }

  public int getZip() {
    return m_zip;
  }

  public void setZip(int zip) {
    m_zip = zip;
  }

  @Override
  public String toString() {
    return "ADDRESS: " + m_street + " " + m_city + " " + m_state + " " + Integer.toString(m_zip);
  }

  private String m_street;
  private String m_city;
  private String m_state;
  private int m_zip;
}
