package CourseScheduler.models.education;

import java.util.ArrayList;

public class Course {
  public Course(String department, String code, String description) {
    m_id = department + code;
    m_department = department;
    m_code = code;
    m_description = description;
    m_sessions = new ArrayList<Session>();
  }

  public String getId() {
    return m_id;
  }

  public void setId(String id) {
    m_id = id;
  }

  public String getDepartment() {
    return m_department;
  }

  public void setDepartment(String department) {
    m_department = department;
  }

  public String getCode() {
    return m_code;
  }

  public void setCode(String code) {
    m_code = code;
  }

  public String getDescription() {
    return m_description;
  }

  public void setDescription(String description) {
    m_description = description;
  }

  public boolean isCancelled() {
    return m_cancelled;
  }

  public void setCancelled(boolean cancelled) {
    m_cancelled = cancelled;
  }

  public ArrayList<Session> getSessions() {
    return m_sessions;
  }

  public void addSession(Session session) {
    m_sessions.add(session);
  }

  private String m_id;
  private String m_department;
  private String m_code;
  private String m_description;
  private boolean m_cancelled = false;
  private ArrayList<Session> m_sessions;
}
