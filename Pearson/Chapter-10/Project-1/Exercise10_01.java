public class Exercise10_01 {
  public static void main(String[] args) {
    Time[] times = new Time[3];

    times[0] = new Time();
    times[1] = new Time(555550000);
    times[2] = new Time(5, 23, 55);

    for (Time time : times) {
      System.out.println(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond());
    }
  }
};

class Time {
  private int hour_ = 0;
  private int minute_ = 0;
  private int second_ = 0;

  public Time() {
    setTime(System.currentTimeMillis());
  }

  public Time(long elapsedTime) {
    setTime(elapsedTime);
  }

  public Time(int hour, int minute, int second) {
    hour_ = hour;
    minute_ = minute;
    second_ = second;
  }

  public void setTime(long elapsedTime) {
    hour_ = (int)((elapsedTime / 3600000) % 24);
    elapsedTime %= 3600000;

    minute_ = (int)(elapsedTime / 60000);
    elapsedTime %= 60000;

    second_ = (int)(elapsedTime / 1000);
  }

  // Getters/Setters
  public int getHour() {
    return hour_;
  }

  public void setHour(int hour) {
    hour_ = hour;
  }

  public int getMinute() {
    return minute_;
  }

  public void setMinute(int minute) {
    minute_ = minute;
  }

  public int getSecond() {
    return second_;
  }

  public void setSecond(int second) {
    second_ = second;
  }
};

// (The Time class) 
// Design a class named Time.
// The class contains:
// - The data fields hour, minute, and second that represent a time.
// - A no-arg constructor that creates a Time object for the current time. 
// (The values of the data fields will represent the current time.)
// - A constructor that constructs a Time object with a specified elapsed time since midnight, 
// January 1, 1970, in milliseconds. (The values of the data fields will represent this time.)
// - A constructor that constructs a Time object with the specified hour, minute, and second.
// - Three getter methods for the data fields hour, minute, and second, respectively.
// - A method named setTime(long elapseTime)that sets a new time for the object using the elapsed time.
// For example, if the elapsed time is 555550000 milliseconds, the hour is 10, the minute is 19, and the second is10.
// Draw the UML diagram for the class and then implement the class.
// Write a test program that creates two Timeobjects (using new Time(), new Time(555550000), 
// and new Time(5, 23, 55))and displays their hour, minute, and second in the format hour:minute:second.
// (Hint: The first two constructors will extract the hour, minute, and second from the elapsed time. 
// For the no-arg constructor, the current time can be obtained using System.currentTimeMillis(), as shown in LiveExample 2.7, ShowCurrentTime.java.)
// Class Name: Exercise10_01