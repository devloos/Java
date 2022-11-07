import java.util.Scanner;

public class Exercise11_17 {
  public static int isPerfectSquare(int n) {
    int result = 0;
    for (int i = 1; result < n; i++) {
      result = (int) Math.pow(i, 2);
      if (result == n) {
        return i;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    System.out.print("Enter an integer m: ");
    final int m = cin.nextInt();

    int n = 1;
    int t = 0;
    while (true) {
      t = isPerfectSquare(m * n);
      if (t != -1) {
        break;
      }
      ++n;
    }

    System.out.println("The smallest number n for m x n to be a perfect square is " + n);
    System.out.println("m x n is " + m * n);
    cin.close();
  }
};

// (Algebra: perfect square)
// Write a program that prompts the user to enter an integer m and find the
// smallest integer n such that m * n is a perfect square.
// (Hint: Store all smallest factors of m into an array list. n is the product
// of the factors that appear an odd number of times in the array list.
// For example, consider m = 90, store the factors 2, 3, 3, 5 in an array list.
// 2 and 5 appear an odd number of times in the array list. So, n is 10.)
// Sample Run 1
// Enter an integer m: 1500
// The smallest number n for m x n to be a perfect square is 15
// m x n is 22500
// Sample Run 2
// Enter an integer m: 63
// The smallest number n for m x n to be a perfect square is 7
// m x n is 441
// Class Name: Exercise11_17