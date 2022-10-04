import java.util.Scanner;

public class Exercise18_11 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    long n = cin.nextLong();

    System.out.println("The sum of digits in " + n + " is " + sumDigits(n));
    cin.close();
  }

  public static long sumDigits(long n) {
    long t = (n % 10) * 1;
    if (t == 0) return 0;
    return t + sumDigits(n / 10);
  }
}

// (Sum the digits in an integer using recursion)
// Write a recursive method that computes the sum of the digits in an integer. Use the following method header:
// public static int sumDigits(long n)
// For example, sumDigits(234) returns 2 + 3 + 4 = 9. Write a test program that prompts the user to enter an integer and displays its sum.
// Sample Run
// Enter an integer: 1234
// The sum of digits in 1234 is 10
// Class Name: Exercise18_11