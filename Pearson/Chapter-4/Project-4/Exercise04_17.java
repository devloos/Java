import java.util.Scanner;
import java.util.HashMap;

class Exercise04_17 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int year = 0;
    String month;
    HashMap<String, Integer> months = new HashMap<String, Integer>() {{
      put("Jan", 31);
      put("Feb", 28);
      put("Mar", 31);
      put("Apr", 30);
      put("May", 31);
      put("Jun", 30);
      put("Jul", 31);
      put("Aug", 31);
      put("Sep", 30);
      put("Oct", 31);
      put("Nov", 30);
      put("Dec", 31);
    }};

    System.out.print("Enter a year: ");
    year = cin.nextInt();
    cin.nextLine();
    System.out.print("Enter a month: ");
    month = cin.nextLine();
    cin.close();

    if (!months.containsKey(month)) {
      System.out.println(month + " is not a correct month name");
      return;
    }

    final boolean isLeapYearF1 = (boolean)(year % 4 == 0 && year % 100 != 0);
    final boolean isLeapYearF2 = (boolean)(year % 4 == 0 && year % 100 == 0 && year % 400 == 0);

    if ((isLeapYearF1 || isLeapYearF2) && month.compareTo("Feb") == 0) {
      System.out.println(month + " " + year + " has " + 29 + " days");
      return;
    }
    System.out.println(month + " " + year + " has " + months.get(month) + " days");

  }
}

// (Days of a month) 
// Write a program that prompts the user to enter a year and the first three 
// letters of a month name (with the first letter in uppercase) and displays the number of days in the month.
// If the input for month is incorrect, display a message as shown in the following sample run.
// Sample Run 1
// Enter a year: 2001
// Enter a month: Jan
// Jan 2001 has 31 days 
// Sample Run 2
// Enter a year: 2016
// Enter a month: Feb
// Feb 2016 has 29 days
// Sample Run 3
// Enter a year: 2016 
// Enter a month: jan
// jan is not a correct month name 
// Class Name: Exercise04_17