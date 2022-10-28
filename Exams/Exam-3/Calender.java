/**
 * @Author Carlos Aguilera
 * @Date 10-27-22
 * @StudentId 1152562
 * @brief Given an input of date in the format mm dd yyyy
 * this program outputs the day of the week for the given
 * input. This is calculated by the EPOCH reference date
 * January 1, 1970
 */

import java.util.Scanner;

public class Calender {
  public static final int EXIT = 0;
  public static final int nDAYS_IN_YEAR = 365;

  public static final int[] MONTHS = {
    31, 28, 31, 30, 31, 30,
    31, 31, 30, 31, 30, 31,
  };

  public static final String[] STR_DAYS = {
    "Thursday", "Friday", "Saturday",
    "Sunday", "Monday", "Tuesday",
    "Wednesday"
  };

  public static void header() {
    System.out.println("Welcome to the Day Of Week calculator. This awesome program will tell you");
    System.out.println("what day of the week you were born on!");
    System.out.println("The program will allow you to find the day of the week for multiple dates.");
    System.out.println("When you want exit the program enter a 0 for the month, day, or year.\n");
  }

  public static int isLeapYear(int year) {
    if (year % 4 != 0) {
      return 0;
    }

    if (year % 4 == 0 && year % 100 != 0) {
      return 1;
    } 

    if (year % 400 == 0) {
      return 1;
    }
    return 0;
  }

  public static int calculateDay(int month, int day, int year) {
    int nLeapYear = 0;
    for (int i = EPOCH.YEAR; i <= year; i++) {
      nLeapYear += isLeapYear(i);
    }

    // Calculate days only up to year but not including
    int nDays = ((year - EPOCH.YEAR - 1) * nDAYS_IN_YEAR) + nLeapYear;

    // adding the remaining days
    for (int i = 0; i < month - 1; i++) {
      nDays += MONTHS[i];
    }
    nDays += day;


    // started week on thursday if 0 then back to thursday
    return nDays % 7;
  }

  public static void printDay(int day) {
    System.out.println("The day you entered was a " + STR_DAYS[day] + "\n");
  }

  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    header();
    do {
      System.out.println("Enter a date in MM DD YYYY format (example: 11 1 1970 or 6 21 2011)");
      int month = cin.nextInt();
      if (month == EXIT) {
        break;
      }
      int day = cin.nextInt();
      int year = cin.nextInt();

      printDay(calculateDay(month, day, year));
    } while (true);

    System.out.println("\nTHANK YOU FOR USING THE DAY OF WEEK CALCULATOR");
    cin.close();
  }
};

class EPOCH {
  public static final int MONTH = 1;
  public static final int DAY = 1;
  public static final int YEAR = 1970;
};