import java.util.Scanner;

public class Exercise18_21 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    System.out.print("Enter a decimal integer: ");
    int d = cin.nextInt();
    cin.close();

    System.out.println(d + " decimal is binary " + reverse(dec2Bin(d)));
  }

  public static String dec2Bin(int v) {
    if (v / 2 == 0) return "1"; 
    return (v % 2 >= 1) ? "1" + dec2Bin(v / 2) : "0" + dec2Bin(v / 2);
  }

  public static String reverse(String n) {
    String revStr = "";
    for (int i = 0; i < n.length(); i++) {
      revStr += n.charAt(n.length() - i - 1);
    }
    return revStr;
  }
}

// (Decimal to binary)
// Write a recursive method that converts a decimal number into a binary number as a string. The method header is:
// public static String dec2Bin(int value)
// Write a test program that prompts the user to enter a decimal number and displays its binary equivalent.
// Sample Run 1
// Enter a decimal integer: 35
// 35 decimal is binary 100011
// Sample Run 2
// Enter a decimal integer: 127
// 127 decimal is binary 1111111
// Class Name: Exercise18_21