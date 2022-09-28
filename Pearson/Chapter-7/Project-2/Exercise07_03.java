import java.util.Arrays;
import java.util.Scanner;

public class Exercise07_03 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int[] integers = new int[100];
    int size = 0;
    System.out.print("Enter the integers between 1 and 100: ");
    do {
      integers[size] = cin.nextInt();
      ++size;
    } while(integers[size - 1] != 0);
    cin.close();

    Arrays.sort(integers, 0, size - 1);

    int count = 1;
    for (int i = 1; i < size; i++) {
      if (integers[i] == integers[i - 1]) {
        ++count;
      } else {
        System.out.println(integers[i - 1] + " occurs " + count + ((count <= 1) ? " time" : " times"));
        count = 1;
      }
    }
  }
}

// (Count occurrence of numbers) 
// Write a program that reads the integers between 1 and 100 and counts the occurrences of each.
// Assume the input ends with 0.
// Sample Run
// Enter the integers between 1 and 100: 2 5 6 5 4 3 23 43 2 0
// 2 occurs 2 times
// 3 occurs 1 time
// 4 occurs 1 time
// 5 occurs 2 times
// 6 occurs 1 time
// 23 occurs 1 time
// 43 occurs 1 time 
// Note that if a number occurs more than one time, the plural word “times” is used in the output. 
// Also note that the numbers are displayed in increasing order.
// Class Name: Exercise07_03