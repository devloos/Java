import java.util.Scanner;

public class Exercise18_03 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    System.out.print("Enter the first number: ");
    int m = cin.nextInt();
    System.out.print("Enter the second number: ");
    int n = cin.nextInt();

    System.out.print("The GCD of " + m + " and " + n + " is " + gcd(m, n));
    cin.close();
  }

  public static int gcd(int m, int n) {
    int small = m % n;
    if (small == 0) return n;
    return gcd(n, small);
  }
}

// Compute greatest common divisor using recursion) 
// The gcd(m, n) can also be defined recursively as follows:
// - If m % n is 0, gcd(m, n) is n.
// - Otherwise, gcd(m, n) is gcd(n, m % n).
// Write a recursive method to find the GCD. Write a test program that prompts the user to enter two integers and displays their GCD.
// Sample Run
// Enter the first number: 3 
// Enter the second number: 7
// The GCD of 3 and 7 is 1
// Class Name: Exercise18_03