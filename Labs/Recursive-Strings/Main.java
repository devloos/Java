import java.util.Scanner;
import java.lang.StackOverflowError;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    System.out.print("Enter n: ");
    final int n = cin.nextInt();

    long largestNum = (long)(Math.pow(10, n) - 1);

    // WE COULD UNWIND and print then throw error alos
    try {
      print(n, largestNum);
    } catch (StackOverflowError e) {
      System.out.println("STACK OVER FLOWWWWWW!!!");
    }

    cin.close();
  }

  public static void print(final int n, long largestNum) {
    if (largestNum < 0) return;
    print(n, largestNum - 1);
    System.out.printf("%0" + n + "d \n", largestNum);
  }
}