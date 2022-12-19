package CourseManager.models.education;

import java.util.ArrayList;

public class Course {
  public Course() {
    m_sessions = new ArrayList<Session>();
  }

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

  public Session returnAvailableSession() {
    if (m_sessions.isEmpty()) {
      return null;
    }

    Session session = m_sessions.get(m_sessions.size() - 1);
    if (session.getNumberOfStudents() <= session.getMaxNumberOfStudents()) {
      return session;
    }

    return null;
  }

  public int getNumberOfSessions() {
    return m_sessions.size();
  }

  @Override
  public String toString() {
    return "\nCOURSE ID: " + m_code + " DESCRIPTION: " + m_description;
  }

  @Override
  public boolean equals(Object obj) {
    return m_code.equals(((Course) (obj)).m_code);
  }

  private String m_id;
  private String m_department;
  private String m_code;
  private String m_description;
  private boolean m_cancelled = false;
  private ArrayList<Session> m_sessions;
}
