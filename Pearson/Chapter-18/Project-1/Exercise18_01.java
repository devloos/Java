import java.math.BigInteger;
import java.util.Scanner;


public class Exercise18_01 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    System.out.print("Enter an integer of any size: ");
    BigInteger n = cin.nextBigInteger();
    cin.close();

    System.out.println("Factorial of " + n + " is " + factorial(n));
  }

  public static BigInteger factorial(BigInteger n) {
    if (n == BigInteger.ZERO) return BigInteger.ONE;
    return n.multiply(factorial(n.subtract(BigInteger.ONE)));
  }
}

// (Factorial) 
// Using the BigInteger class introduced in Section 10.9, you can find the factorial for a large number (e.g., 100!). 
// Implement the factorial method using recursion. Write a program that prompts the user to enter an integer and displays its factorial.
// Sample Run
// Enter an integer of any size: 25
// Factorial of 25 is 15511210043330985984000000
// Class Name: Exercise18_01