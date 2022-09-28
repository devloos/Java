import java.util.Arrays;
import java.util.Scanner;

public class Exercise07_05 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    int[] numbers = new int[10];

    System.out.print("Enter ten numbers: ");
    for (int i = 0; i < numbers.length; i++)
      numbers[i] = cin.nextInt();

    int[] distinct = new int[10];
    int size = 0;
    for (int i = 0; i < numbers.length; i++) {
      boolean inArray = false;
      for (int j = 0; j < size; j++) {
        if (distinct[j] == numbers[i]) {
          inArray = true;
        }
      }
      if (!inArray) {
        distinct[size] = numbers[i];
        size++;
      }
    }

    System.out.println("The number of distinct numbers is " + size);
    System.out.print("The distinct numbers are: ");
    for (int i = 0; i < size; i++) {
      System.out.print(distinct[i] + " ");
    }
    System.out.println();
    cin.close();
  }
}

// (Print distinct numbers) 
// Write a program that reads in ten numbers and displays the number of distinct numbers 
// and the distinct numbers separated by exactly one space (i.e., if a number appears multiple times, it is displayed only once).
// (Hint: Read a number and store it to an array if it is new. If the number is already in the array, ignore it.) 
// After the input, the array contains the distinct numbers in the order of their input.
// Sample Run
// Enter ten numbers: 1 2 3 2 1 6 3 4 5 2
// The number of distinct number is 6
// The distinct numbers are: 1 2 3 6 4 5
// Class Name: Exercise07_05