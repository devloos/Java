import java.util.Scanner;

class Exercise04_11 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int integer = 0;

    System.out.print("Enter a decimal value (0 to 15): ");
    integer = cin.nextInt();
    cin.close();
    if (integer < 0 || integer > 15) {
      System.out.println(integer + " is an invalid input");
      return;
    }
    System.out.println("The hex value is " + Integer.toHexString(integer).toUpperCase());
  }
}


// (Decimal to hex) 
// Write a program that prompts the user to enter an int between 0 and 15 and displays its corresponding hex number.
// For an incorrect input number, display invalid input.
// Sample Run 1
// Enter a decimal value (0 to 15): 11
// The hex value is B 
// Sample Run 2
// Enter a decimal value (0 to 15): 5
// The hex value is 5 
// Sample Run 3
// Enter a decimal value (0 to 15): 31
// 31 is an invalid input
// Class Name: Exercise04_11