import java.util.Scanner;

class AverageCalculator {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    System.out.print("Please enter the first number: ");
    double first = cin.nextDouble();
    System.out.print("Please enter the second number: ");
    double second = cin.nextDouble();
    System.out.print("Please enter the third (and largest) number: ");
    double third = cin.nextDouble();
    cin.close();

    double average = (first + second + third) / 3;

    // Printf to remove scientific notation?
    System.out.println("\nThe average of " + first + ", " + second + ", and " + third + " is " + average);
  }
}