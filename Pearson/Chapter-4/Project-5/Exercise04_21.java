import java.util.Scanner;

enum LogLevel {
  Error,
  Success
}

class Exercise04_21 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    final short SSN_LENGTH = 11;
    System.out.print("Enter a SSN: ");
    String ssn = cin.nextLine();
    cin.close();
    if (ssn.length() != SSN_LENGTH) {
      Log(ssn, LogLevel.Error);
      return;
    }
    if (ssn.charAt(3) != '-' || ssn.charAt(6) != '-') {
      Log(ssn, LogLevel.Error);
      return;
    }
    try {
      Integer.parseInt(ssn.replace("-", ""));
      Log(ssn, LogLevel.Success);
    } catch (NumberFormatException err) {
      Log(ssn, LogLevel.Error);
    }
  }

  private static void Log(String ssn, LogLevel lvl) {
    switch (lvl) {
      case Error: {
        System.out.print(ssn + " is an invalid social security number");
        break;
      }
      case Success: {
        System.out.print(ssn + " is a valid social security number");
        break;
      }
    }
  }
}

// (Check SSN)
// Write a program that prompts the user to enter a Social Security Number in the format DDD-DD-DDDD, where D is a digit.
// Your program should check whether the input is valid.
// Sample Run 1
// Enter a SSN: 232-23-5435
// 232-23-5435 is a valid social security number 
// Sample Run 2
// Enter a SSN: 23-23-5435
// 23-23-5435 is an invalid social security number
// Class Name: Exercise04_21