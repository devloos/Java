import java.util.Scanner;

class Exercise05_41 {
  public static void main(String[] agrs) {
    Scanner cin = new Scanner(System.in);
    int count = 1;
    int max = 0;
    int inputNum = 0;

    System.out.print("Enter an integer (0: for end of input): ");
    inputNum = cin.nextInt();
    while (inputNum != 0) {
      if (inputNum == max) ++count;
      if (inputNum > max) {
        max = inputNum;
        count = 1;
      }
      System.out.print("Enter an integer (0: for end of input): ");
      inputNum = cin.nextInt();
    }
    cin.close();

    if (max <= 0) {
      System.out.println("No numbers are entered except 0");
      return;
    }

    System.out.println("The largest number is " + max);
    System.out.println("The occurrence count of the largest number is " + count);
  }
}


// (Occurrence of max numbers)
// Write a program that reads integers, finds the largest of them, and counts its occurrences. 
// Assume that the input ends with number 0. 
// Suppose that you entered 3 5 2 5 5 5 0; the program finds that the largest is 5 and the occurrence count for 5 is 4.
// Hint: Maintain two variables, max and count. max stores the current max number and count stores its occurrences. 
// Initially, assign the first number to max and 1 to count. Compare each subsequent number with max. 
// If the number is greater than max, assign it to max and reset count to 1. If the number is equal to max, increment count by 1.
// Sample Run 1
// Enter an integer (0: for end of input): 3
// Enter an integer (0: for end of input): 5
// Enter an integer (0: for end of input): 2
// Enter an integer (0: for end of input): 5
// Enter an integer (0: for end of input): 5
// Enter an integer (0: for end of input): 5
// Enter an integer (0: for end of input): 0
// The largest number is 5
// The occurrence count of the largest number is 4
// Sample Run 2
// Enter an integer (0: for end of input): 0
// No numbers are entered except 0
// Class Name: Exercise05_41