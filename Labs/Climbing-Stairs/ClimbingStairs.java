import java.util.Scanner;

public class ClimbingStairs {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    System.out.print("Enter number of stairs: ");
    final int n = cin.nextInt();

    System.out.print("Enter size of array: ");
    final int SIZE = cin.nextInt();
    int[] array = new int[SIZE];

    System.out.print("Enter array [separated by a space]: ");
    for (int i = 0; i < array.length; i++) {
      array[i] = cin.nextInt();
    }
    cin.close();

    System.out.println("Total number of possibilities: " + count(n, array));

    // Tried this but failed
    // for (int i = 0; i < array.length; i++) {
    //   for (int j = i + 1; j < array.length; j++) {
    //     sum += count(n, array[i], array[j]);
    //   }
    // }
  }

  public static int count(int n, int[] array) {
    if (n == 0) {
      return 1;
    } 

    int ways = 0;
    
    for (int i = 0; i < array.length; i++) {
      if (n - array[i] >= 0) {
        ways += count(n - array[i], array);
      }
    }
    return ways;
  }

  // public static int count(int n, int j, int k) {
  //   if (n == 0) {
  //     return 1;
  //   } else if (n < 0) {
  //     return 0;
  //   }
  //   return count(n - j, j, k) + count(n - j, j, k);
  // }
}