package CourseManager.models.education;

import java.util.ArrayList;
import java.util.UUID;

import CourseManager.models.academics.Faculty;
import CourseManager.models.academics.Student;

public class Session {
  public Session(UUID id, String courseId, String courseDescription, Faculty instructor, int maxNumberOfStudents,
      int minNumberOfStudents) {
    m_id = id;
    m_courseId = courseId;
    m_courseDescription = courseDescription;
    m_instructor = instructor;
    m_maxNumberOfStudents = maxNumberOfStudents;
    m_minNumberOfStudents = minNumberOfStudents;
    m_students = new ArrayList<Student>();
  }

  public UUID getId() {
    return m_id;
  }

  public void setId(UUID id) {
    m_id = id;
  }

  public String getCourseId() {
    return m_courseId;
  }

  public void setCourseId(String id) {
    m_courseId = id;
  }

  public String getCourseDescription() {
    return m_courseDescription;
  }

  public void setCourseDescription(String description) {
    m_courseDescription = description;
  }

  public int getMaxNumberOfStudents() {
    return m_maxNumberOfStudents;
  }

  public void setMaxNumberOfStudents(int maxNumberOfStudents) {
    m_maxNumberOfStudents = maxNumberOfStudents;
  }

  public int getMinNumberOfStudents() {
    return m_minNumberOfStudents;
  }

  public void setMinNumberOfStudents(int minNumberOfStudents) {
    m_minNumberOfStudents = minNumberOfStudents;
  }

  public int getNumberOfStudents() {
    return m_students.size();
  }

  public boolean isCancelled() {
    return m_cancelled;
  }

  public void setCancelled(boolean cancelled) {
    m_cancelled = cancelled;
  }

  public ArrayList<Student> getStudents() {
    return m_students;
  }

  public void addStudent(Student student) {
    m_students.add(student);
  }

  public void setInstructor(Faculty instructor) {
    m_instructor = instructor;
  }

  public Faculty getTeacher() {
    return m_instructor;
  }

  @Override
  public String toString() {
    return "SESSION ID: " + m_id + " INSTRUCTOR: " + m_instructor.getFullName() + " INSTRUCTOR ID: "
        + m_instructor.getId() + " NUMBER OF STUDENTS: " + getNumberOfStudents();
  }

  @Override
  public boolean equals(Object obj) {
    return m_id.equals(((Session) (obj)).m_id);
  }

  private UUID m_id;
  private String m_courseId;
  private String m_courseDescription;
  private int m_maxNumberOfStudents;
  private int m_minNumberOfStudents;
  private boolean m_cancelled = false;
  private Faculty m_instructor;
  private ArrayList<Student> m_students;
}
