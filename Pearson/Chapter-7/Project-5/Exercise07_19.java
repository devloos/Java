import java.util.Scanner;

public class Exercise07_19 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    System.out.print("Enter list: ");
    final int SIZE = cin.nextInt();
    int[] list = new int[SIZE];

    for (int i = 0; i < SIZE; i++)
      list[i] = cin.nextInt();

    if (isSorted(list)) {
      System.out.println("The list is already sorted");
    } else {
      System.out.println("The list is not sorted");
    }
    cin.close();
  }

  public static boolean isSorted(int[] list) {
    for (int i = 1; i < list.length; i++) {
      if (!(list[i] >= list[i - 1])) {
        return false;
      }
    }
    return true;
  }
}

// (Sorted?) 
// Write the following method that returns true
// if the list is already sorted in increasing order.
// public static boolean isSorted(int[] list)
// Write a test program that prompts the user to enter a list and displays whether the list is sorted or not.
// Here is a sample run. Note that the first number in the input indicates the number of the elements in the list. This number is not part of the list.
// Sample Run 1
// Enter list: 8 10 1 5 16 61 9 11 1
// The list is not sorted 
// Sample Run 2
// Enter list: 10 1 1 3 4 4 5 7 9 11 21
// The list is already sorted
// Class Name: Exercise07_19